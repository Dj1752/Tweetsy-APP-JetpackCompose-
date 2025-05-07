package com.pratice.tweetsy.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pratice.tweetsy.model.Tweet
import com.pratice.tweetsy.repository.TweetRespository
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailsTweetViewModel @Inject constructor(
    private val respository: TweetRespository,
  private val savedStateHandle:SavedStateHandle) :ViewModel() {
    val tweets: StateFlow<List<Tweet>>
        get() = respository.tweets

    init {
        viewModelScope.launch {
            respository.getTweets("motivation")
        }
    }
}