package com.clp3z.luziatest.app.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.clp3z.luziatest.app.navigation.Navigation
import com.clp3z.luziatest.app.navigation.rememberMainState
import com.clp3z.luziatest.framework.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                Navigation(mainState = rememberMainState())
            }
        }
    }
}
