package com.android.martinabakery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.android.martinabakery.Adapter.SliderAdapter
import kotlin.math.abs

class Home : AppCompatActivity() {

    private lateinit var viewPager2: ViewPager2
    private val sliderHandler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        viewPager2 = findViewById(R.id.viewPager_ImageSlider)

        val sliderItems: MutableList<SliderItem> = ArrayList()
        sliderItems.add(SliderItem(R.drawable.discount1))
        sliderItems.add(SliderItem(R.drawable.discount2))
        sliderItems.add(SliderItem(R.drawable.discount3))

        viewPager2.adapter = SliderAdapter(sliderItems, viewPager2)

        viewPager2.clipToPadding = false
        viewPager2.clipChildren = false
        viewPager2.offscreenPageLimit = 3
        viewPager2.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        val compositePageTransfomer = CompositePageTransformer()
        compositePageTransfomer.addTransformer(MarginPageTransformer(400))
        compositePageTransfomer.addTransformer { page, position ->
            val r = 1 - abs(position)
            page.scaleX = 1.76f
            page.scaleY = 1.65f
        }

        viewPager2.setPageTransformer(compositePageTransfomer)

        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                sliderHandler.removeCallbacks(sliderRunnable)
                sliderHandler.postDelayed(sliderRunnable, 3000)
            }
        })
    }

    private val sliderRunnable = Runnable {
        viewPager2.currentItem = viewPager2.currentItem + 1
    }

    override fun onPause() {
        super.onPause()
        sliderHandler.postDelayed(sliderRunnable,3000)
    }

    override fun onResume() {
        super.onResume()
        sliderHandler.postDelayed(sliderRunnable,3000)
    }
}