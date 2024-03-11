package com.example.recyclerviewexercise.model

import androidx.annotation.DrawableRes

//Este es el modelo de datos de super heroes

data class SuperHero(
    var superHeroName: String,
    var realName: String,
    var publisher: String,
    @DrawableRes var photo: Int
)
