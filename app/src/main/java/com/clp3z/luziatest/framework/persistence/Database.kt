package com.clp3z.luziatest.framework.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import com.clp3z.luziatest.framework.persistence.dao.PlanetsDAO
import com.clp3z.luziatest.framework.persistence.model.LocalPlanet

@Database(
    entities = [LocalPlanet::class],
    version = 1,
    exportSchema = false,
)
abstract class Database : RoomDatabase() {
    abstract fun planetsDao(): PlanetsDAO
}