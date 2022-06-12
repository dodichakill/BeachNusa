package com.chakil.beachnusa

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CardDetailActivity: AppCompatActivity() {
    companion object{
        const val KEY_CARD = "key_card"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_item)

        val dataCard = intent.getParcelableExtra<Card>(KEY_CARD) as Card
        findViewById<TextView>(R.id.detail_name).text = dataCard.name
        findViewById<TextView>(R.id.detail_desc).text = dataCard.desc
        findViewById<ImageView>(R.id.detail_img).setImageResource(dataCard.photo)
    }
}