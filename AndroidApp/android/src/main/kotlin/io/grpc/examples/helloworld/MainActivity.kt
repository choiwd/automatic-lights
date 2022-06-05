package io.grpc.examples.helloworld

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.grpc.ManagedChannelBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.asExecutor
import java.io.Closeable

import android.graphics.Color
import androidx.activity.viewModels
import io.grpc.examples.helloworld.databinding.ActivityMainBinding
import se.queryMessage
import se.requestMessage

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainViewModel.state.observe(this) { contents ->
            updateView(contents)
        }

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Define actions to be performed on click
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

        if (state.intensity == 1){
            binding.stateDescription.text = binding.stateDescription.text.toString() + " and the room is dark"
        }
        else{
            binding.stateDescription.text = binding.stateDescription.text.toString() + " and the room is bright"
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

        if (state.voteID != 0){
            // NOT IMPLEMENTED. The vote system was supposed to be
            // called here.
        }
    }
}

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
            e.printStackTrace()
        }
    }

    suspend fun makeQuery(){
        try {
            val request = queryMessage.newBuilder()
                .setOnOff(false)
                .setVoteID(0)
                .setIntensity(0)
                .setName(Login.name)
                .build()
            val response = ALCLient.status(request)
            lightState = response.onOff
            intensity = response.intensity
            participants = response.participantsList

            // Next steps hook. If this is not 0, make a vote.
            voteID = response.voteID
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun close() {
        channel.shutdownNow()
    }
}
