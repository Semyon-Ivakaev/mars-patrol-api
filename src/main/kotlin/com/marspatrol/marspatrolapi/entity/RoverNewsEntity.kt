package com.marspatrol.marspatrolapi.entity

import jakarta.persistence.*

@Entity
@Table(name = "rover_news")
class RoverNewsEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    @Column(name = "news_title")
    var newsTitle: String = "",
    @Column(name = "news_url")
    var newsUrl: String = "",
    @Column(name = "news_post")
    var newsPost: String = "",
    @Column(name = "is_actual")
    var isActual: Boolean = true,
)