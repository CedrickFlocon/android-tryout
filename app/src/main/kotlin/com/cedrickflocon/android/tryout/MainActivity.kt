package com.cedrickflocon.android.tryout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.text.BasicText
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicText(
                "Hello world",
                modifier = Modifier
                    .onFocusChanged { println(it) }
                    .focusable()
                    .clickable { println("HELLO") }
            )
        }
    }

}
