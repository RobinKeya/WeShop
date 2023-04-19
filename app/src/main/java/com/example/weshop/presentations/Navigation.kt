package com.example.weshop.presentations

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.weshop.presentations.productDetails.ProductDetailsScreen
import com.example.weshop.presentations.productDetails.ProductDetailsViewModel
import com.example.weshop.presentations.productsList.ProductListScreen
import com.example.weshop.presentations.productsList.ProductListViewModel

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController =navController , startDestination = "home" ){
        composable(route = "home"){
            val productListVm : ProductListViewModel = hiltViewModel()
            ProductListScreen(
                productListScreenState =productListVm.state.value){id ->
                navController.navigate("products/${id}")
            }
        }
        composable(
            route = "products/{product_id}",
            arguments = listOf(navArgument("product_id"){
                type= NavType.IntType
            })
        ){
            val productDetailVm : ProductDetailsViewModel = hiltViewModel()
            ProductDetailsScreen(productDetailScreenState = productDetailVm.state.value)
        }
        composable(route = "settings"){
            SettingScreen()
        }
        composable(route = "profile"){
            ProfileScreen()
        }
        composable(route = "users"){
            UsersScreen()
        }
        composable(route = "carts"){
            CartScreen()
        }
    }
}
@Composable
fun ProfileScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Center) {
        Text(text = "Profile screen")
    }
}
@Composable
fun SettingScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Center) {
        Text(text = "Settings screen")
    }
}

@Composable
fun UsersScreen() {
    Box(
        contentAlignment = Center,
        modifier = Modifier.fillMaxSize()
    ){
        Text(text = "UsersScreen")
    }
}

@Composable
fun CartScreen() {
    Box(
        contentAlignment = Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Carts Screen")
    }
}

@Composable
fun BottomNavBar(
    items: List<BottomNavItem>,
    navController: NavController,
    modifier: Modifier,
    onItemClick: (BottomNavItem)->Unit
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(
        modifier = modifier,
        elevation = 4.dp,
        backgroundColor = Color.White
    ) {
        items.forEach {item->
            val selected = item.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                onClick = { onItemClick(item) },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.Black,
                icon = {
                    Column(horizontalAlignment = CenterHorizontally) {
                        Icon(
                            painter = painterResource(id = item.id),
                            contentDescription = item.title
                        )
                        if (selected){
                            Text(text = item.title,
                            textAlign = TextAlign.Center, fontSize = 18.sp)
                        }
                    }
                }
            )
        }
    }

}