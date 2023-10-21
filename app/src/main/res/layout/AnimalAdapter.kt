package layout
import Animal
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.animalapp.Animal

import androidx.recyclerview.widget.RecyclerView
class AnimalAdapter (private val animals: List<Animal>, private val clickListener: (Animal) -> Unit) :
    RecyclerView.Adapter<AnimalAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.animalNameTextView)
        val descriptionTextView: TextView = itemView.findViewById(R.id.animalDescriptionTextView)
        val imageView: ImageView = itemView.findViewById(R.id.animalImageView)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_animal, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val animal = animals[position]
        holder.nameTextView.text = animal.name
        holder.descriptionTextView.text = animal.description
        holder.imageView.setImageResource(animal.imageResId)

        holder.itemView.setOnClickListener { clickListener(animal) }
    }

    override fun getItemCount(): Int {
        return animals.size
    }
}

