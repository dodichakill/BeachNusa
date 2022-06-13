package com.chakil.beachnusa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //set listView
        val listView: ListView = findViewById(R.id.lv_list)
        val adapter = CardAdapter()
        listView.adapter = adapter

        //save data dari resource
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDesc = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)

        //insert data ke data class card
         val cards = arrayListOf<Card>()
        for (position in dataName.indices) {
            val card = Card(
                dataPhoto.getResourceId(position, -1),
                dataName[position],
                dataDesc[position]
            )
            cards.add(card)
        }

        //insert data class ke adapter
        adapter.cards = cards

        //memberikan aksi ketika list diklik
        listView.onItemClickListener = AdapterView.OnItemClickListener{
            _, _, position, _ ->
            val intent = Intent(this, CardDetailActivity::class.java)
            intent.putExtra(CardDetailActivity.KEY_CARD, cards[position])
            startActivity(intent)
        }

        //navigasi
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.mainContainer) as NavHostFragment
        navController = navHostFragment.navController

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        setupWithNavController(bottomNavigationView, navController)
    }
}