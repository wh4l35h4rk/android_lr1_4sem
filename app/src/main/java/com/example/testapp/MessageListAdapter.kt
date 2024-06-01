package com.example.testapp
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



class MessageListAdapter (private val list: List<Message>) : RecyclerView.Adapter<MessageListAdapter.MyVH>() {

    class MyVH(view: View) : RecyclerView.ViewHolder(view) {
        val name : TextView = view.findViewById(R.id.tv_name)
        val text : TextView = view.findViewById(R.id.tv_text)
        val ttime : TextView = view.findViewById(R.id.tv_time)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageListAdapter.MyVH {
        val layout = when(viewType) {
            MESSAGE_SENT_TYPE -> R.layout.sent_message_item
            MESSAGE_GOT_TYPE -> R.layout.got_message_item
            else -> {
                Log.d("test!!!!", "something is wrong...")
            }
        }
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        Log.d("test", MyVH(view).toString())
        return MyVH(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        val ttype = list[position].ttype
        return when(ttype) {
            0 -> MESSAGE_SENT_TYPE
            1 -> MESSAGE_GOT_TYPE
            else -> {
                MESSAGE_UNKN_TYPE}
        }
    }


    override fun onBindViewHolder(holder: MyVH, position: Int) {
        val elem = list[position]
        holder.name.text = elem.name
        holder.ttime.text = elem.ttime
        holder.text.text = elem.text
    }

    companion object {
        private const val MESSAGE_SENT_TYPE = 100
        private const val MESSAGE_GOT_TYPE = 101
        private const val MESSAGE_UNKN_TYPE = 102
    }
}