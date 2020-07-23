package com.example.app1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_list_item.view.*

class RecyclerAdapter(
    private val recyclerlist:List<RecyclerListItem>,
    private val listener:onItemClickListener
):RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> (){




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val listItem=LayoutInflater.from(parent.context).
                inflate(R.layout.recycler_list_item,parent,false)
        return RecyclerViewHolder(listItem)
    }

    override fun getItemCount()=recyclerlist.size

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val currentItem=recyclerlist[position]
        holder.blood_type.setText(currentItem.blood_type)
        holder.name.setText(currentItem.name)
        holder.date.setText(currentItem.phone)
        holder.gender.setText(currentItem.gender)
        holder.phone.setOnClickListener{
            Toast.makeText(it.context, "Phone", Toast.LENGTH_SHORT).show()
        }

    }



    inner class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        val blood_type=itemView.text_view_blood_type
        val name=itemView.item_name
        val date=itemView.item_date
        val gender=itemView.item_gender
        val phone=itemView.btn_phone

        init {
            itemView.setOnClickListener(this)
        }


        override fun onClick(p0: View?) {
            val position=adapterPosition
            if (position!=RecyclerView.NO_POSITION){
                listener.onItemClick(position)
            }

        }



    }
    interface onItemClickListener{
        fun onItemClick(position: Int)
    }
}