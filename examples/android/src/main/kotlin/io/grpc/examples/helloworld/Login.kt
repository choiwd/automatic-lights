package io.grpc.examples.helloworld

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.grpc.examples.helloworld.databinding.LoginBinding

data class initialParameters(
    var serverAddress: String = "",
    var userName: String = "",
)

class Login : AppCompatActivity(){

    private lateinit var binding: LoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = LoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.enterButton.setOnClickListener {
            val address = binding.ServerAddress.text.toString()
            val name = binding.UserName.text.toString()

            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra("name", name)
                putExtra("address", address)
            }
            startActivity(intent)
        }

    }
}