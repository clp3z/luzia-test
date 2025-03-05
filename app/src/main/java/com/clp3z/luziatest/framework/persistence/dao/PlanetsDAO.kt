package com.clp3z.luziatest.framework.persistence.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.clp3z.luziatest.framework.persistence.model.LocalPlanet
import kotlinx.coroutines.flow.Flow

@Dao
interface PlanetsDAO {

    @Query("SELECT * FROM LocalPlanet")
    fun getPlanets(): Flow<List<LocalPlanet>>

    @Query("SELECT * FROM LocalPlanet WHERE url = :url")
    fun getPlanet(url: String): Flow<LocalPlanet>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlanets(items: List<LocalPlanet>)

    @Query("SELECT COUNT(url) FROM LocalPlanet")
    suspend fun planetsCount(): Int
}
