package com.marspatrol.marspatrolapi.repository

import com.marspatrol.marspatrolapi.entity.Models3DEntity
import org.springframework.data.repository.CrudRepository

interface Models3DRepository: CrudRepository<Models3DEntity, Int> {

    fun findByOrderById(): List<Models3DEntity>
}