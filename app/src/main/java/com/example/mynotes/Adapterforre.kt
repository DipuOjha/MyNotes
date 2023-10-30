package com.example.mynotes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class Adapterforre: RecyclerView.Adapter<Adapterforre.myViewHolder>() {
     var notesList: ArrayList<Note> = ArrayList<Note>()
    class myViewHolder(itemView:View):ViewHolder(itemView){
       // item
        var titleText:TextView = itemView.findViewById(R.id.titletv)
        var destext:TextView = itemView.findViewById(R.id.destv)



    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
       // TODO("Not yet implemented")

        var cur = notesList.get(position)
        holder.titleText.text = cur.title
        holder.destext.text = cur.des
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_rec,parent,false)
        return myViewHolder(view)
        //TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        //TODO("Not yet implemented")
        return notesList.size
    }
    fun setList(notesL:ArrayList<Note>){
        notesList.clear()
        notesList.addAll(notesL)
        notifyDataSetChanged()

    }
}