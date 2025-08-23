package ru.amria.kingman

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.amria.designsystem.base.BaseScaffoldContainer
import ru.amria.designsystem.widget.BannerWidget
import ru.amria.designsystem.widget.CategoryWidget
import ru.amria.kingman.ui.ar.ArActivity
import ru.amria.kingman.ui.home.HomeScreen
import ru.amria.kingman.ui.navigation.Home
import ru.amria.kingman.ui.theme.KingmanTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            KingmanTheme {
                NavHost(navController = navController, startDestination = Home) {
                    composable<Home> {
                        HomeScreen(
                            onDetail = {

                            },
                            onAR = {
                                Intent(this@MainActivity, ArActivity::class.java).apply {
                                    startActivity(this)
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KingmanTheme {
        Greeting("Android")
    }
}