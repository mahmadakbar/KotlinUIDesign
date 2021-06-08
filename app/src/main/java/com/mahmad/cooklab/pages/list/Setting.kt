package com.mahmad.cooklab.pages.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.mahmad.cooklab.R

class Setting : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        //toolbar
        val toolbarBack: Button = findViewById(R.id.back_appBar)
        val toolbar: TextView = findViewById(R.id.text_appBar)

        toolbarBack.visibility = View.VISIBLE
        toolbarBack.setOnClickListener{
            super.onBackPressed()
        }

        toolbar.text = getString(R.string.setting) // toolbar
    }
}