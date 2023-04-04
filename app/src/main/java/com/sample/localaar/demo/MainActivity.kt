package com.sample.localaar.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sample.localaar.demo.databinding.ActivityMainBinding
import com.sample.localaar.myawesomemodule1.AwesomeModule1
import com.sample.localaar.myawesomemodule2.AwesomeModule2
import com.sample.localaar.myawesomemodule3.AwesomeModule3

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textView2.text = AwesomeModule1.greet
        binding.textView3.text = AwesomeModule2.greet
        binding.textView4.text = AwesomeModule3.greet
    }
}