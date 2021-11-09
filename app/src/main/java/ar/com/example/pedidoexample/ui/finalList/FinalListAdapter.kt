package ar.com.example.pedidoexample.ui.finalList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ar.com.example.pedidoexample.R
import ar.com.example.pedidoexample.data.model.Assistant
import ar.com.example.pedidoexample.databinding.SelectedAssistantItemBinding

class FinalListAdapter : RecyclerView.Adapter<FinalListAdapter.FinalViewHolder>() {

    var selectedAssistants = mutableListOf<Assistant>()

    fun setData(newList: MutableList<Assistant>){
        this.selectedAssistants =  newList
        //Cambiar por diffUtils
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FinalViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return FinalViewHolder(layoutInflater.inflate(R.layout.selected_assistant_item, parent, false))
    }

    override fun onBindViewHolder(holder: FinalViewHolder, position: Int) {
        val assistant = selectedAssistants[position]
        with(holder){
            binding.tvAge.text = assistant.age.toString()
            binding.tvName.text = assistant.name
            binding.tvSurname.text = assistant.surName
        }
    }

    override fun getItemCount(): Int = selectedAssistants.size


    inner class FinalViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val binding: SelectedAssistantItemBinding = SelectedAssistantItemBinding.bind(view)
    }
}