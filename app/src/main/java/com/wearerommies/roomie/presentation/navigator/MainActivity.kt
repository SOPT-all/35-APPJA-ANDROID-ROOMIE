package com.wearerommies.roomie.presentation.navigator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import com.wearerommies.roomie.presentation.reqres.ReqresRoute
import com.wearerommies.roomie.ui.theme.RoomieAndroidTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RoomieAndroidTheme {
                ReqresRoute(
                    paddingValues = PaddingValues(),
                    navigateUp = {}
                )
            }
        }
    }
}
