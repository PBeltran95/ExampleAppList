package ar.com.example.pedidoexample.domain

import ar.com.example.pedidoexample.data.DataSource
import ar.com.example.pedidoexample.data.model.Assistant
import javax.inject.Inject

class RepoImpl @Inject constructor (private val dataSource: DataSource) : Repo {
    override suspend fun saveAssistant(assistant: Assistant) {
        dataSource.saveAssistant(assistant)
    }

    override suspend fun getAssistantsFromAge(): List<Assistant> =
         dataSource.getAllAssistantByAge()

}