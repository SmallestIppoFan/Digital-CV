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
import com.example.attendancechecker.utils.CustomText
import com.example.attendancechecker.utils.PlayTypingBg
import com.example.attendancechecker.utils.TypewriterText
import com.example.myapplication.R
import com.example.myapplication.navigation.Screens
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun ExperienceScreen(navController: NavController,context: Context) {
    var isTyped = remember {
        mutableStateOf(false)
    }
    val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
    val currentDate = sdf.format(Date())
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
            TypewriterText(texts = listOf("experience>"), delayTime = 0)
            Spacer(modifier = Modifier.padding(top = 100.dp))
            TypewriterText(texts = listOf("I hope you read about me first , only then the work experience"), delayTime = 1000)
            Spacer(modifier = Modifier.padding(top = 20.dp))
            TypewriterText(texts = listOf( "Unfortunately, I don't have much experience working in different companies \n" +
                    "One lab Internship only\n" +
                    "2022.10 - One lab internship\n" +
                    "$currentDate - still waiting for job ):"), delayTime = 3000)
            Spacer(modifier = Modifier.padding(top = 10.dp))
            TypewriterText(texts = listOf("Enter to continue"), delayTime = 10000)
            Spacer(modifier = Modifier.padding(top = 10.dp))
            TypewriterText(texts = listOf(
                "home> "
            ), delayTime = 10500){
                navController.navigate(Screens.Home.name){
                    popUpTo(0)
                }
            }
            Spacer(modifier = Modifier.padding(top = 8.dp))
            TypewriterText(texts = listOf(
                "contacts> "
            ), delayTime =11000){
                navController.navigate(Screens.Contacts.name){
                    popUpTo(0)
                }
            }
            Spacer(modifier = Modifier.padding(top = 8.dp))
            TypewriterText(texts = listOf(
                "stack> "
            ),
                delayTime = 11500){
                navController.navigate(Screens.Stack.name){
                    popUpTo(0)
                }
            }
            Spacer(modifier = Modifier.padding(top = 8.dp))
            TypewriterText(texts = listOf(
                "about_me> "
            ),
                delayTime = 12000
            ){
                navController.navigate(Screens.AboutMe.name){
                    popUpTo(0)
                }
            }
            Spacer(modifier = Modifier.padding(top = 8.dp))
        }

    }
}