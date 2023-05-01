package com.marspatrol.marspatrolapi.controller

import com.marspatrol.marspatrolapi.dto.Models3DDto
import com.marspatrol.marspatrolapi.dto.RoverNewsDto
import com.marspatrol.marspatrolapi.service.Models3DService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/models")
class Model3DController(
    val models3DService: Models3DService
) {

    @GetMapping
    fun getAllModels(): List<Models3DDto> = models3DService.getAllModels()

    @GetMapping("/{id}")
    fun getModelById(@PathVariable("id") id: Int): Models3DDto =
        models3DService.getModelById(id)

    @PostMapping
    fun create(@RequestBody dto: Models3DDto): Int {
        return models3DService.create(dto = dto)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Int, @RequestBody dto: Models3DDto) {
        models3DService.update(id, dto)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int) {
        models3DService.delete(id)
    }
}