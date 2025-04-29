package com.example.shopordersandstorage.views

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color

@Composable
fun OrdersScreen(){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ){
        Text(
            text = "Orders Screen",
            style = MaterialTheme.typography.headlineLarge
        )

    }
}