package com.example.shoesshop.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions
import com.example.shoesshop.Model.ItemsModel
import com.example.shoesshop.activity.DetailActivity
import com.example.shoesshop.databinding.ViewholderRecommendedBinding
import com.example.shoesshop.Adapter.PopularAdapter as PopularAdapter1

class PopularAdapter(val items:MutableList<ItemsModel>):
    RecyclerView.Adapter<PopularAdapter1.ViewHolder>() {
        private  var context:Context? = null
    class ViewHolder (val binding: ViewholderRecommendedBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularAdapter1.ViewHolder {
        context = parent.context
        val binding = ViewholderRecommendedBinding.inflate(LayoutInflater.from(context),parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PopularAdapter1.ViewHolder, position: Int) {
        holder.binding.titleTxt.text = items[position].title
        holder.binding.priceTxt.text = "$"+items[position].price.toString()
        holder.binding.ratinTxt.text = items[position].rating.toString()
        print(items[position].picUrl)
        val requestOptions = RequestOptions().transform(CenterCrop())
        Glide.with(holder.itemView.context)
            .load(items[position].picUrl[0])
            .apply(requestOptions)
            .into(holder.binding.pic)

        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra("object",items[position])
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int  = items.size
}