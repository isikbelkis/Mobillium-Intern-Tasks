package com.mobillium.interntasks2a

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.mobillium.interntasks2a.databinding.ActivityMainBinding
import com.mobillium.interntasks2a.ui.case1.ListActivity
import com.mobillium.interntasks2a.ui.case2.FragmentMainActivity

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ActivityButton.setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }
        binding.fragmentButton.setOnClickListener {
            val intent=Intent(this,FragmentMainActivity::class.java)
            startActivity(intent)
        }
    }
}