package com.example.weshop.presentations

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.weshop.R
import com.example.weshop.ui.theme.WeShopTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeShopTheme {
                val navController = rememberNavController()
                Scaffold(bottomBar = { BottomNavBar(
                    items = listOf(
                        BottomNavItem(R.drawable.ic_baseline_home_24,"Home","home"),
                        BottomNavItem(R.drawable.ic_baseline_people_24,"Users","users"),
                        BottomNavItem(R.drawable.ic_baseline_shopping_cart_24,"Carts","cart"),
                        BottomNavItem(R.drawable.ic_baseline_settings_24,"Settings","settings"),
                        BottomNavItem(R.drawable.ic_baseline_person_24,"Profile","profile"),
                    ),
                    navController =navController ,
                    modifier =Modifier ,
                    onItemClick = {
                        navController.navigate(it.route)
                    }
                )}) {
                    Navigation(navController = navController)
                }
            }
        }
    }
}

@Preview(showBackground = true, device = Devices.NEXUS_10)
@Composable
fun DefaultPreview() {
    WeShopTheme {
    }
}