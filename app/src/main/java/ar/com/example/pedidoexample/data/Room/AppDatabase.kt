package ar.com.example.pedidoexample.data.Room

import androidx.room.Database
import androidx.room.RoomDatabase
import ar.com.example.pedidoexample.data.model.Assistant

@Database(entities = [Assistant::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun assistantDao():AssistantDao
}