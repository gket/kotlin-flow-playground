package com.gketdev.flowplayground.utils

import com.gketdev.flowplayground.data.Food
import com.gketdev.flowplayground.data.Origin

object FoodGenerator {
    fun generateFoods(): ArrayList<Food> {
        val foodList: ArrayList<Food> = ArrayList()
        foodList.add(Food("Pizza", 9.12, Origin.ITALY))
        foodList.add(Food("Baklava", 7.0, Origin.TURKEY))
        foodList.add(Food("Pasta", 8.0, Origin.ITALY))
        foodList.add(Food("Kebab", 12.0, Origin.TURKEY))
        foodList.add(Food("Pad Thai", 10.0, Origin.THAILAND))
        foodList.add(Food("Kimchi", 10.50, Origin.KOREA))
        foodList.add(Food("Tom Yum ", 11.0, Origin.THAILAND))
        foodList.add(Food("Ramen ", 9.72, Origin.JAPAN))
        foodList.add(Food("Soupe à l’oignon ", 12.0, Origin.FRANCE))
        return foodList
    }
}