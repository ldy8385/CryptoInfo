package com.dylee.cryptoinfo.view

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import android.widget.ImageView
import com.dylee.cryptoinfo.R
import kotlinx.android.synthetic.main.item_indicator.view.*

class IndicatorDialog constructor(context: Context) : Dialog(context){

    init {
        val indicatorView = LayoutInflater.from(context).inflate(R.layout.item_indicator, null, false)

        setScale(indicatorView.cube1, 50)
        setScale(indicatorView.cube2, 100)
        setScale(indicatorView.cube3, 150)
        setScale(indicatorView.cube4, 0)
        window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        Dialog(context)
        setContentView(indicatorView)
        setCancelable(false)

        window!!.attributes.dimAmount = 0.2f
    }


    private fun setScale(view: ImageView, startOffset:Long){
        val scaleAnimation = ScaleAnimation(1F, 0.1F ,1F, 0.1F, 50F, 50F)
        scaleAnimation.repeatMode = Animation.REVERSE
        scaleAnimation.repeatCount = 1
        scaleAnimation.startOffset = startOffset
        scaleAnimation.duration = 300

        scaleAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(arg0: Animation) {}
            override fun onAnimationEnd(animation: Animation) {
                scaleAnimation.startOffset = 600 - startOffset
                view.startAnimation(scaleAnimation)
            }
            override fun onAnimationRepeat(animation: Animation) {
                scaleAnimation.startOffset = startOffset
            }
        })

        view.startAnimation(scaleAnimation)
    }
}