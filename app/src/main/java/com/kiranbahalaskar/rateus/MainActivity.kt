package com.kiranbahalaskar.rateus

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var btnRateUs: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnRateUs = findViewById(R.id.btnRateUs)

        btnRateUs.setOnClickListener {
            val uri: Uri = Uri.parse("market://details?id=com.kiranbahalaskar.androidinterviewquestions")
            val goToMarket = Intent(Intent.ACTION_VIEW, uri)

            goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY or
                                Intent.FLAG_ACTIVITY_NEW_DOCUMENT or
                                Intent.FLAG_ACTIVITY_MULTIPLE_TASK)

            try {
                startActivity(goToMarket)
            }catch (e: ActivityNotFoundException){
                startActivity(Intent(Intent.ACTION_VIEW,
                Uri.parse("https://play.google.com/store/apps/details?id=com.kiranbahalaskar.androidinterviewquestions")))
            }
        }

    }
}