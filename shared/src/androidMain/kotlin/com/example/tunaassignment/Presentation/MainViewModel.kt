package com.example.tunaassignment.Presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tunaassignment.domain.repository.TestRepository
import com.example.tunaassignment.domain.ResponseState
import com.example.tunaassignment.domain.model.Test
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(val testRepository: TestRepository) : ViewModel() {

    private var _test = MutableStateFlow<ResponseState<List<Test>>?>(null)
    val test: StateFlow<ResponseState<List<Test>>?> get() = _test

    init {
        fetchData()
    }
    private fun fetchData() {
        viewModelScope.launch(Dispatchers.IO) {
            testRepository.fetchData().collect() {
                Log.d("AKSHAY1","list ${it.data}")

                _test.value = it
            }
        }
    }
}