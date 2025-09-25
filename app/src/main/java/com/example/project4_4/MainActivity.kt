package com.example.project4_4

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.project4_4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setUIVisibility(false)

        binding.switch1.setOnCheckedChangeListener { _, isChecked ->
            setUIVisibility(isChecked)

            if (isChecked) {
                binding.radioGroup.clearCheck()
                binding.imageView2.setImageDrawable(null)
            }
        }

        binding.radioButton1.setOnClickListener {
            binding.imageView2.setImageResource(R.drawable.oreo)
        }

        binding.radioButton2.setOnClickListener {
            binding.imageView2.setImageResource(R.drawable.pie)
        }

        binding.radioButton3.setOnClickListener {
            binding.imageView2.setImageResource(R.drawable.q10)
        }

        binding.button1.setOnClickListener {
            finish()
        }

        binding.button2.setOnClickListener {
            resetUI()
        }
    }

    private fun setUIVisibility(visible: Boolean) {
        val visibility = if (visible) View.VISIBLE else View.INVISIBLE
        binding.textView2.visibility = visibility
        binding.radioGroup.visibility = visibility
        binding.imageView2.visibility = visibility
        binding.button1.visibility = visibility
        binding.button2.visibility = visibility
    }

    private fun resetUI() {
        binding.switch1.isChecked = false
        binding.imageView2.setImageDrawable(null)
        binding.textView2.visibility = View.INVISIBLE
        binding.radioButton1.isChecked = false
        binding.radioButton2.isChecked = false
        binding.radioButton3.isChecked = false
        setUIVisibility(false)
    }
}