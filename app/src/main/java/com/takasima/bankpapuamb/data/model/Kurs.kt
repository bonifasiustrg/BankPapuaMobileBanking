package com.takasima.bankpapuamb.data.model

data class Kurs(
    val iconCountryFlag: Int, // Resource ID for the flag icon
    val kursName: String,
    val sellKurs: Float,
    val buyKurs: Float
)
