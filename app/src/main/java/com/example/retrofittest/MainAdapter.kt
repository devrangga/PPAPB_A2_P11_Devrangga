package com.example.retrofittest

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MainAdapter(val result: ArrayList<MainModel.Result>, val listener: OnAdapterListener) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_main,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.view.findViewById<TextView>(R.id.title).text = result[position].title

        Glide.with(holder.view).load(result[position].image).placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_background).centerCrop().into(holder.view.findViewById(R.id.imageView))

        holder.view.findViewById<TextView>(R.id.title).setOnClickListener{
            listener.onClick(result[position])
        }

    }

    override fun getItemCount(): Int {
        return result.size
    }

    class ViewHolder (val view: View) : RecyclerView.ViewHolder(view)

    fun setData(data : List<MainModel.Result>){
        result.clear()
        result.addAll(data)
        notifyDataSetChanged()
    }

    interface OnAdapterListener{
        fun onClick(result: MainModel.Result)
    }
}