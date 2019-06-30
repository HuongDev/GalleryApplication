package vn.com.huong.galleryapplication.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_news.view.*
import vn.com.huong.galleryapplication.R
import vn.com.huong.galleryapplication.details.ItemDetailsActivity.Companion.goToItemDetailsActivity
import vn.com.huong.galleryapplication.model.Items

/**
 * Created by HuongPN on 01/18/2019.
 */
class ItemsAdapter(val context: Context) : androidx.recyclerview.widget.RecyclerView.Adapter<ItemsAdapter.NewsViewHolder>() {

    private var data: MutableList<Items> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.item_news, parent, false)
        )
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) = holder.bind(data[position])

    fun swapData(data: List<Items>) {
        this.data.apply {
            clear()
            addAll(data)
        }
        notifyDataSetChanged()
    }

    inner class NewsViewHolder(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {
        fun bind(item: Items) = with(itemView) {

            textName.text = item.name
            textPrice.text = StringBuilder("$").append(item.price)
            textDescription.text = item.description
            Glide.with(context).load(item.image).into(imageItem)

            setOnClickListener {
                Toast.makeText(context, "Item ${textName.text}", Toast.LENGTH_SHORT).show()

                goToItemDetailsActivity(context, item)
            }
        }
    }
}