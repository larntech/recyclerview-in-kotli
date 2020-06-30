package net.larntech.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_item.view.*

class MyAdapter(private var item: List<MyModel>, private var context: Context, private var clickListener: ClickListener) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    fun setData(item: List<MyModel>){
        this.item = item;
        notifyDataSetChanged();
    }

    override fun getItemCount(): Int {
        return  item.size
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        context = parent.context;
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_item,parent,false));
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       val myModel = item[position];
        val name = myModel.name;
        val desc = myModel.desc;

        holder.header.text = name;
        holder.desc.text = desc;

        holder.itemView.setOnClickListener {
            clickListener.clickedItem(myModel);
        }

    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var header = itemView.tvHeader;
        var desc = itemView.tvDesc;

    }

    interface ClickListener{
        fun clickedItem(myModel: MyModel);
    }

}