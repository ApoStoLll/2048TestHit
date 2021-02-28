package com.miss.a2048.game.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a2048clone.R
import com.miss.a2048.game.data.entities.RecordEntity
import kotlinx.android.synthetic.main.record_list_item.view.*

class RecordsAdapter (var items : List<RecordEntity>) :
    RecyclerView.Adapter<RecordsAdapter.RecordViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecordViewHolder
            = RecordViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.record_list_item, parent, false))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: RecordViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class RecordViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val score : TextView = itemView.findViewById(R.id.score)
        val time : TextView = itemView.findViewById(R.id.time_text)

        fun bind(item : RecordEntity){
            //name.text = item.results[0].name.first + " " + item.results[0].name.last
            score.text = item.score
            time.text = item.time
        }
    }

}