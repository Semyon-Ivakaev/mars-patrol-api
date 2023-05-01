package com.marspatrol.marspatrolapi.controller

import com.marspatrol.marspatrolapi.dto.RoverNewsDto
import com.marspatrol.marspatrolapi.service.RoverNewsService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/rover-news")
class RoverNewsController(
    private val roverNewsService: RoverNewsService,
) {

    @GetMapping
    fun getAllRoversNews(): List<RoverNewsDto> = roverNewsService.getAllRoverNews()

    @GetMapping("/{id}")
    fun getRoverNewsById(@PathVariable("id") id: Int): RoverNewsDto = roverNewsService.getById(id)

    @GetMapping("/search")
    fun searchRoverNews(@RequestParam("prefix") prefix: String): List<RoverNewsDto> =
        roverNewsService.search(prefix = prefix)

    @PostMapping
    fun create(@RequestBody dto: RoverNewsDto): Int {
        return roverNewsService.create(dto)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Int, @RequestBody dto: RoverNewsDto) {
        roverNewsService.update(id, dto)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int) {
        roverNewsService.delete(id)
    }
}