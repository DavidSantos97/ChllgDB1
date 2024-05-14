package br.com.fiap.chllgdb1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import br.com.fiap.chllgdb1.screens.cadastroScreen
import br.com.fiap.chllgdb1.screens.cadastroScreenViewModel
import br.com.fiap.chllgdb1.screens.homeScreen
import br.com.fiap.chllgdb1.screens.loginScreen
import br.com.fiap.chllgdb1.screens.loginScreenViewModel
import br.com.fiap.chllgdb1.ui.theme.ChllgDB1Theme
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChllgDB1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberAnimatedNavController()
                    AnimatedNavHost(
                        navController = navController,
                        startDestination = "Home",
                        exitTransition = {
                            slideOutOfContainer(
                                towards = AnimatedContentTransitionScope.SlideDirection.End,
                                tween(500)
                            ) + fadeOut(animationSpec = tween(500))
                        },
                        enterTransition = {
                            slideIntoContainer(
                                towards = AnimatedContentTransitionScope.SlideDirection.Left,
                                tween(500)
                            ) + fadeIn(animationSpec = tween(500))
                        }
                    )
                    {
                        composable(route = "Home") {
                            homeScreen(navController)
                        }

                        composable(route = "Login") {
                            loginScreen(loginScreenViewModel(), navController)
                        }
                        composable(route = "Cadastro"){
                            cadastroScreen(cadastroScreenViewModel(),navController)
                        }

                    }
                }
            }
        }
    }
}

