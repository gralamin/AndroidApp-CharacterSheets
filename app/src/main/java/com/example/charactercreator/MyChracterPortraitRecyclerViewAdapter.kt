package com.example.charactercreator

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.charactercreator.databinding.FragmentItemBinding
import com.example.charactercreator.models.CharacterSummary
import com.example.charactercreator.placeholder.PlaceholderContent.PlaceholderItem


/**
 * [RecyclerView.Adapter] that can display a [CharacterSummary].
 */
class MyChracterPortraitRecyclerViewAdapter(
    private val values: List<CharacterSummary>
) : RecyclerView.Adapter<MyChracterPortraitRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.idView.text = item.characterName
        holder.contentView.text = item.sheetType
        val res: Drawable = holder.itemView.context.getResources().getDrawable(R.drawable.ic_placeholder)
        holder.imageView.setImageDrawable(res)
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.characterName
        val contentView: TextView = binding.sheetTypeLabel
        val imageView: ImageView = binding.characterImage

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }

}