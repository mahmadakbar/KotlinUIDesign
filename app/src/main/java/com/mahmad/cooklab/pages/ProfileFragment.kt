package com.mahmad.cooklab.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.mahmad.cooklab.R

class ProfileFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_profile, container, false)

        val postProfile: LinearLayout = rootView.findViewById(R.id.post_profile)
        val favProfile: LinearLayout = rootView.findViewById(R.id.favorite_profile)

        val favorite: String = getString(R.string.favorite_count)

        postProfile.setOnClickListener{
            Toast.makeText(context,"Membuat Post ...", Toast.LENGTH_SHORT).show()
        }

        favProfile.setOnClickListener{
            Toast.makeText(context,"Jumlah resep yang anda suka seebanyak $favorite", Toast.LENGTH_SHORT).show()
        }

        return rootView
    }

    companion object {
        fun newInstance(): ProfileFragment = ProfileFragment()
    }
}