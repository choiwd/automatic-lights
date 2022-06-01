package io.grpc.examples.helloworld

import android.net.Uri
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

data class Contents(
    var lightState: Boolean = false,
    var participants: List<String> = listOf<String>(),
    var intensity: Int = 0,
    var voteID: Int = 0
)

class MainViewModel : ViewModel() {
    val state = MutableLiveData<Contents>()

    //insert server ipv4 address here.
    private val uri by lazy { Uri.parse("http://172.17.23.78:50051/") }
    private val automaticLightsService by lazy { AutomaticLightsRCP(uri) }

    init {
        state.value = Contents()
        runQuery()
    }

    fun requestStateChange() {
        viewModelScope.launch {
            automaticLightsService.requestStateChange(!state.value!!.lightState)
            state.value = state.value!!.copy(
                lightState = automaticLightsService.lightState,
                voteID = automaticLightsService.voteID
            )
        }
    }

    private fun runQuery() {
        viewModelScope.launch {
            while (true){
                automaticLightsService.makeQuery()
                state.value = Contents(
                    lightState = automaticLightsService.lightState,
                    voteID = automaticLightsService.voteID,
                    participants = automaticLightsService.participants,
                    intensity = automaticLightsService.intensity
                )
                val n = 5
                delay(n.seconds)
            }
        }
    }
}