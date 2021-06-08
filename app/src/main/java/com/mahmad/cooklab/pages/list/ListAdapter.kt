package com.mahmad.cooklab.pages.list

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mahmad.cooklab.R

@Suppress("DEPRECATION")
class ListAdapter(private val listCard: ArrayList<CardData>) : RecyclerView.Adapter<ListAdapter.ListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.fragment_home_row, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListAdapter.ListViewHolder, potition: Int) {
        val cards = listCard[potition]
        Glide.with(holder.itemView.context)
            .load(cards.image)
            .apply(RequestOptions().override(70, 70))
            .into(holder.imgPhoto)
        Glide.with(holder.itemView.context)
            .load(cards.star)
            .into(holder.tvStars)
        holder.tvName.text = cards.name
        holder.tvUserName.text = cards.user
        holder.tvRatting.text = cards.ratting
        holder.tvView.text = cards.view

        holder.clickList.setOnClickListener{
            val contexCard = holder.clickList.context
            val intent = Intent(contexCard, Details::class.java)

            intent.putExtra(Details.RECIPE_IMAGE, listCard[holder.adapterPosition].image)
            intent.putExtra(Details.RECIPE_NAME, listCard[holder.adapterPosition].name)
            intent.putExtra(Details.RECIPE_UNAME, listCard[holder.adapterPosition].user)
            intent.putExtra(Details.RECIPE_DESC, listCard[holder.adapterPosition].descripion)
            intent.putExtra(Details.RECIPE_RATTING, listCard[holder.adapterPosition].ratting)
            intent.putExtra(Details.RECIPE_STAR, listCard[holder.adapterPosition].star)
            intent.putExtra(Details.RECIPE_VIEW, listCard[holder.adapterPosition].view)
            intent.putExtra(Details.RECIPE_COMMENT, listCard[holder.adapterPosition].coment)
            intent.putExtra(Details.RECIPE_SHARE, listCard[holder.adapterPosition].share)
            intent.putExtra(Details.RECIPE_INGRED, listCard[holder.adapterPosition].bahan)
            intent.putExtra(Details.RECIPE_INSTRUCT, listCard[holder.adapterPosition].instruksi)
            contexCard.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return listCard.size
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_photo_row)
        var tvName: TextView = itemView.findViewById(R.id.judul_masakan_row)
        var tvUserName: TextView = itemView.findViewById(R.id.user_name_row)
        var tvRatting: TextView = itemView.findViewById(R.id.ratting_row)
        var tvStars: ImageView = itemView.findViewById(R.id.five_star_row)
        var tvView: TextView = itemView.findViewById(R.id.views_row)

        var clickList: LinearLayout = itemView.findViewById(R.id.grid_view)
    }
}