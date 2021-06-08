package com.mahmad.cooklab.pages.list

import android.content.Intent
import android.content.Intent.EXTRA_TEXT
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mahmad.cooklab.R

class Details : AppCompatActivity() {

    companion object{
        const val RECIPE_IMAGE = "img_resep"
        const val RECIPE_NAME = "nama_resep"
        const val RECIPE_UNAME = "uname_resep"
        const val RECIPE_DESC = "desc_resep"
        const val RECIPE_RATTING = "ratting_resep"
        const val RECIPE_STAR = "star_resep"
        const val RECIPE_VIEW = "view_resep"
        const val RECIPE_COMMENT = "comment_resep"
        const val RECIPE_SHARE = "share_resep"

        const val RECIPE_INGRED = "bahan_resep"
        const val RECIPE_INSTRUCT = "instruksi_resep"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        //toolbar
        val toolbarBack: Button = findViewById(R.id.back_appBar)
        val toolbar: TextView = findViewById(R.id.text_appBar)

        toolbarBack.visibility = View.VISIBLE
        toolbarBack.setOnClickListener{
            super.onBackPressed()
        }
        // buton favorite
        val favoriteBtn: Button = findViewById(R.id.favorite_btn)
        val shareBtn: Button = findViewById(R.id.share_btn)

        //content
        val dtPhoto: ImageView = findViewById(R.id.img_photo_details)
        val dtName: TextView = findViewById(R.id.judul_masakan_details)
        val dtUserName: TextView = findViewById(R.id.user_name_details)
        val dtDescripion: TextView = findViewById(R.id.desskripsi_details)
        val dtRatting: TextView = findViewById(R.id.ratting_details)
        val dtStars: ImageView = findViewById(R.id.five_star_details)
        val dtView: TextView = findViewById(R.id.views_details)
        val dtComment: TextView = findViewById(R.id.comments_details)
        val dtShare: TextView = findViewById(R.id.shared_details)
        val dtIngred: TextView = findViewById(R.id.bahan_details)
        val dtInstruct: TextView = findViewById(R.id.instruksi_details)

        // content
        val photoDt = intent.getIntExtra(RECIPE_IMAGE, 0)
        val nameDt = intent.getStringExtra(RECIPE_NAME)
        val unameDt = intent.getStringExtra(RECIPE_UNAME)
        val descDt = intent.getStringExtra(RECIPE_DESC)
        val rattingDt = intent.getStringExtra(RECIPE_RATTING)
        val starDt = intent.getIntExtra(RECIPE_STAR, 0)
        val viewDt = intent.getStringExtra(RECIPE_VIEW)
        val commentDt = intent.getStringExtra(RECIPE_COMMENT)
        val shareDt = intent.getStringExtra(RECIPE_SHARE)
        val ingredDt = intent.getStringExtra(RECIPE_INGRED)
        val instructDt = intent.getStringExtra(RECIPE_INSTRUCT)

//        val greetingName = nameDt!!.substringBefore(" ")
        val toolbarDes = "Resep Masakan"

        toolbar.text = toolbarDes // toolbar
        Glide.with(this)
            .load(photoDt)
            .apply(RequestOptions().override(566, 296))
            .into(dtPhoto)
        dtName.text = nameDt // title
        dtUserName.text = unameDt
        dtDescripion.text = descDt
        dtRatting.text = rattingDt
        Glide.with(this)
            .load(starDt)
            .into(dtStars)
        dtView.text = viewDt
        dtComment.text = commentDt
        dtShare.text = shareDt
        dtIngred.text = ingredDt
        dtInstruct.text = instructDt

        favoriteBtn.setOnClickListener{
            Toast.makeText(applicationContext,"Anda Menyukai \"$nameDt\"", Toast.LENGTH_SHORT).show()
        }

        shareBtn.setOnClickListener{
            val shareDetails = Intent(Intent.ACTION_SEND)
            shareDetails.type = "text/plain"
            shareDetails.putExtra(EXTRA_TEXT, "Nama Resep : $nameDt \nDeskripsi : \n$descDt \n\nBahan : \n$ingredDt \n\nCara Pembuatan : \n$instructDt")
            startActivity(Intent.createChooser(shareDetails, "Bagikan Dengan"))

        }
    }

}