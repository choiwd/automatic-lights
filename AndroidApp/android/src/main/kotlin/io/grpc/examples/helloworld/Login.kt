package io.grpc.examples.helloworld

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import io.grpc.examples.helloworld.databinding.LoginBinding
import java.io.File
import java.net.Inet4Address
import kotlin.reflect.KProperty

data class initialParameters(
    var serverAddress: String = "",
    var userName: String = "",
)

class Login : AppCompatActivity(){

    private lateinit var binding: LoginBinding

    private lateinit var myViewModel: MainViewModel

    companion object{
        lateinit var address : String
        lateinit var name : String
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = LoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.enterButton.setOnClickListener {
            address = binding.ServerAddress.text.toString()
            name = binding.UserName.text.toString()

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}