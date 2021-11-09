package ar.com.example.pedidoexample.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import ar.com.example.pedidoexample.R
import ar.com.example.pedidoexample.data.model.Assistant
import ar.com.example.pedidoexample.databinding.FragmentHomeBinding
import ar.com.example.pedidoexample.presentation.AssistantViewModel
import ar.com.example.pedidoexample.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding : FragmentHomeBinding
    private val viewModel by viewModels<AssistantViewModel>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)
        saveButton()
        listButton()
    }

    private fun listButton() {
        binding.btnToList.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_assistantListFragment)
        }
    }

    private fun saveButton() {
        binding.btnSave.setOnClickListener {
            val name = binding.etName.text.toString()
            val surname = binding.etSurname.text.toString()
            val age = binding.etAge.text.toString()
            if (validateFields(name, surname, age)){
                if (validateAge(age)){
                    viewModel.saveAssistant(Assistant(name = name, surName = surname, age = age.toInt()))
                    clearFields()
                    toast(requireContext(), "Assistant saved")
                }else toast(requireContext(), "The age must be between 22 and 49")
            }else toast(requireContext(), "A field is empty")
        }
    }

    private fun clearFields() {
        binding.etName.text?.clear()
        binding.etSurname.text?.clear()
        binding.etAge.text?.clear()
    }

    private fun validateAge(age: String): Boolean {
        return age.toInt() in 22..49
    }

    private fun validateFields(name: String, surname: String, age: String): Boolean {
        if (name.isEmpty()) return false
        if (surname.isEmpty()) return false
        if (age.isEmpty()) return false
        return true
    }
}