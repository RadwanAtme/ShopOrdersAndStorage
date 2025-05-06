package com.example.shopordersandstorage.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Card
import androidx.compose.ui.Modifier

@Composable
fun ProductCard(
    modifier: Modifier
){
    Card (
        modifier = modifier
    ){
        Column(
            modifier = Modifier.fillMaxSize()
        ){
            //Image()

        }
    }
    /*
    Box(
        modifier = modifier.border(border = BorderStroke(wid))
    ){
        //Photo(),
        //Title(),
        //Text()
    }
     */
}