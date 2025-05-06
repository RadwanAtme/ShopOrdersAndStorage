package com.example.shopordersandstorage.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shopordersandstorage.R

@Composable
fun ProductCard(
    modifier: Modifier,
    title: String,
    subtitle: String,
    price: String
){
    Card (
        modifier = modifier.fillMaxWidth(),
    ){
        Column(
            modifier = Modifier.fillMaxSize(),
        ){
            Box(
                modifier = Modifier.fillMaxWidth().weight(2f).
                clip(
                    shape = RoundedCornerShape(
                        bottomStart = 16.dp,
                        bottomEnd = 16.dp)
                )
            ){
                Image(
                    painter = painterResource(R.drawable.photo),
                    contentDescription = null,
                    contentScale = ContentScale.Inside,
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(10.dp),
                horizontalAlignment = Alignment.End
            ){
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    //modifier = Modifier.padding(10.dp)
                )
                Text(
                    text = subtitle,
                    //ontWeight = FontWeight,
                    fontSize = 12.sp,
                    //modifier = Modifier.padding( PaddingValues(horizontal = 10.dp),
                )
                Row(
                    modifier = Modifier.fillMaxWidth()
                ){
                    Text(
                        text = price,
                        fontSize = 12.sp,
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun Preview(){
    ProductCard(
        modifier = Modifier.height(270.dp).width(200.dp),
        title = "كوب",
        subtitle = "أكواب",
        price = "١٥",)
}