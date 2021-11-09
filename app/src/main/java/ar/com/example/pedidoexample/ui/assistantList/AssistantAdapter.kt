package ar.com.example.pedidoexample.ui.assistantList

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ar.com.example.pedidoexample.R
import ar.com.example.pedidoexample.data.model.Assistant
import ar.com.example.pedidoexample.databinding.AssistantItemBinding

class AssistantAdapter(private val onAssistantClick: OnAssistantClick) : RecyclerView.Adapter<AssistantAdapter.AssistantViewHolder>() {

    interface OnAssistantClick{
        fun selectAssistant(assistant: Assistant)
        fun checkAssistant(assistant: Assistant)
    }

    private var assistantList = mutableListOf<Assistant>()
    private lateinit var context:Context

    @SuppressLint("NotifyDataSetChanged")
    fun setInfo(newList: MutableList<Assistant>){
        this.assistantList = newList
        //Cambiar por diffUtils
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AssistantViewHolder {
        context = parent.context
        val layoutInflater = LayoutInflater.from(context)
        return AssistantViewHolder(layoutInflater.inflate(R.layout.assistant_item, parent, false))
    }

    override fun onBindViewHolder(holder: AssistantViewHolder, position: Int) {
        val item = assistantList[position]
        with(holder){
            binding.root.setOnClickListener {
                onAssistantClick.selectAssistant(item)
            }
            binding.tvName.text = item.name
            binding.tvSurname.text = item.surName
            binding.tvAge.text =  item.age.toString()
            binding.cvSelected.setOnCheckedChangeListener { compoundButton, b ->
                onAssistantClick.checkAssistant(item)
            }


        }
    }

    override fun getItemCount(): Int = assistantList.size


    inner class AssistantViewHolder(view:View) : RecyclerView.ViewHolder(view) {
        val binding : AssistantItemBinding = AssistantItemBinding.bind(view)
    }
}