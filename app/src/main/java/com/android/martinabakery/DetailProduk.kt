package com.android.martinabakery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel

class DetailProduk : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_produk)

        val is_detail_produk = findViewById<ImageSlider>(R.id.is_detail_produk)
        val imageList = arrayListOf<SlideModel>()

        imageList.add(SlideModel("https://p4.wallpaperbetter.com/wallpaper/583/30/393/berries-cake-cake-caramel-hd-wallpaper-preview.jpg","Caramel Cake"))
        imageList.add(SlideModel("https://st2.depositphotos.com/1177973/5329/i/600/depositphotos_53292415-stock-photo-chocolate-cake.jpg","Strawberry Choco Cake"))
        imageList.add(SlideModel("https://thumbs.dreamstime.com/b/white-birthday-cake-sparkler-white-birthday-cake-colorful-sprinkles-sparkler-over-neutral-background-111516356.jpg","Vanilla Cake"))
        imageList.add(SlideModel("https://c4.wallpaperflare.com/wallpaper/607/282/573/sweets-food-cake-hd-wallpaper-preview.jpg","Tiramisu Cake"))

        is_detail_produk.setImageList(imageList, ScaleTypes.FIT)
    }
}