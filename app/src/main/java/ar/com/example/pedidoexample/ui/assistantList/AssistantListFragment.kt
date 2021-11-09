package ar.com.example.pedidoexample.ui.assistantList

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import ar.com.example.pedidoexample.R
import ar.com.example.pedidoexample.data.model.Assistant
import ar.com.example.pedidoexample.data.model.ListOfAssistants
import ar.com.example.pedidoexample.databinding.FragmentAssistantListBinding
import ar.com.example.pedidoexample.presentation.AssistantViewModel
import ar.com.example.pedidoexample.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AssistantListFragment : Fragment(R.layout.fragment_assistant_list), AssistantAdapter.OnAssistantClick {

    private lateinit var binding : FragmentAssistantListBinding
    private val viewModel by viewModels<AssistantViewModel>()
    private var assistantList = mutableListOf<Assistant>()
    private val adapter by lazy { AssistantAdapter(this) }
    private var assistantsToSend = mutableListOf<Assistant>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAssistantListBinding.bind(view)
        fetchInformation()
        sendSelectedAssistants()
    }

    private fun fetchInformation() {
        viewModel.fetchAssistantsByAge().observe(viewLifecycleOwner, Observer{
            assistantList.clear()
            assistantList.addAll( it)
            initRecyclerView(assistantList)
        })
    }

    private fun initRecyclerView(myList: MutableList<Assistant>) {
        binding.rvAssistants.adapter = adapter
        adapter.setInfo(myList)
    }

    override fun selectAssistant(assistant: Assistant) {
        toast(requireContext(), "Assistant: ${assistant.name}")
    }

    override fun checkAssistant(assistant: Assistant) {
        Log.d("AssistantToSend", "El assistant existe: ${assistant.name}")
        assistantsToSend.add(assistant)
    }

    private fun sendSelectedAssistants(){
        binding.btnSelect.setOnClickListener {
            val action = AssistantListFragmentDirections.actionAssistantListFragmentToFinalListFragment(
                ListOfAssistants(assistantsToSend)
            )
            findNavController().navigate(action)
        }
    }


}