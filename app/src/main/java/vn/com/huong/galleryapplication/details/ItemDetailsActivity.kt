package vn.com.huong.galleryapplication.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import com.bumptech.glide.Glide
import com.github.chrisbanes.photoview.PhotoView
import vn.com.huong.galleryapplication.model.Items
import vn.com.huong.galleryapplication.R
import vn.com.huong.galleryapplication.custom.PhotoViewIndicator

class ItemDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_details)


        val photoView: PhotoView = findViewById(R.id.photoView)
        val indicator = findViewById<PhotoViewIndicator>(R.id.indicator)

        indicator.setPhotoView(photoView)

        val url = "https://images.unsplash.com/photo-1547908345-4260f706aa20?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=3278&q=80"
        Glide.with(this).load(url).into(photoView)

    }

    private fun getExtraIntent() {
        val userId = intent.getStringExtra(INTENT_USER_ID)
            ?: throw IllegalStateException("field $INTENT_USER_ID missing in Intent")

        requireNotNull(userId) { "no user_id provided in Intent extras" }
    }

    companion object {

        private val INTENT_USER_ID = "user_id"

        @JvmStatic
        fun goToItemDetailsActivity(fromActivity : Context, item : Items) = apply{
            val intent = Intent(fromActivity, ItemDetailsActivity::class.java)
            // pass id of item and get item object
            intent.putExtra(INTENT_USER_ID, item.id)
            startActivity(fromActivity, intent, null)
        }
    }
}
