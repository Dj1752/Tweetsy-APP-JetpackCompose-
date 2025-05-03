package com.pratice.tweetsy.repository

import com.pratice.tweetsy.api.TweetsyAPI
import com.pratice.tweetsy.model.Tweet
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class TweetRespository @Inject constructor(private val tweetsyAPI: TweetsyAPI) {


    private val _categories = MutableStateFlow<List<String>>(emptyList())
    val categorys: StateFlow<List<String>>
        get() = _categories
    private val _tweets = MutableStateFlow<List<Tweet>>(emptyList())
    val tweets: StateFlow<List<Tweet>>
        get() = _tweets
    suspend fun getCategories(){
        val response = tweetsyAPI.getCategory()
        if(response.isSuccessful && response != null){
           _categories.emit(response.body()!!)
        }
    }
    suspend fun getTweets(category: String){
        val response = tweetsyAPI.getTweets(category)
        if(response.isSuccessful && response != null){
           _tweets.emit(response.body()!!)
        }
    }

}