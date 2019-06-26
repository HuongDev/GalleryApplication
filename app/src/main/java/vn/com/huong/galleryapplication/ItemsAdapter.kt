package vn.com.huong.galleryapplication

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_news.view.*

/**
 * Created by HuongPN on 01/18/2019.
 */
class ItemsAdapter(val context: Context) : RecyclerView.Adapter<ItemsAdapter.NewsViewHolder>() {

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

    inner class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Items) = with(itemView) {

            textName.text = item.name
            textPrice.text = StringBuilder("$").append(item.price)
            textDescription.text = item.description
            Glide.with(context).load(item.image).into(imageItem)

            setOnClickListener {
                Toast.makeText(context, "Item ${textName.text}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}