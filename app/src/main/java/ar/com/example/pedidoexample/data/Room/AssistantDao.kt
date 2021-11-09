package ar.com.example.pedidoexample.data.Room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ar.com.example.pedidoexample.data.model.Assistant

@Dao
interface AssistantDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAssistant(assistant: Assistant)


    @Query("SELECT * FROM assistant")
    suspend fun getAssistants(): List<Assistant>

}