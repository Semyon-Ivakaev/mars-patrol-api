package com.marspatrol.marspatrolapi.service

import com.marspatrol.marspatrolapi.dto.Models3DDto

interface Models3DService {

    fun getAllModels(): List<Models3DDto>

    fun getModelById(id: Int): Models3DDto

    fun create(dto: Models3DDto): Int

    fun update(id: Int, dto: Models3DDto)

    fun delete(id: Int)
}