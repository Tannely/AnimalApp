package com.example.animalapp
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val animals = listOf(
        Animal("lion", "Cat with a large mane", R.drawable.lion),
        Animal("Elephant", "Elephant with big ears", R.drawable.elephant),
        Animal("Zebra", "Jumper with striped skin", R.drawable.zebra)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = AnimalAdapter(animals) { animal ->
            val intent = Intent(this, AnimalDetailActivity::class.java)
            intent.putExtra("animal", animal)
            startActivity(intent)
        }
    }
}