package com.mahmad.cooklab.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mahmad.cooklab.R
import com.mahmad.cooklab.pages.list.CardAdapter
import com.mahmad.cooklab.pages.list.CardArray
import com.mahmad.cooklab.pages.list.CardData

open class ListFragment : Fragment() {

    private lateinit var rvCard: RecyclerView
    private var list: ArrayList<CardData> = arrayListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_list, container, false)

        rvCard = rootView.findViewById(R.id.rv_cards)
        rvCard.setHasFixedSize(true)

        list.addAll(CardArray.listData)

        rvCard.layoutManager = LinearLayoutManager(activity)
        val cardViewAdapter = CardAdapter(list)
        rvCard.adapter = cardViewAdapter

        return rootView
    }

    companion object {
        fun newInstance(): ListFragment = ListFragment()
    }
}