package com.example.shopordersandstorage

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.shopordersandstorage.ui.theme.ShopOrdersAndStorageTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.shopordersandstorage.utils.Constants
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.shopordersandstorage.views.HomeScreen
import com.example.shopordersandstorage.views.ItemsScreen
import com.example.shopordersandstorage.views.OrdersScreen
import com.example.shopordersandstorage.navigation.Screen.Home
import com.example.shopordersandstorage.navigation.Screen.Orders
import com.example.shopordersandstorage.navigation.Screen.Items

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShopOrdersAndStorageTheme {
                MyApplication()
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MyApplication() {
    val navController = rememberNavController()
    Surface (
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
        ){
        Scaffold(
            topBar = {
                DynamicTopAppBar(navController = navController)
            },
            bottomBar = {
                BottomNavigationBar(navController = navController)
            },
            content = { innerPadding ->
                NavHostContainer(
                    navController = navController,
                    padding = innerPadding
                )
            }
        )
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DynamicTopAppBar(
    navController: NavHostController
){
    // Observe current destination for dynamic TopAppBar
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    // Determine the title based on the current route
    val appBarTitle = when (currentRoute) {
        Home.route -> "Home"
        Items.route -> "Items"
        Orders.route -> "Orders"
        else -> "LOL"
    }

    TopAppBar(
        title = {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment =  Alignment.Center
            ){
                Text(text = appBarTitle)
            } },
    )

}

@Composable
fun NavHostContainer(
    navController: NavHostController,
    padding: PaddingValues
) {
    NavHost(
        navController = navController,
        // set the start destination as home
        startDestination = Home.route,
        // Set the padding provided by scaffold
        modifier = Modifier.padding(paddingValues = padding),
        builder = {
            // route : Home
            composable(Home.route) {
                HomeScreen()
            }
            // route : search
            composable(Items.route) {
                ItemsScreen()
            }
            // route : profile
            composable(Orders.route) {
                OrdersScreen()
            }
        })
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    NavigationBar(
        // set background color
        containerColor = Color(0xFF0F9D58)
    ){
        // observe the backstack
        val navBackStackEntry by navController.currentBackStackEntryAsState()

        // observe current route to change the icon
        // color,label color when navigated
        val currentRoute = navBackStackEntry?.destination?.route

        // Bottom nav items we declared
        Constants.NavigationItems.forEach { navItem ->
            // Place the bottom nav items
            NavigationBarItem(
                // it currentRoute is equal then its selected route
                selected = currentRoute == navItem.route,

                // navigate on click
                onClick = {
                    navController.navigate(navItem.route)
                },

                // Icon of navItem
                icon = {
                    Icon(imageVector = navItem.icon, contentDescription = navItem.title)
                },

                // label
                label = {
                    Text(text = navItem.title)
                },
                alwaysShowLabel = false,

                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.White, // Icon color when selected
                    unselectedIconColor = Color.White, // Icon color when not selected
                    selectedTextColor = Color.White, // Label color when selected
                    indicatorColor = Color(0xFF195334) // Highlight color for selected item
                )
            )
        }
    }
}