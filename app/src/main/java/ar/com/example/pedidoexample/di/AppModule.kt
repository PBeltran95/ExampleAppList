package ar.com.example.pedidoexample.di

import android.content.Context
import androidx.room.Room
import ar.com.example.pedidoexample.data.Room.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesRoom(@ApplicationContext context: Context) = Room.databaseBuilder(
        context, AppDatabase::class.java, "AssistantDb"
    ).build()

    @Provides
    @Singleton
    fun providesDao(db: AppDatabase) = db.assistantDao()


}