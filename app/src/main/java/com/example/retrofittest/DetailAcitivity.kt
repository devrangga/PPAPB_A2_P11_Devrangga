package com.example.retrofittest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide

class DetailAcitivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        Glide.with(this).load(intent.getStringExtra("detail_image")).into(findViewById(R.id.imageDetail))
    }
}