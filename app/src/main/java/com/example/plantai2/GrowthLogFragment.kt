// GrowthLogFragment.kt
package com.example.plantai2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.plantai2.databinding.FragmentGrowthLogBinding

class GrowthLogFragment<GrowthLogFragmentArgs> : Fragment() {

    private var _binding: FragmentGrowthLogBinding? = null
    private val binding get() = _binding!!
    private val args: GrowthLogFragmentArgs by navArgs()
    private var plantId: Long = -1 // Initialize with a default value

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGrowthLogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       // plantId = args.plantId
        binding.textViewPlantNameLog.text = "Plant ID: $plantId" // Placeholder

        binding.buttonSaveGrowthData.setOnClickListener {
            val date = binding.editTextDate.text.toString().trim()
            val heightStr = binding.editTextHeight.text.toString().trim()
            val notes = binding.editTextNotes.text.toString().trim()

            if (date.isNotEmpty() && heightStr.isNotEmpty()) {
                val height = heightStr.toDoubleOrNull()
                if (height != null) {
                    // TODO: Save the growth data for the given plantId
                    Toast.makeText(requireContext(), "Growth data logged!", Toast.LENGTH_SHORT).show()
                    findNavController().popBackStack() // Go back to plant details
                } else {
                    Toast.makeText(requireContext(), "Invalid height entered", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(requireContext(), "Date and height are required", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}