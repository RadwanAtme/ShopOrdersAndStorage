package com.example.shopordersandstorage.navigation

sealed class Screen(val route: String) {
    object Home: Screen("home_screen")
    object Items: Screen("items_screen")
    object Orders: Screen("orders_screen")
}