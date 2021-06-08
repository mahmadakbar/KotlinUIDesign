@file:Suppress("DEPRECATION")

package com.mahmad.cooklab

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Build
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mahmad.cooklab.pages.HomeFragment
import com.mahmad.cooklab.pages.ListFragment
import com.mahmad.cooklab.pages.ProfileFragment
import com.mahmad.cooklab.pages.SearchFragment
import com.mahmad.cooklab.pages.list.Setting

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    private var pressedTime: Long = 0
    private lateinit var toolbar: TextView
    private lateinit var  moreBtn: Button

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val appBar:View = findViewById(R.id.appBar)
        ViewCompat.setElevation(appBar, 20f)

        // setting navigation bar
        toolbar = findViewById(R.id.text_appBar)
        val bottomNavigation: BottomNavigationView = findViewById(R.id.navigationView)
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        moreBtn = findViewById(R.id.more_btn)
        moreBtn.setOnClickListener {
            val popupMenu = PopupMenu(this,moreBtn)
            popupMenu.menuInflater.inflate(R.menu.setting,popupMenu.menu)
            popupMenu.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.settings -> {
                        val intent = Intent(this, Setting::class.java)
                        startActivity(intent)
                    }
                }
                true
            }
            popupMenu.gravity = Gravity.END
            popupMenu.show()
        }

        // open fragmen when start
        val homeFragment = HomeFragment.newInstance()
        openFragment(homeFragment) // membuka fragmen home

        val menu = bottomNavigation.menu
        val menuItem = menu.findItem(R.id.navigation_profile)
        bottomNavigation.itemIconTintList = null
        Glide.with(this)
            .asBitmap()
            .load(R.drawable.back_nav_img)
            .apply(RequestOptions().circleCrop())
            .into(object : SimpleTarget<Bitmap>() {
                override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                    menuItem?.icon = BitmapDrawable(resources, resource)
                }
            })

    }

    // navigasi ketika berganti halaman
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                toolbar.text = getString(R.string.title) //merubah judul actionbar ketika berganti halaman
                val homeFragment = HomeFragment.newInstance()
                openFragment(homeFragment) // membuka fragmen home
                moreBtn.visibility = View.GONE
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_list -> {
                toolbar.text = getString(R.string.navigation_list) //merubah judul actionbar ketika berganti halaman
                val listFragment = ListFragment.newInstance()
                openFragment(listFragment) // membuka fragmen list
                moreBtn.visibility = View.GONE
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_search -> {
                toolbar.text = getString(R.string.navigation_search) //merubah judul actionbar ketika berganti halaman
                val searchFragment = SearchFragment.newInstance()
                openFragment(searchFragment) // membuka fragmen search
                moreBtn.visibility = View.GONE
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_profile -> {
                toolbar.text = getString(R.string.navigation_profile) //merubah judul actionbar ketika berganti halaman
                val profileFragment = ProfileFragment.newInstance()
                openFragment(profileFragment) // membuka fragmen profile
                moreBtn.visibility = View.VISIBLE
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    // ketika membuka fragmen akan me-replace tampilan framelayout dengan id container
    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun onBackPressed(){
        if (pressedTime + 2000 > System.currentTimeMillis()) {
            finish()
        } else {
            Toast.makeText(baseContext, "Press back again to exit", Toast.LENGTH_SHORT).show()
        }
        pressedTime = System.currentTimeMillis()
    }

}
