package com.example.myapplication.screens

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.attendancechecker.utils.PlayTypingBg
import com.example.attendancechecker.utils.TypewriterText
import com.example.myapplication.navigation.Screens

@Composable
fun HomeScreen(navController: NavController,context:Context){
    var isTyped by remember {
        mutableStateOf(false)
    }
    PlayTypingBg()
    val mContext = LocalContext.current
    Surface(modifier = Modifier.fillMaxSize()) {
        Image(painter = painterResource(id =com.example.myapplication.R.drawable.bg),
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
            TypewriterText(texts = listOf(
                "home>"
            ), delayTime = 0)
            Spacer(modifier = Modifier.padding(top = 100.dp))
            TypewriterText(texts = listOf(
                "Hi %recruiter%"
            ), delayTime = 800)
            Spacer(modifier = Modifier.padding(top = 20.dp))
            TypewriterText(texts = listOf(
                "I am Amir Slanbek, a professional android developer"
            ), delayTime = 2000)
            Spacer(modifier = Modifier.padding(top = 10.dp))
            TypewriterText(texts = listOf(
                "Enter to continue"
            ), delayTime = 4000)
            Spacer(modifier = Modifier.padding(top = 10.dp))
            TypewriterText(texts = listOf(
                "about_me> "
            ), delayTime = 5000){
                navController.navigate(Screens.AboutMe.name){
                    popUpTo(0)
                }
            }
            Spacer(modifier = Modifier.padding(top = 8.dp))
            TypewriterText(texts = listOf(
                "experience> "
            ), delayTime =5500){
                navController.navigate(Screens.Experience.name){
                    popUpTo(0)
                }
            }
            Spacer(modifier = Modifier.padding(top = 8.dp))
            TypewriterText(texts = listOf(
                "stack> "
            ),
            delayTime = 6000){
                navController.navigate(Screens.Stack.name)
                {
                    popUpTo(0)
                }
            }
            Spacer(modifier = Modifier.padding(top = 8.dp))
            TypewriterText(texts = listOf(
                "contacts> "
            ),
                delayTime = 6500,
                ){
                navController.navigate(Screens.Contacts.name)
                {
                    popUpTo(0)
                }
            }

            Spacer(modifier = Modifier.padding(top = 8.dp))
        }

    }
}
