package com.example.plantai2.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Plant(
    @PrimaryKey
    val id: Int = 0,
    val strainType: String,
    val strainSource: String,
    val plantAge: String,
    val humidityLevel: String,
    val temperatureLevel: String,
    val lightExposure: String,
    val soilType: String,
    val pHLevels: String,
    val wateringSchedule: String,
    val nutrientBrand: String,
    val nutrientFrequency: String,
    val plantHeight: String,
    val leafCondition: String,
    val pestSigns: String,
    val desiredYield: String,
    val preferredHarvestTime: String,
    val previousGrowthCycles: String,
    val methodChanges: String

): Serializable