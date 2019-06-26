package vn.com.huong.galleryapplication

import android.app.Application

/**
 * Created by HuongPN on 01/18/2019.
 */
class App : Application(){

    companion object Constants {
        const val TAG = "ObjectBoxExample"
        const val EXTERNAL_DIR = false
    }

    override fun onCreate() {
        super.onCreate()
        ObjectBox.build(this)
    }
}