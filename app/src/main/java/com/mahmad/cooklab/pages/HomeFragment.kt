package com.mahmad.cooklab.pages

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mahmad.cooklab.R
import com.mahmad.cooklab.pages.list.CardArray
import com.mahmad.cooklab.pages.list.CardData
import com.mahmad.cooklab.pages.list.Details
import com.mahmad.cooklab.pages.list.ListAdapter

class HomeFragment : Fragment() {

    private lateinit var rvCard: RecyclerView
    private var list: ArrayList<CardData> = arrayListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_home, container, false)

        val cookName = arrayOf(
            "Kue Oreo Tanpa Oven",
            "rhoncus",
            "Sed odio morbi quis commodo odio aenean sed. Iaculis nunc sed augue lacus viverra vitae congue. Scelerisque in dictum non consectetur a erat. Felis donec et odio pellentesque diam volutpat.",
            "5.0",
            "4.511",
            "562",
            "327",
            """
                ● Bahan
                - 40 Oreo
                - 320ml Susu
                - 8g (1tbsp) Baking powder
                
                ● krim
                - 200g Krim kocok
                - 2tbsp Oreo yang dihancurkan (2 oreos)
                 
                ● Dekorasi (opsional)
                - Apple Mint
                - 1 Oreo
            """.trimIndent(),
            """
                1. Krim putih yang dipisahkan dari Oreo tetap enak bahkan jika Anda mencampurnya dengan mentega tawar dan menyebarkannya di atas roti.
                2. Jika Anda membuat krim kocok sendiri, Anda dapat menambahkan 2 sendok makan Oreo White Cream. (Jika Anda menambahkan banyak, itu tidak akan mencambuk)
                3. Pastikan roti benar-benar dingin. Saat hangat, krim kocok meleleh.
                4. Baking powder membuat roti mengembang, membuatnya lebih lembut.
                5. Taruh sisa kue dalam wadah kedap udara dan simpan di lemari es. Jika Anda hanya menyimpannya, roti menjadi keras.
            """.trimIndent()
        )

        rvCard = rootView.findViewById(R.id.rv_grid)
        rvCard.isFocusable = false
        rvCard.setHasFixedSize(true)

        val focuss: LinearLayout = rootView.findViewById(R.id.focuss_linier)
        focuss.requestFocus()

        list.addAll(CardArray.listData)

        // home display
        val photoMain: ImageView = rootView.findViewById(R.id.img_photo_main)
        val starMain: ImageView = rootView.findViewById(R.id.five_star_main)
        val nameMain: TextView = rootView.findViewById(R.id.judul_masakan_main)
        val uNameMain: TextView = rootView.findViewById(R.id.user_name_main)
        val descMain: TextView = rootView.findViewById(R.id.desskripsi_main)
        val ratingMain: TextView = rootView.findViewById(R.id.ratting_main)
        val viewMain: TextView = rootView.findViewById(R.id.views_main)
        val commentMain: TextView = rootView.findViewById(R.id.comments_main)
        val shareMain: TextView = rootView.findViewById(R.id.shared_main)

        Glide.with(this)
            .load(R.drawable.img_widh_oreo)
            .apply(RequestOptions().override(450, 550))
            .into(photoMain)
        Glide.with(this)
            .load(R.drawable.star)
            .into(starMain)
        nameMain.text = cookName[0]
        uNameMain.text = cookName[1]
        descMain.text = cookName[2]
        ratingMain.text = cookName[3]
        viewMain.text = cookName[4]
        commentMain.text = cookName[5]
        shareMain.text = cookName[6]

        rvCard.layoutManager = LinearLayoutManager(activity)
        val cardViewAdapter = ListAdapter(list)
        rvCard.adapter = cardViewAdapter

        val cardMain:LinearLayout = rootView.findViewById(R.id.card_main)
        cardMain.setOnClickListener{
            val intent = Intent(context, Details::class.java)

            intent.putExtra(Details.RECIPE_IMAGE, R.drawable.img_widh_oreo)
            intent.putExtra(Details.RECIPE_NAME, cookName[0])
            intent.putExtra(Details.RECIPE_UNAME, cookName[1])
            intent.putExtra(Details.RECIPE_DESC, cookName[2])
            intent.putExtra(Details.RECIPE_RATTING, cookName[3])
            intent.putExtra(Details.RECIPE_STAR, R.drawable.star)
            intent.putExtra(Details.RECIPE_VIEW, cookName[4])
            intent.putExtra(Details.RECIPE_COMMENT, cookName[5])
            intent.putExtra(Details.RECIPE_SHARE, cookName[6])
            intent.putExtra(Details.RECIPE_INGRED, cookName[7])
            intent.putExtra(Details.RECIPE_INSTRUCT, cookName[8])
            startActivity(intent)
        }

        return rootView
    }

    companion object {
        fun newInstance(): HomeFragment = HomeFragment()
    }
}