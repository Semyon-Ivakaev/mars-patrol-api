package com.marspatrol.marspatrolapi.dto

/**
 *                 poster_url = "https://mars.nasa.gov/system/resources/gltf_poster_files/24881_Mars_1_6792.jpg",
model_url = "https://mars.nasa.gov/gltf_embed/24881",
description = "Planet Mars"
 */
class Models3DDto(
    val id: Int? = null,
    var modelTitle: String,
    var modelUrl: String,
    var modelPosterUrl: String,
    var isPremium: Boolean,
)

