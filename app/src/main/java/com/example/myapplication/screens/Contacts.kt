package com.example.myapplication.screens

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.attendancechecker.utils.PlayTypingBg
import com.example.attendancechecker.utils.TypewriterText
import com.example.myapplication.R
import com.example.myapplication.navigation.Screens

@Composable
fun ContactsScreen(navController: NavController,context: Context) {
    var isTyped = remember {
        mutableStateOf(false)
    }
    Surface(modifier = Modifier.fillMaxSize()) {
        Image(painter = painterResource(id = R.drawable.bg),
            contentDescription = "Background of the app",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(
                top = 80.dp,
                start = 30.dp
            ),
        ) {
            TypewriterText(
                texts = listOf(
                    "contacts>"
                ), delayTime = 0
            )
            Spacer(modifier = Modifier.padding(top = 100.dp))
            //I don't like when people call me, but I will wait for your call, %recruiter% :)
            TypewriterText(texts = listOf("I don't like when people call me, but I will wait for your call, %recruiter% :)"), delayTime = 1000)
            Spacer(modifier = Modifier.padding(top = 10.dp))
            TypewriterText(
                texts = listOf(
                    "Phone +700 245 0251\n" +
                            "Telegram @slanbeek\n" +
                            "mail amiraccforwork@gmail.com"
                ), delayTime = 4000
            )
            Spacer(modifier = Modifier.padding(top = 10.dp))
            TypewriterText(texts = listOf("Enter to continue"), delayTime = 6500)
            Spacer(modifier = Modifier.padding(top = 10.dp))

            TypewriterText(texts = listOf(
                "home> "
            ), delayTime = 7000){
                navController.navigate(Screens.Home.name){
                    popUpTo(0)
                }
            }
            Spacer(modifier = Modifier.padding(top = 8.dp))
            TypewriterText(texts = listOf(
                "experience> "
            ), delayTime =7500){
                navController.navigate(Screens.Experience.name){
                    popUpTo(0)
                }
            }
            Spacer(modifier = Modifier.padding(top = 8.dp))
            TypewriterText(texts = listOf(
                "stack> "
            ),
                delayTime = 8000){
                navController.navigate(Screens.Stack.name){
                    popUpTo(0)
                }
            }
            Spacer(modifier = Modifier.padding(top = 8.dp))
            TypewriterText(texts = listOf(
                "about_me> "
            ),
                delayTime = 8500
            ){
                navController.navigate(Screens.AboutMe.name){
                    popUpTo(0)
                }
            }
        }

    }
}