package ar.com.example.pedidoexample.ui.finalList

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import ar.com.example.pedidoexample.R
import ar.com.example.pedidoexample.databinding.FragmentFinalListBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class FinalListFragment : Fragment(R.layout.fragment_final_list) {

    private lateinit var binding: FragmentFinalListBinding
    private val args by navArgs<FinalListFragmentArgs>()
    private val adapter by lazy { FinalListAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFinalListBinding.bind(view)
        initRecyclerView()
        btnFunction()
    }

    private fun btnFunction() {
        binding.btnExit.setOnClickListener {
            val builder = AlertDialog.Builder(requireContext())
            builder.setPositiveButton("Yes") { _, _ ->
                requireActivity().finish()
            }
            builder.setNegativeButton("No") { _, _ -> }
            builder.setTitle("Exit?")
            builder.setMessage("Are you sure you want to exit?")
            builder.create().show()
        }
    }

    private fun initRecyclerView() {
        binding.rvFinalFragment.adapter = adapter
        adapter.setData(args.assistants.result)
    }


    override fun onDestroy() {
        super.onDestroy()
        args.assistants.result.clear()
    }

}