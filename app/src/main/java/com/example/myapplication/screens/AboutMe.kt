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
import com.example.myapplication.navigation.Screens

@Composable
fun AboutMeScreen(navController: NavController,context: Context) {
    var isTyped = remember {
        mutableStateOf(false)
    }
    Surface(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = com.example.myapplication.R.drawable.bg),
            contentDescription = "Background of the app",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = 80.dp,
                    start = 30.dp
                ),
        ) {
            TypewriterText(
                texts = listOf(
                    "about_me>"
                ), delayTime = 0
            )
            Spacer(modifier = Modifier.padding(top = 100.dp))
            TypewriterText(
                texts = listOf(
                    "About me???`"
                ), delayTime = 1000
            )
            Spacer(modifier = Modifier.padding(top = 20.dp))
            TypewriterText(
                texts = listOf(
                    "Initially, I started by studying C++ and Java. After completing the course and the Java test, " +
                            "I immediately chose the direction, since there is a lot of money in this field of development, " +
                            "oh, there are many prospects for development. " +
                            "Originally wrote in java, relatively recently switched " +
                            "to new development technologies (Jetpack compose + kotlin)\n" +
                            "Briefly summarizing the results:\n" +
                            "Java development experience of 5 months\n" +
                            "Kotlin development experience of 4 months"
                ), delayTime = 2000
            )
            Spacer(modifier = Modifier.padding(top = 10.dp))
            TypewriterText(
                texts = listOf(
                    "Enter to continue"
                ), delayTime = 18000
            )
            Spacer(modifier = Modifier.padding(top = 10.dp))
            TypewriterText(texts = listOf(
                "home> "
            ), delayTime = 19000){
                navController.navigate(Screens.Home.name){
                    popUpTo(0)
                }
            }
            Spacer(modifier = Modifier.padding(top = 8.dp))
            TypewriterText(texts = listOf(
                "experience> "
            ), delayTime =19500){
                navController.navigate(Screens.Experience.name){
                    popUpTo(0)
                }
            }
            Spacer(modifier = Modifier.padding(top = 8.dp))
            TypewriterText(texts = listOf(
                "stack>"
            ),
                delayTime = 20000) {
                navController.navigate(Screens.Stack.name)
                {
                    popUpTo(0)
            }
            }
            Spacer(modifier = Modifier.padding(top = 8.dp))
            TypewriterText(texts = listOf(
                "contacts>"
            ),
                delayTime = 20500
            ){
                navController.navigate(Screens.Contacts.name){
                    popUpTo(0)
                }
            }


        }
    }
}
