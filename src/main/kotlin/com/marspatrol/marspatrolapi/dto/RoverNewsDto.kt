package com.marspatrol.marspatrolapi.dto

data class RoverNewsDto (
    val id: Int? = null,
    val newsTitle: String,
    val newsUrl: String,
    val newsPost: String,
    val isActual: Boolean,
)