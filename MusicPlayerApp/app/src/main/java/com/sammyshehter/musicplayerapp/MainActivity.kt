package com.sammyshehter.musicplayerapp

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.sammyshehter.musicplayerapp.databinding.ActivityMainBinding
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var startTime: Double = 0.0
        var finalTime: Double = 0.0
        var forwardTime = 10000
        var backwardTime = 10000
        var oneTimeOnly = 0
        var handler: Handler = Handler()

        val elements =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        val mediaPlayer = MediaPlayer.create(this, R.raw.trap_bach)
        val seekBar = elements.seekBar
        val playBtn = elements.playButton
        val pauseBtn = elements.pauseButton
        val fastForward = elements.fastForward
        val fastBackward = elements.fastBackwards

        val updateSongTime: Runnable = object : Runnable {
            override fun run() {
                startTime = mediaPlayer.currentPosition.toDouble()
                elements.timeLeft = "" + String.format(
                    "%d:%d",
                    TimeUnit.MILLISECONDS.toMinutes(startTime.toLong()),
                    TimeUnit.MILLISECONDS.toSeconds(startTime.toLong()) - TimeUnit.MINUTES.toSeconds(
                        TimeUnit.MILLISECONDS.toMinutes(startTime.toLong())
                    )
                )

                seekBar.progress = startTime.toInt()
                handler.postDelayed(this, 100)
            }
        }
        elements.welcomeText = "Music Player App"

        seekBar.isClickable = false
        playBtn.setOnClickListener() {
            playBtn.visibility = View.INVISIBLE
            pauseBtn.visibility = View.VISIBLE
            mediaPlayer.start()
            finalTime = mediaPlayer.duration.toDouble()
            startTime = mediaPlayer.currentPosition.toDouble()

            if (oneTimeOnly == 0) {
                seekBar.max = finalTime.toInt()
                oneTimeOnly = 1
            }

            elements.timeLeft = startTime.toString()
            seekBar.setProgress(startTime.toInt())
            elements.songTitle = ""+resources.getResourceEntryName(R.raw.trap_bach)
            handler.postDelayed(updateSongTime, 100)

        }

        pauseBtn.setOnClickListener() {
            pauseBtn.visibility = View.INVISIBLE
            playBtn.visibility = View.VISIBLE
            mediaPlayer.pause()
        }

        fastForward.setOnClickListener() wrongTiming@ {
            val temp = startTime
            if((temp + forwardTime) >= finalTime) {
                Toast.makeText(this, "Cant fast forward now", Toast.LENGTH_LONG).show()
                return@wrongTiming
            }

            startTime += forwardTime
            mediaPlayer.seekTo(startTime.toInt())
        }

        fastBackward.setOnClickListener() wrongTiming@ {
            val temp = startTime
            if((temp - backwardTime) < 0) {
                Toast.makeText(this, "Can't fast backward now", Toast.LENGTH_LONG).show()
                return@wrongTiming
            }

            startTime -= backwardTime
            mediaPlayer.seekTo(startTime.toInt())
        }
    }
}