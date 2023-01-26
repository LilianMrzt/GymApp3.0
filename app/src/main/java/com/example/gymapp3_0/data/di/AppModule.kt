package com.example.gymapp3_0.data.di

import android.content.Context
import androidx.room.Room
import com.example.gymapp3_0.core.Constants.Companion.SESSION_TABLE
import com.example.gymapp3_0.data.database.SessionDao
import com.example.gymapp3_0.data.database.SessionDb
import com.example.gymapp3_0.data.repository.SessionRepositoryImpl
import com.example.gymapp3_0.domain.repository.SessionRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
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
}