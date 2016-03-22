package com.mphantom.forrest.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mphantom.forrest.R
import com.mphantom.forrest.model.Model

/**
 * Created by wushaorong on 3/14/16.
 */
class GankDayAdapter(var context: Context, var gankDay: List<Model.GankItem>) : RecyclerView.Adapter<GankDayAdapter.GankDayViewHolder>() {
    override fun getItemCount(): Int {
        return gankDay.size
    }

    override fun onBindViewHolder(p0: GankDayViewHolder?, p1: Int) {
    }

    override fun onCreateViewHolder(p0: ViewGroup?, p1: Int): GankDayViewHolder? {
        return GankDayViewHolder(LayoutInflater.from(context).inflate(R.layout.item_gankday, p0, false))
    }

    class GankDayViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}