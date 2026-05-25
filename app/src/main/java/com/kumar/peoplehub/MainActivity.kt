package com.kumar.peoplehub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.kumar.peoplehub.navigation.AppNavGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = android.graphics.Color.parseColor("#1976D2")
        WindowCompat.getInsetsController(window, window.decorView).isAppearanceLightStatusBars =
            false

        setContent {
            AppNavGraph()
        }
    }
}