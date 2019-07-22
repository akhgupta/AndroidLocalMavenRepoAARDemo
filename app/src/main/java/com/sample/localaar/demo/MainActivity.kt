package com.sample.localaar.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sample.localaar.myawesomemodule1.AwesomeModule1
import com.sample.localaar.myawesomemodule2.AwesomeModule2
import com.sample.localaar.myawesomemodule3.AwesomeModule3
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView2.text= AwesomeModule1.greet
        textView3.text= AwesomeModule2.greet
        textView4.text= AwesomeModule3.greet
    }
}