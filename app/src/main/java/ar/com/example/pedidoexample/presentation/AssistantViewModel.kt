package ar.com.example.pedidoexample.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import ar.com.example.pedidoexample.data.model.Assistant
import ar.com.example.pedidoexample.domain.RepoImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class AssistantViewModel @Inject constructor (private val repo: RepoImpl) : ViewModel() {

    fun fetchAssistantsByAge() = liveData(Dispatchers.IO) {
        try {
            emit(repo.getAssistantsFromAge())
        }catch (e:Exception){

        }
    }


    fun saveAssistant(assistant: Assistant){
        viewModelScope.launch {
            repo.saveAssistant(assistant)
        }
    }

}