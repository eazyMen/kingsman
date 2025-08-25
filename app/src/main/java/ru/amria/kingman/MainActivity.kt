package ru.amria.kingman

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import dagger.hilt.android.AndroidEntryPoint
import ru.amria.kingman.ui.ar.ArActivity
import ru.amria.kingman.ui.fashn.FashnScreenCompose
import ru.amria.kingman.ui.home.HomeScreen
import ru.amria.kingman.ui.navigation.FashnScreen
import ru.amria.kingman.ui.navigation.Home
import ru.amria.kingman.ui.navigation.Tutorial
import ru.amria.kingman.ui.theme.KingmanTheme
import ru.amria.kingman.ui.tutorial.TutorialScreen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            KingmanTheme {
                NavHost(navController = navController, startDestination = Tutorial) {
                    composable<Tutorial> {
                        TutorialScreen(
                            onClick = {
                                navController.navigate(Home)
                            }
                        )
                    }
                    composable<Home> {
                        HomeScreen(
                            onDetail = {

                            },
                            onFitting = { img, name ->
                                navController.navigate(FashnScreen(img, name))
                            },
                            onAR = { lensId ->
                                Intent(this@MainActivity, ArActivity::class.java).apply {
                                    putExtra("lensId", lensId)
                                    startActivity(this)
                                }
                            }
                        )
                    }
                    composable<FashnScreen> { backStackEntry ->
                        val args = backStackEntry.toRoute<FashnScreen>()
                        FashnScreenCompose(args.img, args.name)
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