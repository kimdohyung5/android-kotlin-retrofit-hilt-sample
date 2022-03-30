package com.kimdo.simpleapitest


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kimdo.simpleapitest.data.DataOrException
import com.kimdo.simpleapitest.model.QuestionItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject


@HiltViewModel
class QuestionViewModel @Inject constructor(private val repository: QuestionRepository): ViewModel() {
    val data: MutableLiveData< DataOrException<ArrayList<QuestionItem>,
            Boolean, Exception>> = MutableLiveData( DataOrException(null, true, Exception("")) )

    init {
        getAllQuestions()
    }

    private fun getAllQuestions() {
        viewModelScope.launch {
            data.value = repository.getAllQuestions()
        }
    }
    fun getTotalQuestionCount():Int {
        return data.value!!.data?.size!!
    }
}