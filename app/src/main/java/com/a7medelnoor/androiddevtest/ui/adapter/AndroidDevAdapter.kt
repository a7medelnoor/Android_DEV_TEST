package com.a7medelnoor.androiddevtest.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.a7medelnoor.androiddevtest.R
import com.a7medelnoor.androiddevtest.ui.data.model.response.BaseResponse
import com.bumptech.glide.Glide

class AndroidDevAdapter(
    private var baseResponseList: List<BaseResponse>,
    private var context: Context

) : RecyclerView.Adapter<AndroidDevAdapter.AndroidDevViewHolder>() {
    class AndroidDevViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView
        val recyclerImageView: ImageView
        val descriptionText: TextView
        val ratingBar: RatingBar
        val offerTextView: TextView
        val deliveryTextView: TextView
        val offerImageView: ImageView

        init {
            nameTextView = itemView.findViewById(R.id.RecyclerViewTitleTextView)
            recyclerImageView = itemView.findViewById(R.id.RecyclerViewImageView)
            descriptionText = itemView.findViewById(R.id.RecyclerViewDescriptionTextView)
            ratingBar = itemView.findViewById(R.id.RecyclerViewRatingBar)
            offerTextView = itemView.findViewById(R.id.RecyclerViewTextViewOffer)
            deliveryTextView = itemView.findViewById(R.id.RecyclerViewDeliveryTextView)
            offerImageView = itemView.findViewById(R.id.RecyclerViewOfferImageView)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AndroidDevViewHolder {
        val inflater = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_item, parent, false)

        return AndroidDevViewHolder(inflater)

    }

    override fun onBindViewHolder(holder: AndroidDevViewHolder, position: Int) {
        val list = baseResponseList.get(position)
        holder.nameTextView.text = list.name
        holder.descriptionText.text = list.description
        holder.deliveryTextView.text = list.offer
        holder.offerImageView.setImageResource(R.drawable.ic_offer)
        Glide.with(holder.itemView)
            .load(list.image_url)
            .into(holder.recyclerImageView)
        val linearLayout = LinearLayoutManager(
            context, LinearLayoutManager.VERTICAL, false
        )
    }

    override fun getItemCount(): Int {
        return baseResponseList.size

    }
}