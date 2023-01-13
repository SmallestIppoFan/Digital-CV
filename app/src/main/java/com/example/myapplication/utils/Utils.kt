package com.example.attendancechecker.utils

import android.annotation.SuppressLint
import android.content.Context
import android.media.MediaPlayer
import androidx.compose.foundation.clickable
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.example.myapplication.ui.theme.CustomAppColors
import com.example.myapplication.ui.theme.PixelFont
import kotlinx.coroutines.delay


@Composable
fun CustomText(
    text: String,
    modifier: Modifier =Modifier,
    onClick:() -> Unit= { Unit },

    ) {
    Text(text = text,
        fontSize = 20.sp,
        fontFamily = PixelFont,
        color = Color.Green,
        modifier=modifier.clickable {
              onClick()
        },

        )
}
@Composable
fun EnterPageTextField(
   pageName:MutableState<String>,
    imeAction: ImeAction=ImeAction.Done,
    onAction:KeyboardActions=KeyboardActions.Default
) {
    TextField(value = pageName.value, onValueChange = {
        pageName.value=it
    },
        singleLine = true,
        textStyle = TextStyle(fontSize = 20.sp,
            fontFamily = PixelFont,
            color = Color.Green),
        keyboardOptions = KeyboardOptions(
            imeAction = imeAction
        ),
        keyboardActions =onAction,
        colors = TextFieldDefaults.textFieldColors(
        )
       // modifier = Modifier.background(Color.Transparent)
    )
}

@SuppressLint("SuspiciousIndentation")
@Composable
fun TypewriterText(
    texts: List<String>,
    delayTime:Long,
    animationFinished: Boolean=false,
    onClick:() -> Unit= { Unit },
    )
{
    var textIndex by remember {
        mutableStateOf(0)
    }
    var textToDisplay by remember {
        mutableStateOf("")
    }
    LaunchedEffect(
        key1 = texts,
    ) {
        while (textIndex < texts.size) {
            delay(delayTime)
            texts[textIndex].forEachIndexed { charIndex, _ ->
                textToDisplay = texts[textIndex]
                    .substring(
                        startIndex = 0,
                        endIndex = charIndex + 1,
                    )
                    delay(30)
            }
            textIndex = (textIndex + 1) % texts.size
            break
        }
    }

    Text(
        text = textToDisplay,
        fontSize = 20.sp,
        fontFamily = PixelFont,
        color = CustomAppColors.textColor,
        modifier = Modifier.clickable {
            onClick()
        },
        style = MaterialTheme.typography.h4.copy(
            shadow = Shadow(
                color = CustomAppColors.textColor,
                offset = Offset(5f, 5f),
                blurRadius = 33f
            )
        )
    )
}

//@Composable
//fun PlayAudioBg(context:Context) {
//    val mpBackgroundSound: MediaPlayer =
//        MediaPlayer.create(context, com.example.myapplication.R.raw.bs_sound)
//    val mpWhenStarter: MediaPlayer =
//        MediaPlayer.create(context, com.example.myapplication.R.raw.when_started)
//    mpBackgroundSound.setVolume(0.1f, 0.1f)
//    mpWhenStarter.setVolume(0.2f, 0.2f)
//    mpWhenStarter.start()
//    mpBackgroundSound.start()
//    mpBackgroundSound.isLooping = true
//}


@Composable
fun PlayTypingBg(context: Context= LocalContext.current) {
    var mpTypingSound: MediaPlayer =
        MediaPlayer.create(context, com.example.myapplication.R.raw.bg_music)
    mpTypingSound.setVolume(0.2f, 0.2f)
    mpTypingSound.isLooping = true
    ComposableLifeCycle { source, event ->
        when (event) {
            Lifecycle.Event.ON_START -> {
                mpTypingSound.start()
            }
            Lifecycle.Event.ON_RESUME -> {
                mpTypingSound.start()
            }
            Lifecycle.Event.ON_STOP -> {
                mpTypingSound.pause()
            }
            Lifecycle.Event.ON_DESTROY -> {
            }

        }
    }
}

@Composable
fun ComposableLifeCycle(
    lifecycleOwner:LifecycleOwner= LocalLifecycleOwner.current,
    onEvent:(LifecycleOwner,Lifecycle.Event) ->Unit
    ) {
    DisposableEffect(lifecycleOwner){
        val observer = LifecycleEventObserver{source,event ->
            onEvent(source,event)
        }
        lifecycleOwner.lifecycle.addObserver(observer)

        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }
    
}

