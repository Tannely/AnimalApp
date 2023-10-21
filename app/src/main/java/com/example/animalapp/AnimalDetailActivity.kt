package com.example.animalapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_animal_detail.*

class AnimalDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_detail)

        val animal = intent.getParcelableExtra<Animal>("animal")
        if (animal != null) {
            detailAnimalImageView.setImageResource(animal.imageResId)
            detailAnimalNameTextView.text = animal.name
            detailAnimalDescriptionTextView.text = animal.description
        }
    }
}