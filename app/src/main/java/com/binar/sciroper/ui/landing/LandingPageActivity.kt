package com.binar.sciroper.ui.landing


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.binar.sciroper.R
import com.binar.sciroper.databinding.ActivityLandingPageBinding
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator

class LandingPageActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLandingPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLandingPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewPager: ViewPager2 = binding.viewpager

        val fragments: ArrayList<Fragment> = arrayListOf(
            Page1Fragment(),
            Page2Fragment()
        )

        val adapter = ViewPagerAdapter(fragments, this)
        viewPager.adapter = adapter
        val wormDotsIndicator = binding.wormDotsIndicator
        wormDotsIndicator.setViewPager2(viewPager)

    }
}