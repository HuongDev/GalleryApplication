package vn.com.huong.galleryapplication.main

import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.appcompat.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import vn.com.huong.galleryapplication.R

/**
 * Created by HuongPN on 01/21/2019.
 */
class MenuDialogFragment : DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_menu, container, false)

        val toolbar = view.findViewById(R.id.toolbar) as Toolbar
        toolbar.title = "Items"
        toolbar.setNavigationIcon(R.drawable.ic_close_black_24dp);
        toolbar.setNavigationOnClickListener { dismiss() };

        val image = view.findViewById<ImageView>(R.id.imageItem)
        val btAdd = view.findViewById<Button>(R.id.buttonAdd)
        val name = view.findViewById<EditText>(R.id.textName)
        val price = view.findViewById<EditText>(R.id.textPrice)
        val description = view.findViewById<EditText>(R.id.textDescription)

        btAdd.setOnClickListener { addItem() }
        return view
    }

    private fun addItem() {
//        val item = Items(0, textName.text.toString(), "http://d2lllwtzebgpl1.cloudfront.net/a0317846f035eb6c820e7d1fe6228cb1_listingImg_9nXeNJVWUj.jpg", 230, "Not For Resell", Date())
//        itemsBox.put(item)
//        Log.d(App.TAG, "Inserted new item, Name: ${item.name}")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialogStyle);
    }

    override fun onStart() {
        super.onStart()
        val dialog = this.dialog;
        if (dialog != null) {
            val width = ViewGroup.LayoutParams.MATCH_PARENT;
            val height = ViewGroup.LayoutParams.MATCH_PARENT;
            dialog.window?.setLayout(width, height);
        }
    }

    companion object {
        val TAG = MenuDialogFragment::class.java.name
    }
}