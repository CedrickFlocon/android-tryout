package com.cedrickflocon.android.tryout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            Column {
                Row {
                    BasicText(" Sport ", Modifier.clickable {
                        navController.navigate("sport")
                    })

                    BasicText(" Movie ", Modifier.clickable {
                        navController.navigate("movie")
                    })
                }

                Row {
                    BasicText(" Pop ", Modifier.clickable {
                        navController.popBackStack().also {
                            println("pop success : $it")
                        }
                    })

                    BasicText(" NavWithPop ", Modifier.clickable {
                        if (!navController.popBackStack("""home?completeEndpoint=%7B%22method%22%3A%22GET%22%2C%22url%22%3A%22https%3A%2F%2Fqa-api.fubo.tv%2Fpapi%2Fv1%2Fpage%2Fhome%3FtrkOriginComponent%3Dmain_navigation%26trkOriginElement%3Dhome%22%2C%22payload%22%3Anull%7D,asRootScreen=true,publicPath=/home,screenId=home,profileId=0e9a3046-b10f-46b5-902b-e8611843eadf""", false).also {
                                println("PopBackStack with param: $it")
                            }) {
                            println("Navigate with clear")
                            navController.navigate("""home?completeEndpoint=%7B%22method%22%3A%22GET%22%2C%22url%22%3A%22https%3A%2F%2Fqa-api.fubo.tv%2Fpapi%2Fv1%2Fpage%2Fhome%3FtrkOriginComponent%3Dmain_navigation%26trkOriginElement%3Dhome%22%2C%22payload%22%3Anull%7D,asRootScreen=true,publicPath=/home,screenId=home,profileId=0e9a3046-b10f-46b5-902b-e8611843eadf""") {
                                popUpTo(0)
                            }
                        } else {
                            println("No Navigate should scroll top")
                        }

                    })
                }

                NavHost(
                    navController = navController,
                    startDestination = """home?completeEndpoint=%7B%22method%22%3A%22GET%22%2C%22url%22%3A%22https%3A%2F%2Fqa-api.fubo.tv%2Fpapi%2Fv1%2Fpage%2Fhome%3FtrkOriginComponent%3Dmain_navigation%26trkOriginElement%3Dhome%22%2C%22payload%22%3Anull%7D,asRootScreen=true,publicPath=/home,screenId=home,profileId=ba3f024a-0079-4643-ba8c-2023bb958f9a""",
                    modifier = Modifier.padding(16.dp)
                ) {
                    composable("home") {
                        println()
                        val i = rememberSaveable { mutableStateOf(0) }
                        BasicText("Home ${i.value}", Modifier.clickable { i.value++ })
                    }

                    composable("sport") {
                        val i = rememberSaveable { mutableStateOf(0) }
                        BasicText("sport ${i.value}", Modifier.clickable { i.value++ })
                    }

                    composable("movie") {
                        val i = rememberSaveable { mutableStateOf(0) }
                        BasicText("Movie ${i.value}", Modifier.clickable { i.value++ })
                    }

                }

                LaunchedEffect(navController) {
                    navController.currentBackStack
                        .collect { println(it.joinToString("\n")) }
                }
            }
        }
    }

}
