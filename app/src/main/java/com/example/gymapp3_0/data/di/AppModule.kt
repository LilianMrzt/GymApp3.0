package com.example.gymapp3_0.data.di

import android.content.Context
import androidx.room.Room
import com.example.gymapp3_0.core.Constants.Companion.EXERCISE_TABLE
import com.example.gymapp3_0.core.Constants.Companion.SESSION_TABLE
import com.example.gymapp3_0.core.Constants.Companion.SET_TABLE
import com.example.gymapp3_0.data.database.*
import com.example.gymapp3_0.data.repository.ExerciseRepositoryImpl
import com.example.gymapp3_0.data.repository.SessionRepositoryImpl
import com.example.gymapp3_0.data.repository.SetRepositoryImpl
import com.example.gymapp3_0.domain.repository.ExerciseRepository
import com.example.gymapp3_0.domain.repository.SessionRepository
import com.example.gymapp3_0.domain.repository.SetRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    //Session Database
    @Provides
    fun provideSessionDb(
        @ApplicationContext
        context: Context
    ) = Room.databaseBuilder(
        context,
        SessionDb::class.java,
        SESSION_TABLE
    ).build()

    @Provides
    fun provideSessionDao(
        sessionDb: SessionDb
    ) = sessionDb.sessionDao()

    @Provides
    fun provideSessionRepository(
        sessionDao: SessionDao
    ): SessionRepository = SessionRepositoryImpl(
        sessionDao = sessionDao
    )

    //Exercise Database
    @Provides
    fun provideExerciseDb(
        @ApplicationContext
        context: Context
    ) = Room.databaseBuilder(
        context,
        ExerciseDb::class.java,
        EXERCISE_TABLE
    ).build()

    @Provides
    fun provideExerciseDao(
        exerciseDb: ExerciseDb
    ) = exerciseDb.exerciseDao()

    @Provides
    fun provideExerciseRepository(
        exerciseDao: ExerciseDao
    ): ExerciseRepository = ExerciseRepositoryImpl(
        exerciseDao = exerciseDao
    )

    //Set Database
    @Provides
    fun provideSetDb(
        @ApplicationContext
        context: Context
    ) = Room.databaseBuilder(
        context,
        SetDb::class.java,
        SET_TABLE
    ).build()

    @Provides
    fun provideSetDao(
        setDb: SetDb
    ) = setDb.setDao()

    @Provides
    fun provideSetRepository(
        setDao: SetDao
    ): SetRepository = SetRepositoryImpl(
        setDao = setDao
    )
}