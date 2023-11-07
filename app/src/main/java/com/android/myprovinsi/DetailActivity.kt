package com.android.myprovinsi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.myprovinsi.databinding.ActivityDetailBinding
import com.android.myprovinsi.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvNameProvinsi.text = intent.getStringExtra("name")
        binding.tvProvinsiDescription.text = intent.getStringExtra("desc")
        binding.imgProvinsi.setImageResource(intent.getIntExtra("poto", 0))
    }
}