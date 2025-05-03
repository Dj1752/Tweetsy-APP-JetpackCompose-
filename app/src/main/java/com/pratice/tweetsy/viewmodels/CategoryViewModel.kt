package com.pratice.tweetsy.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pratice.tweetsy.repository.TweetRespository
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class CategoryViewModel @Inject constructor(private val respository: TweetRespository) :ViewModel() {
    val categories: StateFlow<List<String>>
        get() = respository.categorys

    init {
        viewModelScope.launch {
            respository.getCategories()
        }
    }
}