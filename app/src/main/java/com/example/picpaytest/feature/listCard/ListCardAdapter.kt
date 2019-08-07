package com.example.picpaytest.feature.listCard

import android.view.View
import com.example.picpaytest.R
import com.example.picpaytest.base.BaseAdapter
import com.example.picpaytest.data.model.CreditCard
import kotlinx.android.synthetic.main.itemlist_card.view.*


class ListCardAdapter: BaseAdapter<CreditCard>() {
    override val layoutResource: Int
        get() = R.layout.itemlist_card

    override fun bind(itemView: View, item: CreditCard) {
        itemView.numberCardOfList.text = item.numberCard
        itemView.holderNameOfList.text = item.holderName
        itemView.expirationDateOfList.text = item.expirationDate
        itemView.cvvCardOfList.text = item.cvvCard
    }
}