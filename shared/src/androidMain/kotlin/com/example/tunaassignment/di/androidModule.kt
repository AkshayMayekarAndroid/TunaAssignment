package com.example.tunaassignment.di

import com.example.tunaassignment.Presentation.MainViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val androidModule =  module {
    viewModel { MainViewModel(get()) }
}