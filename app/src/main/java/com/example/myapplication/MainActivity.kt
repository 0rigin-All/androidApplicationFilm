package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.FirstTheme




class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            FirstTheme {

                    val windowSizeClass = calculateWindowSizeClass(this)

                        val navController = rememberNavController()
                        val navBackStackEntry by navController.currentBackStackEntryAsState()
                        val currentDestination = navBackStackEntry?.destination?.route

                        val destinations = listOf(Destination.Profil, Destination.Film)
                        Scaffold(
                            bottomBar = { BottomNavigation {
                                destinations.forEach { screen ->
                                    BottomNavigationItem(
                                        icon = { Icon(screen.icon, contentDescription = null) },
                                        label = { Text(screen.label) },
                                        selected =
                                        currentDestination == screen.destination,
                                        onClick = { navController.navigate(screen.destination) })
                                }}
                            }) { innerPadding ->
                            NavHost(navController, startDestination = Destination.Profil.destination,
                                Modifier.padding(innerPadding)) {
                                composable(Destination.Profil.destination) { Profil(windowSizeClass){ navController.navigate("ProfilTest") } }
                                composable(Destination.Film.destination) { ProfilTest(windowSizeClass) { navController.navigate("Profil") } }
                            }
                        }

            }
        }
    }
}

sealed class Destination(val destination: String, val label: String, val icon: ImageVector) {
    object Profil : Destination("profil", "Mon Profil", Icons.Filled.Person)
    object Film : Destination("film", "film", Icons.Filled.Edit)
}
val destinations = listOf(Destination.Profil, Destination.Film)





