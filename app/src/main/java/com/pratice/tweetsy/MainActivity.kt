package com.pratice.tweetsy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.pratice.tweetsy.screen.CategoryScreen
import com.pratice.tweetsy.screen.DetailsScreen
import com.pratice.tweetsy.ui.theme.TweetsyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TweetsyTheme {
                App()
            }
        }
    }
}


@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination ="category") {
        composable(route = "category") {
            CategoryScreen(onClick = {

            })
        }
        composable(
            route = "details/{category}", arguments = listOf(
            navArgument("category") {
                type = NavType.StringType
            }
        )) {
            DetailsScreen()
        }

    }

}
