package com.marspatrol.marspatrolapi.repository

import com.marspatrol.marspatrolapi.entity.RoverNewsEntity
import org.springframework.data.repository.CrudRepository

interface RoverNewsRepository: CrudRepository<RoverNewsEntity, Int> {

    fun findByOrderByIdDesc(): List<RoverNewsEntity>

    fun findByNewsTitleContainingIgnoreCaseOrderByIdDesc(prefix: String): List<RoverNewsEntity>
}