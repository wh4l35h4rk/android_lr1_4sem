package com.example.testapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val list = mutableListOf<Message>()
        for (i in 0..30) {
            list.add(Message(
                ttype=Message.set_type(),
                name=Message.set_name(),
                ttime="${i}:00",
                text=Message.set_text()))
        }
        binding.recycler.adapter = MessageListAdapter(list)
    }
}