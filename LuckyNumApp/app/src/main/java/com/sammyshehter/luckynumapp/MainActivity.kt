package com.sammyshehter.luckynumapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.sammyshehter.luckynumapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val elements: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        elements.welcomeMessage = "Welcome to Lucky Number!"
        elements.btnText = "Wish me luck!"

        val btn = elements.btn
        val editTextSection = elements.editText

        btn.setOnClickListener() btnListener@  {
            var name: Editable? = editTextSection.text
            if (name.isNullOrEmpty()) {
                Toast.makeText(this, "Please enter the name first", Toast.LENGTH_LONG).show()
                return@btnListener
            }
            val i = Intent(this, LuckyNumberActivity::class.java)
            i.putExtra("name", name.toString())
            startActivity(i)
        }

    }
}