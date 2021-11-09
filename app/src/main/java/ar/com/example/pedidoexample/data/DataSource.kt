package ar.com.example.pedidoexample.data

import ar.com.example.pedidoexample.data.Room.AssistantDao
import ar.com.example.pedidoexample.data.model.Assistant
import javax.inject.Inject

class DataSource @Inject constructor (private val assistantDao: AssistantDao) {

    suspend fun saveAssistant(assistant: Assistant){
        assistantDao.insertAssistant(assistant)
    }

    suspend fun getAllAssistantByAge() : List<Assistant> =
        assistantDao.getAssistants()


}