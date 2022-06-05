package io.grpc.examples.helloworld

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.grpc.examples.helloworld.databinding.LoginBinding

class Login : AppCompatActivity(){

    private lateinit var binding: LoginBinding

    // Global variable containing server address and user name.
    companion object{
        lateinit var address : String
        lateinit var name : String
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = LoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // On click, sets global parameters and lauches second activity
        binding.enterButton.setOnClickListener {
            address = binding.ServerAddress.text.toString()
            name = binding.UserName.text.toString()

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}