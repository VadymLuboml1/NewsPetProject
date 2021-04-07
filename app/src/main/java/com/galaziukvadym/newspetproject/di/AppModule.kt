package com.galaziukvadym.newspetproject.di

import android.content.Context
import androidx.room.Room
import com.galaziukvadym.newspetproject.data.CachedNewsRepositoryImpl
import com.galaziukvadym.newspetproject.data.NewsRepositoryImpl
import com.galaziukvadym.newspetproject.data.api.NewsApi
import com.galaziukvadym.newspetproject.data.database.LocalSavedNewsDatabase
import com.galaziukvadym.newspetproject.domain.data.CachedNewsRepository
import com.galaziukvadym.newspetproject.domain.data.NewsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val appContext: Context) {

    @Provides
    fun provideContext() = appContext

    @Singleton
    @Provides
    fun provideNewsRepository(newsApi: NewsApi): NewsRepository {
        return NewsRepositoryImpl(newsApi)
    }

    @Singleton
    @Provides
    fun provideCachedNewsRepository(database: LocalSavedNewsDatabase): CachedNewsRepository {
        return CachedNewsRepositoryImpl(database)
    }

    @Singleton
    @Provides
    fun provideDatabase(): LocalSavedNewsDatabase {
        return Room.databaseBuilder(
            appContext,
            LocalSavedNewsDatabase::class.java,
            LocalSavedNewsDatabase.DATABASE_NAME
        ).build()
    }

}