package com.marspatrol.marspatrolapi.service

import com.marspatrol.marspatrolapi.dto.RoverNewsDto

interface RoverNewsService {

    fun getAllRoverNews(): List<RoverNewsDto>

    fun getById(id: Int): RoverNewsDto

    fun search(prefix: String): List<RoverNewsDto>

    fun create(dto: RoverNewsDto): Int

    fun update(id: Int, dto: RoverNewsDto)

    fun delete(id: Int)
}