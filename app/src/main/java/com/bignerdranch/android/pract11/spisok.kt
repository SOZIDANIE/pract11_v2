package com.bignerdranch.android.pract11

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ScrollView
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson

class spisok : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spisok)
        val rw = findViewById<RecyclerView>(R.id.rw)
        val intent = Intent(this, spisok :: class.java)
        val z = intent.getStringExtra("nazvanie")
        val x = intent.getStringExtra("avtor")
        val c = intent.getStringExtra("kolichestvo")

    }

}