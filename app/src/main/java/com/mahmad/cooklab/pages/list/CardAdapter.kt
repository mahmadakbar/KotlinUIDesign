package com.mahmad.cooklab.pages.list

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mahmad.cooklab.R

@Suppress("DEPRECATION")
open class CardAdapter(private val listCard: ArrayList<CardData>) : RecyclerView.Adapter<CardAdapter.CardViewViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardAdapter.CardViewViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.fragment_list_card, parent, false)
        return CardViewViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardAdapter.CardViewViewHolder, position: Int) {
        val cards = listCard[position]
        Glide.with(holder.itemView.context)
            .load(cards.image)
            .apply(RequestOptions().override(672, 755))
            .into(holder.imgPhoto)
        Glide.with(holder.itemView.context)
            .load(cards.star)
            .into(holder.tvStars)
        holder.tvName.text = cards.name
        holder.tvUserName.text = cards.user
        holder.tvDescripion.text = cards.descripion
        holder.tvRatting.text = cards.ratting
        holder.tvView.text = cards.view
        holder.tvComment.text = cards.coment
        holder.tvShare.text = cards.share

        
        holder.clickCard.setOnClickListener{
            val contexCard = holder.clickCard.context
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

    inner class CardViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_card_photo)
        var tvName: TextView = itemView.findViewById(R.id.judul_masakan_card)
        var tvUserName: TextView = itemView.findViewById(R.id.user_name_card)
        var tvDescripion: TextView = itemView.findViewById(R.id.desskripsi_card)
        var tvRatting: TextView = itemView.findViewById(R.id.ratting_card)
        var tvStars: ImageView = itemView.findViewById(R.id.five_star_card)
        var tvView: TextView = itemView.findViewById(R.id.views_card)
        var tvComment: TextView = itemView.findViewById(R.id.comments_card)
        var tvShare: TextView = itemView.findViewById(R.id.shared_card)

        var clickCard: CardView = itemView.findViewById(R.id.card_view)

    }
}