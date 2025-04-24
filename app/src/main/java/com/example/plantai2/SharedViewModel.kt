package com.example.plantai2

import androidx.lifecycle.ViewModel
import com.example.plantai2.data.Plant
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class SharedViewModel : ViewModel() {

    // List of all plants
    private val _plantList = MutableStateFlow<List<Plant>>(emptyList())
    val plantList: StateFlow<List<Plant>> = _plantList

    // Currently selected plant
    private val _selectedPlant = MutableStateFlow<Plant?>(null)
    val selectedPlant: StateFlow<Plant?> = _selectedPlant

    fun selectPlant(plant: Plant) {
        _selectedPlant.value = plant
    }

    fun clearSelectedPlant() {
        _selectedPlant.value = null
    }

    fun addPlant(plant: Plant) {
        _plantList.update { currentList -> currentList + plant }
    }

    fun removePlant(plant: Plant) {
        _plantList.update { currentList -> currentList.filter { it.id != plant.id } }
    }

    fun updatePlant(updatedPlant: Plant) {
        _plantList.update { currentList ->
            currentList.map { if (it.id == updatedPlant.id) updatedPlant else it }
        }
    }
}