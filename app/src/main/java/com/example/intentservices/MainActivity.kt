package com.example.intentservices

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intentservices.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.apply {

            btnStartService.setOnClickListener {
                Intent(this@MainActivity, MyService::class.java).also{
                    startService(it)
                    tvServiceLog.text = "Service running"
                }
            }

            btnStopService.setOnClickListener {
                Intent(this@MainActivity, MyService::class.java).also{
                    stopService(it)
                    tvServiceLog.text = "Service stopped"
                }
            }

            btnSendData.setOnClickListener {
                Intent(this@MainActivity, MyService::class.java).also {
                    val dataString = etData.text.toString()
                    it.putExtra("EXTRA_DATA", dataString)
                    startService(it)
                }
            }


        }
    }
}