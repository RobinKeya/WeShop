package com.example.weshop.presentations

import androidx.annotation.DrawableRes

data class BottomNavItem(
    @DrawableRes val id: Int,
    val title: String,
    val route: String
)
