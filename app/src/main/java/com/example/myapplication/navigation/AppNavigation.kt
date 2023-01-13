package com.example.attendancechecker.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.navigation.Screens
import com.example.myapplication.screens.*

@Composable
fun AppNavigation(){
    val mContext= LocalContext.current
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.Home.name){
        composable(route = Screens.Home.name){
            HomeScreen(navController,mContext)
        }
        composable(route = Screens.AboutMe.name){
            AboutMeScreen(navController,mContext)
        }
        composable(route=Screens.Contacts.name){
            ContactsScreen(navController,mContext)
        }
        composable(route=Screens.Experience.name){
            ExperienceScreen(navController,mContext)
        }
        composable(route=Screens.Stack.name){
            StackScreen(navController,mContext)
        }
    }
}