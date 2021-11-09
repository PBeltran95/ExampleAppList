package ar.com.example.pedidoexample.domain

import ar.com.example.pedidoexample.data.model.Assistant

interface Repo {

    suspend fun saveAssistant(assistant: Assistant)

    suspend fun getAssistantsFromAge() : List<Assistant>


}