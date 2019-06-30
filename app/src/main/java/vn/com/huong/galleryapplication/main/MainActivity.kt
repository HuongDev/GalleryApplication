package vn.com.huong.galleryapplication.main

import android.app.AlertDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import io.objectbox.Box
import io.objectbox.query.Query
import kotlinx.android.synthetic.main.activity_main.*
import vn.com.huong.galleryapplication.App
import vn.com.huong.galleryapplication.Db.ObjectBox
import vn.com.huong.galleryapplication.Items_
import vn.com.huong.galleryapplication.R
import vn.com.huong.galleryapplication.custom.GridItemDecoration
import vn.com.huong.galleryapplication.model.Items
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var itemsBox: Box<Items>
    private lateinit var itemsAdapter: ItemsAdapter
    private lateinit var itemsQuery: Query<Items>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        itemsBox = ObjectBox.boxStore.boxFor(Items::class.java)

        setUpViews()

        // query all notes, sorted a-z by their text (https://docs.objectbox.io/queries)
        itemsQuery = itemsBox.query().run {
            order(Items_.name)
            build()
        }

        addItem()

        updateItems()
    }

    private fun updateItems() {
        val items = itemsQuery.find()
        itemsAdapter.swapData(items)
    }


    private fun addItem() {

        for (i in 0..20) {
            val item = Items(
                i.toLong(),
                "Air Jordan $i Not For Resell",
                "http://d2lllwtzebgpl1.cloudfront.net/a0317846f035eb6c820e7d1fe6228cb1_listingImg_9nXeNJVWUj.jpg",
                230,
                "Not For Resell",
                Date()
            );
            itemsBox.put(item);
            Log.d(App.TAG, "Inserted new item, Name: ${item.name}")
        }

    }

    fun onMenuButtonClick(v: View) {
        val builder = AlertDialog.Builder(this)
        val inflater = this.layoutInflater
        val view = inflater.inflate(R.layout.dialog_menu, null)
        builder.setView(view)


        val buttonAdd = view.findViewById(R.id.textAdd) as TextView
        val buttonEdit = view.findViewById(R.id.textEdit) as TextView
        val buttonDelete = view.findViewById(R.id.textDelete) as TextView
        val imageClose = view.findViewById(R.id.imageClose) as ImageView

        val dialog = builder.create()

        buttonAdd.setOnClickListener {
            dialog.dismiss()
            showDialogFullScreen() }
//        buttonEdit.setOnClickListener { editItem() }
//        buttonDelete.setOnClickListener { addItem() }
        imageClose.setOnClickListener { dialog.dismiss() }

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
    }

    private fun setUpViews() {
        // Setup Recycler View
        rcvItems.setHasFixedSize(true)
        rcvItems.layoutManager = androidx.recyclerview.widget.GridLayoutManager(this, 2)
        rcvItems.addItemDecoration(GridItemDecoration(50))
        itemsAdapter = ItemsAdapter(this@MainActivity)
        rcvItems.adapter = itemsAdapter
    }

    private fun showDialogFullScreen() {
        val dialog = MenuDialogFragment()
        val ft = supportFragmentManager.beginTransaction()
        dialog.show(ft, MenuDialogFragment.TAG)
    }
}
