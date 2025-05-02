package com.pratice.tweetsy.api

import com.pratice.tweetsy.model.Tweet
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface TweetsyAPI {
    @GET("v3/b/681500818561e97a500c7424?meta=false")
  suspend fun getTweets(@Header("X-JSON-Path") category:String): Response<List<Tweet>>

    @GET("v3/b/681500818561e97a500c7424?meta=false")
    @Headers("X-JSON-Path : tweets..category")
  suspend fun getCategory():Response<List<String>>
}