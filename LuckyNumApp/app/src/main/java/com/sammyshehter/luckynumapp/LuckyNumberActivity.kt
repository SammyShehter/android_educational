package com.sammyshehter.luckynumapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.sammyshehter.luckynumapp.databinding.ActivityLuckyNumberBinding
import kotlin.random.Random

class LuckyNumberActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lucky_number)

        val elements: ActivityLuckyNumberBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_lucky_number)

        elements.luckyText = "Your lucky number is:"
        elements.shareText = "Share the lucky number"

        val shareBtn = elements.button

        val username = receiveUserName()
        val randNum = Random.nextInt(1000)

        elements.luckyNumber = randNum.toString()

        shareBtn.setOnClickListener() {
            shareData(username, randNum)
        }

    }

    private fun receiveUserName(): String {
        var bundle: Bundle? = intent.extras

        if (bundle != null) {
            return bundle.getString("name", "Harold")
        }
        return "Harold"
    }

    private fun shareData(username: String, num: Int) {
        val i = Intent(Intent.ACTION_SEND)
        i.setType("text/plain")
        i.putExtra(Intent.EXTRA_SUBJECT, "$username is lucky today!")
        i.putExtra(Intent.EXTRA_TEXT, "Today lucky number is $num")
        startActivity(i)
    }

}