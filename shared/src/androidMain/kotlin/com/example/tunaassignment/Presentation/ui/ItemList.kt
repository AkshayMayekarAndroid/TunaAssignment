package com.example.tunaassignment.Presentation.ui

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tunaassignment.domain.ResponseState
import com.example.tunaassignment.domain.model.Test
import com.example.tunaassignment.Presentation.MainViewModel

@Composable
fun ItemList(testViewModel: MainViewModel) {
    // Sample data for the list
    val list by testViewModel.test.collectAsState()
    Log.d("AKSHAY","list ${list?.data}")
    when(list){
        is ResponseState.Loading -> {
            Loader(true)
        }
        is ResponseState.Success -> {
           val data = (list as ResponseState.Success).data
            data?.let { it ->
                LazyColumn {
                    items(it) { item ->
                        ListItem(item = item)
                    }
                }
            }
        }
        is ResponseState.Error ->{}
        else -> {}
    }
}

@Composable
fun ListItem(item: Test) {
    item.title?.let {
        Box(modifier = Modifier.padding(10.dp,10.dp)) {

            Text(
                text = it,
                fontSize = 20.sp,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

