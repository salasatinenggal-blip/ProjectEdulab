package com.example.projectedulab

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class TemplateDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_template_detail)

        val title = intent.getStringExtra("TITLE")
        val pages = intent.getStringExtra("PAGES")
        val imageRes = intent.getIntExtra("IMAGE", 0)
        val file = intent.getStringExtra("FILE")

        findViewById<TextView>(R.id.tvTitle).text = title
        findViewById<TextView>(R.id.tvPages).text = pages
        findViewById<ImageView>(R.id.ivCover).setImageResource(imageRes)

        val btnUse = findViewById<Button>(R.id.btnUseTemplate)
        btnUse.setOnClickListener {
            val i = Intent(this, EditTemplateActivity::class.java)
            i.putExtra("FILE", file)
            i.putExtra("TITLE", title)
            startActivity(i)
        }
    }
}
