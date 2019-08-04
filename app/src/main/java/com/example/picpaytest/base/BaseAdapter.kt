package com.example.picpaytest.base

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class BaseAdapter<T>: RecyclerView.Adapter<BaseAdapter<T>.Holder<T>>(){
    abstract val layoutResource: Int

    var onItemClick: ((T) -> Unit) = {}

    var data: List<T> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    abstract fun bind(itemView: View, user: T)

    override fun getItemCount() = data.size


    override fun onBindViewHolder(p0: Holder<T>, p1: Int) {
        p0.rendle(data[p1])
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int) =
        Holder(LayoutInflater.from(p0.context).inflate(layoutResource,p0,false), ::bind)

    inner class Holder<T>(itemView: View, val bind:(View,T) -> Unit) : RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener {
                onItemClick(data[adapterPosition])
            }
        }

        fun rendle( user: T){
            bind(this.itemView, user)
        }
    }

}