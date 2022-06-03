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
                Intent(this@MainActivity, MyIntentService::class.java).also{
                    startService(it)
                    tvServiceLog.text = "Service running"
                }
            }

            btnStopService.setOnClickListener {
                MyIntentService.stopService()
                tvServiceLog.text = "Service stopped"
            }


        }
    }
}