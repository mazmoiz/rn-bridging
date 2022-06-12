package com.rnbridging.rnPackages

import android.view.LayoutInflater
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.ViewGroupManager
import com.facebook.react.uimanager.annotations.ReactProp
import com.rnbridging.R
import com.rnbridging.layouts.PathAnimationLayout
import com.rnbridging.views.PathAnimationView

class PathAnimationViewManager(reactContext: ReactApplicationContext):
    ViewGroupManager<PathAnimationLayout>() {

    private val REACT_CLASS = "PathAnimationViewManager"

    override fun getName(): String {
        return REACT_CLASS
    }

    @ReactProp(name = "radius")
    fun setRaduis(view: PathAnimationLayout, value: Int) {
        view.setRaduis(value);
    }

    @ReactProp(name = "sides")
    fun setSides(view: PathAnimationLayout, value: Int) {
        view.setSides(value);
    }

    @ReactProp(name = "lineThickness")
    fun setLineThickness(view: PathAnimationLayout, value: Float) {
        view.setLineThickness(value);
    }

    override fun createViewInstance(reactContext: ThemedReactContext): PathAnimationLayout {
        return PathAnimationLayout(reactContext)
    }
}