package com.example.shopordersandstorage.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import com.example.shopordersandstorage.navigation.NavigationItem
import com.example.shopordersandstorage.navigation.Screen.Home
import com.example.shopordersandstorage.navigation.Screen.Orders
import com.example.shopordersandstorage.navigation.Screen.Items

object Constants{
    val NavigationItems = listOf(
        NavigationItem(
            title = "Home",
            icon = Icons.Default.Home,
            route = Home.route
        ),
        NavigationItem(
            title = "Items",
            icon = Icons.Default.Star,
            route = Items.route
        ),
        NavigationItem(
            title = "Orders",
            icon = Icons.Default.ShoppingCart,
            route = Orders.route
        )
    )
}