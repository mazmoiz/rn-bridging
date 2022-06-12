package com.rnbridging.layouts

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.rnbridging.R
import com.rnbridging.views.PathAnimationView

class PathAnimationLayout (context: Context): ConstraintLayout(context) {
    private var pathAnimationView: PathAnimationView? = null

    fun setRaduis(value: Int = 100) {
        pathAnimationView?.setRaduis(value);
    }

    fun setSides(sides: Int = 100) {
        pathAnimationView?.setSides(sides);
    }

    fun setLineThickness(thickness: Float = 15F) {
        pathAnimationView?.setLineThickness(thickness);
    }

    init {
        val view = LayoutInflater.from(context).inflate(R.layout.activity_path_animation, this)
        pathAnimationView = view!!.findViewById(R.id.pathAnim);
    }
}