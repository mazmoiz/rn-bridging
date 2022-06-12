package com.rnbridging.views

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class PathAnimationView : View {
    var mPaint: Paint? = null
    protected var mRadius = 0
    protected var mSides = 0
    protected var mLineThickness = 0F
    var mPath: Path? = null

    constructor(context: Context?) : super(context) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        init()
    }

    private fun init() {
        mPaint = Paint()
        mPaint!!.color = Color.parseColor("#F4D03F")
        mPaint!!.strokeWidth = 25f
        mPaint!!.style = Paint.Style.STROKE
        mPaint!!.isAntiAlias = true
        mPath = Path()
    }

    fun setRaduis(radius: Int) {
        mRadius = radius
        this.invalidate()
    }

    fun setSides(sides: Int) {
        mSides = sides
        this.invalidate()
    }

    fun setLineThickness(lineThickness: Float) {
        mLineThickness = lineThickness
        this.invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        mPaint!!.strokeWidth = mLineThickness
        mPath = createPath(mSides, mRadius.toFloat())
        //mPaint?.pathEffect = CornerPathEffect(30F)
        //mPaint?.pathEffect = PathDashPathEffect(mPath!!, 1F, 0F, PathDashPathEffect.Style.ROTATE)
        canvas.drawPath(mPath!!, mPaint!!)
    }

    fun createPath(sides: Int, radius: Float): Path {
        val path = Path()
        val angle = 2.0 * Math.PI / sides
        path.moveTo(
            cx + (radius * Math.cos(0.0)).toFloat(),
            cy + (radius * Math.sin(0.0)).toFloat())
        for (i in 1 until sides) {
            path.lineTo(
                cx + (radius * Math.cos(angle * i)).toFloat(),
                cy + (radius * Math.sin(angle * i)).toFloat())
        }
        path.close()
        return path
    }

    companion object {
        private const val width = 1080
        private const val height = 1080
        private const val cx = (width / 2).toFloat()
        private const val cy = (height / 2).toFloat()
    }
}