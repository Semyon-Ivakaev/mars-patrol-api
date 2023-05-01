package com.marspatrol.marspatrolapi.entity

import jakarta.persistence.*

@Entity
@Table(name = "models_3d")
class Models3DEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    @Column(name = "model_title")
    var modelTitle: String = "",
    @Column(name = "model_url")
    var modelUrl: String = "",
    @Column(name = "model_poster_url")
    var modelPosterUrl: String = "",
    @Column(name = "is_premium")
    var isPremium: Boolean = false,
)
