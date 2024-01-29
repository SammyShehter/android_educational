package com.sammyshehter.frenchteache

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.databinding.DataBindingUtil
import com.sammyshehter.frenchteache.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val elements =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

    }

    fun sayTheColor(view: View) {
        val clickedButton: Button = view as Button

        var mediaPlayer = MediaPlayer.create(this, resources.getIdentifier(clickedButton.tag.toString(), "raw", packageName))
        mediaPlayer.start()
    }
}