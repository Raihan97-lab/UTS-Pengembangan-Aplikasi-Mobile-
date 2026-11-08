package com.example.aplikasikopidannyemil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.aplikasikopidannyemil.navigation.AppNavigation
import com.example.aplikasikopidannyemil.ui.theme.AplikasiKopiDanNyemilTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AplikasiKopiDanNyemilTheme {
                AppNavigation()
            }
        }
    }
}
