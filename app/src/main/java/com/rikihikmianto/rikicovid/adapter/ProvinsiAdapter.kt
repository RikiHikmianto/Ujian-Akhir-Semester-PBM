package com.rikihikmianto.rikicovid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rikihikmianto.rikicovid.R
import com.rikihikmianto.rikicovid.model.ProvinsiResponse
import kotlinx.android.synthetic.main.item_provinsi.view.*

class ProvinsiAdapter (private var list: ArrayList<ProvinsiResponse>):
    RecyclerView.Adapter<ProvinsiAdapter.ProvinsiViewHolder>() {
    inner class ProvinsiViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(provinsi: ProvinsiResponse){
            with(itemView){
                tv_name.text = provinsi.attributes.provinsi
                tv_positif.text = provinsi.attributes.positif.toString()
                tv_meninggal.text = provinsi.attributes.meningggal.toString()
                tv_sembuh.text = provinsi.attributes.sembuh.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProvinsiViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_provinsi, parent, false)
        return ProvinsiViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProvinsiViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}