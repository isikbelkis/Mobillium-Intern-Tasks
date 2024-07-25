package com.mobillium.interntasks2a.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mobillium.interntasks2a.databinding.ActivityMainBinding
import com.mobillium.interntasks2a.ui.case1.ListActivity
import com.mobillium.interntasks2a.ui.case2.FragmentMainActivity
import com.mobillium.interntasks2a.ui.case3.NavFragmentActivity

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.activityButton.setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }
        binding.fragmentButton.setOnClickListener {
            val intent=Intent(this,FragmentMainActivity::class.java)
            startActivity(intent)
        }
        binding.navFragmentButton.setOnClickListener {
            val intent=Intent(this,NavFragmentActivity::class.java)
            startActivity(intent)
        }
    }
}