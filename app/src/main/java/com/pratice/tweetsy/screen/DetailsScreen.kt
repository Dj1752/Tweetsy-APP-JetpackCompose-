package com.pratice.tweetsy.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pratice.tweetsy.viewmodels.DetailsTweetViewModel


@Composable
fun DetailsScreen() {
    val detailsViewModel : DetailsTweetViewModel = hiltViewModel()
    val tweet = detailsViewModel.tweets.collectAsState()

    LazyColumn(content = {
        items(tweet.value){
            TweetListItem(tweet = it.text)
        }
    })
}
@Composable
fun TweetListItem(tweet:String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        border = BorderStroke(1.dp, Color(0xFFCCCCCC)),
        content = {
            Text(text = tweet,
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.bodyMedium)
        }
    )

}