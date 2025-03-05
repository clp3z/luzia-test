package com.clp3z.luziatest.framework.persistence.di

import android.app.Application
import androidx.room.Room
import com.clp3z.luziatest.framework.persistence.Database
import com.clp3z.luziatest.framework.persistence.dao.PlanetsDAO
import com.clp3z.luziatest.framework.persistence.datasource.LocalPlanetsDataSource
import com.clp3z.luziatest.framework.persistence.datasource.LocalPlanetsDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {

    private const val DATABASE_NAME = "planets-database"

    @Provides
    @Singleton
    fun provideRoomDatabase(application: Application): Database =
        Room.databaseBuilder(
            context = application,
            klass = Database::class.java,
            name = DATABASE_NAME,
        ).build()

    @Provides
    @Singleton
    fun providePlanetsDAO(database: Database): PlanetsDAO = database.planetsDao()

    @Provides
    @Singleton
    fun provideLocalDataSource(planetsDAO: PlanetsDAO): LocalPlanetsDataSource =
        LocalPlanetsDataSourceImpl(planetsDAO)
}