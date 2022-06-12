package com.chakil.beachnusa

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView


class CardAdapter : BaseAdapter() {
    internal var cards = arrayListOf<Card>()

    override fun getCount() = cards.size

    override fun getItem(i: Int) = cards[i]

    override fun getItemId(i: Int) = i.toLong()

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
        //connect viewholder dengan view
        val itemView = view ?: LayoutInflater.from(viewGroup?.context).inflate(R.layout.item_card, viewGroup, false)
        val viewHolder = ViewHolder(itemView)

        //mengubah nilai card sesuai dengan posisi
        viewHolder.bind(cards[position])
        return itemView
    }

    private inner class ViewHolder constructor(itemView: View) {
        private val tvName: TextView = itemView.findViewById(R.id.tv_card_name)
        private val tvDesc: TextView = itemView.findViewById(R.id.tv_card_desc)
        private val imgPhoto: ImageView = itemView.findViewById(R.id.img_card)

        fun bind(card: Card){
            tvName.text = card.name
            tvDesc.text = card.desc
            imgPhoto.setImageResource(card.photo)
        }
    }

}