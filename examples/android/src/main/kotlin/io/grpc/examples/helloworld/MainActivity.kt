package io.grpc.examples.helloworld

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import io.grpc.ManagedChannelBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.asExecutor
import kotlinx.coroutines.launch
import java.io.Closeable
import kotlinx.coroutines.*

import android.graphics.Color
import androidx.lifecycle.ViewModel
import io.grpc.examples.helloworld.databinding.ActivityMainBinding
import se.queryMessage
import se.requestMessage
import java.time.Duration
import kotlin.time.Duration.Companion.microseconds
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    var lightState = false
    var participants = listOf<String>()
    var intensity = 0
    var voteID = 0

    private val uri by lazy { Uri.parse(resources.getString(R.string.server_url)) }
    private val automaticLightsService by lazy { AutomaticLightsRCP(uri) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        updateView()
        binding.lightbulb.setOnClickListener{
            GlobalScope.launch {
                automaticLightsService.requestStateChange(!lightState)
                updateView()
            }
        }
        binding.simpleButtom.setOnClickListener{
            GlobalScope.launch {
                automaticLightsService.requestStateChange(!lightState)
                updateView()
            }
        }

        // Make query every n seconds
        val n = 5
        // Use MainScope() instead of GlobalScope?
        GlobalScope.launch {
            while (true) {
                automaticLightsService.makeQuery()

                lightState = automaticLightsService.lightState
                participants = automaticLightsService.participants
                intensity = automaticLightsService.intensity
                voteID = automaticLightsService.voteID

                // If a vote ID is found, we should ask the user their vote.
                if (voteID != 0){
                    // Not implemented
                    // https://developer.android.com/guide/topics/ui/dialogs
                }

                delay(n.seconds)
            }
        }
    }

    private fun updateView() {
        if (lightState) {
            binding.lightbulb.drawable.setTint(Color.YELLOW)
            binding.stateDescription.text = "I'm on :D"
            binding.simpleButtom.text = "Turn off :D"
        } else {
            binding.stateDescription.text = "I'm off :D"
            binding.lightbulb.drawable.setTint(Color.BLACK)
            binding.simpleButtom.text = "Turn on :D"
        }

        var list = ""
        if (participants.isEmpty()){
            list = "Room is empty"
        }else{
            for (person in participants){
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
