// AddPlantFragment.kt
package com.example.plantai2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.plantai2.databinding.FragmentAddPlantBinding

class AddPlantFragment : Fragment() {

    private var _binding: FragmentAddPlantBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddPlantBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSavePlant.setOnClickListener {
            val plantName = binding.editTextPlantName.text.toString().trim()
            if (plantName.isNotEmpty()) {
                // TODO: Save the new plant data
                Toast.makeText(requireContext(), "Plant '$plantName' saved!", Toast.LENGTH_SHORT).show()
                findNavController().popBackStack() // Go back to the previous fragment
            } else {
                Toast.makeText(requireContext(), "Plant name cannot be empty", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}