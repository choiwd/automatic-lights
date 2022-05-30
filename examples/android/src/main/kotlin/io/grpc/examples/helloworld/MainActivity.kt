package io.grpc.examples.helloworld

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.grpc.ManagedChannelBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.asExecutor
import kotlinx.coroutines.launch
import java.io.Closeable
import kotlinx.coroutines.*

import android.graphics.Color
import androidx.activity.viewModels
import io.grpc.examples.helloworld.databinding.ActivityMainBinding
import se.queryMessage
import se.requestMessage
import kotlin.time.Duration.Companion.seconds

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val mainViewModel: MainViewModel by viewModels()

    //private val uri by lazy { Uri.parse(resources.getString(R.string.server_url)) }
    //private val uri by lazy { Uri.parse("172.23.112.1:5000") }
    //private val uri by lazy { Uri.parse("http://localhost:50051") }
    //private val automaticLightsService by lazy { AutomaticLightsRCP(uri) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainViewModel.state.observe(this) { contents ->
            updateView(contents)
        }

        print(resources.getString(R.string.server_url))
        //participants = listOf(resources.getString(R.string.server_url))

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.lightbulb.setOnClickListener{
            mainViewModel.requestStateChange()
        }
        binding.simpleButtom.setOnClickListener{
            mainViewModel.requestStateChange()
        }
    }

    private fun updateView(state : Contents) {

        if (state.lightState) {
            binding.lightbulb.drawable.setTint(Color.YELLOW)
            binding.stateDescription.text = "I'm on :D"
            binding.simpleButtom.text = "Turn off :D"
        } else {
            binding.stateDescription.text = "I'm off :D"
            binding.lightbulb.drawable.setTint(Color.BLACK)
            binding.simpleButtom.text = "Turn on :D"
        }

        var list = ""
        if (state.participants.isEmpty()){
            list = "Room is empty"
        }else{
            for (person in state.participants){
                list += person + "\n"
            }
        }
        binding.ListOfPeople.text = list
    }

//    private val uri by lazy { Uri.parse(resources.getString(R.string.server_url)) }
//    private val greeterService by lazy { GreeterRCP(uri) }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        setContent {
//            Surface(color = MaterialTheme.colors.background) {
//                Greeter(greeterService)
//            }
//        }
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        greeterService.close()
//    }
}

//class GreeterRCP(uri: Uri) : Closeable {
//    val responseState = mutableStateOf("")
//
//    private val channel = let {
//        println("Connecting to ${uri.host}:${uri.port}")
//
//        val builder = ManagedChannelBuilder.forAddress(uri.host, uri.port)
//        if (uri.scheme == "https") {
//            builder.useTransportSecurity()
//        } else {
//            builder.usePlaintext()
//        }
//
//        builder.executor(Dispatchers.IO.asExecutor()).build()
//    }
//
//    private val greeter = GreeterGrpcKt.GreeterCoroutineStub(channel)
//
//    suspend fun sayHello(name: String) {
//        try {
//            val request = helloRequest { this.name = name }
//            val response = greeter.sayHello(request)
//            responseState.value = response.message
//        } catch (e: Exception) {
//            responseState.value = e.message ?: "Unknown Error"
//            e.printStackTrace()
//        }
//    }
//
//    override fun close() {
//        channel.shutdownNow()
//    }
//}

class AutomaticLightsRCP(uri: Uri) : Closeable {
    var lightState = false
    var participants = listOf("")
    var intensity = 0
    var voteID = 0

    private val channel = let {
        println("Connecting to ${uri.host}:${uri.port}")

        val builder = ManagedChannelBuilder.forAddress(uri.host, uri.port)
        if (uri.scheme == "https") {
            builder.useTransportSecurity()
        } else {
            builder.usePlaintext()
        }

        builder.executor(Dispatchers.IO.asExecutor()).build()
    }

    private val ALCLient = se.AutomaticLightsGrpcKt.AutomaticLightsCoroutineStub(channel)

    suspend fun requestStateChange(state: Boolean){
        try {
            val request = requestMessage.newBuilder()
                .setOnOff(state)
                .setVoteID(voteID)
                .build()
            val response = ALCLient.turnOnOff(request)
            lightState = response.onOff
            voteID = response.voteID
        } catch (e: Exception) {
            // What's this? '-'
            //responseState.value = e.message ?: "Unknown Error"
            e.printStackTrace()
        }
    }

    suspend fun makeQuery(){
        try {
            val request = queryMessage.newBuilder()
                .setOnOff(false)
                .setVoteID(0)
                .setIntensity(0)
                .build()
            val response = ALCLient.status(request)
            lightState = response.onOff
            intensity = response.intensity
            participants = response.participantsList

            // Next steps hook. If this is not 0, make a vote.
            voteID = response.voteID
        } catch (e: Exception) {
            // What's this? '-'
            //responseState.value = e.message ?: "Unknown Error"
            e.printStackTrace()
        }
    }

    override fun close() {
        channel.shutdownNow()
    }
}

//@Composable
//fun Greeter(greeterRCP: GreeterRCP) {
//
//    val scope = rememberCoroutineScope()
//
//    val nameState = remember { mutableStateOf(TextFieldValue()) }
//
//    Column(Modifier.fillMaxWidth().fillMaxHeight(), Arrangement.Top, Alignment.CenterHorizontally) {
//        Text(stringResource(R.string.name_hint), modifier = Modifier.padding(top = 10.dp))
//        OutlinedTextField(nameState.value, { nameState.value = it })
//
//        Button({ scope.launch { greeterRCP.sayHello(nameState.value.text) } }, Modifier.padding(10.dp)) {
//        Text(stringResource(R.string.send_request))
//        }
//
//        Button({ scope.launch { greeterRCP.sayHello(nameState.value.text) } }, Modifier.padding(10.dp)) {
//            Text("Oi, caralho")
//        }
//
//        if (greeterRCP.responseState.value.isNotEmpty()) {
//            Text(stringResource(R.string.server_response), modifier = Modifier.padding(top = 10.dp))
//            Text(greeterRCP.responseState.value)
//        }
//    }
//}
