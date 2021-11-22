package co.edu.eam.mytestapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import co.edu.eam.mytestapp.databinding.ActivityRecuperarPassBinding
import com.google.firebase.auth.FirebaseAuth

class RecuperarPass : AppCompatActivity() {
    lateinit var  binding: ActivityRecuperarPassBinding
    private lateinit var mAuth:FirebaseAuth

    lateinit var dialog:Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecuperarPassBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mAuth = FirebaseAuth.getInstance()
        binding.btnAceptar.setOnClickListener{
            val email = binding.emailUser.text.toString()
            if (email.isNotEmpty()) {
                mAuth.sendPasswordResetEmail(email)
                    .addOnCompleteListener() { task ->
                        if(task.isSuccessful) {
                            Toast.makeText(baseContext,"Se a enviado un email", Toast.LENGTH_LONG).show()
                            finish()
                        }
                    }
            }
        }
    }

}