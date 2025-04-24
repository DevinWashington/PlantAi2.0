package com.example.plantai2.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PlantDao {
    @Query("SELECT * FROM plant")
    suspend fun getAll(): List<Plant>

    @Query("SELECT * FROM plant WHERE id IN (:userIds)")
    suspend fun loadAllByIds(userIds: IntArray): List<Plant>



    @Insert
    suspend fun insertAll(vararg plants: Plant)

    @Delete
    suspend fun delete(plant: Plant)
}