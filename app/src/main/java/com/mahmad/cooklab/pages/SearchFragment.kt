package com.mahmad.cooklab.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView
import androidx.fragment.app.Fragment
import com.mahmad.cooklab.R

@Suppress("DEPRECATION")
class SearchFragment : Fragment() {

    private lateinit var searchView: SearchView
    private lateinit var listView: ListView
    private lateinit var list: ArrayList<String>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_search, container, false)
        searchView = rootView.findViewById(R.id.searchView)
        listView = rootView.findViewById(R.id.listView)
        list = arrayListOf(
                "Oddading",
                "Apple",
                "niipon paint",
                "WaterMelon",
                "Mango",
                "Hijau Bolu Pandan",
                "Papaya",
                "Drink",
                "Juice Enak"
        )

        val adapter = activity?.let {
            ArrayAdapter(
                    it,
                    android.R.layout.simple_list_item_1,
                    list
            )
        }
        listView.adapter = adapter
        searchView.setOnQueryTextFocusChangeListener { _ , hasFocus ->
            if (hasFocus) {
                rootView.setBackgroundColor(resources.getColor(R.color.coastal))
                listView.visibility = View.VISIBLE
            } else {
                rootView.setBackgroundColor(0x00000000)
                listView.visibility = View.INVISIBLE
            }
        }
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                if (list.contains(query)) {
                    adapter?.filter?.filter(query)
                } else {
                    return false
                }
                return false
            }
            override fun onQueryTextChange(newText: String): Boolean {
                adapter?.filter?.filter(newText)
                return false
            }
        })

        return rootView

    }
    companion object {
        fun newInstance(): SearchFragment = SearchFragment()
    }
}