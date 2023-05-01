package com.marspatrol.marspatrolapi.service.impl

import com.marspatrol.marspatrolapi.dto.RoverNewsDto
import com.marspatrol.marspatrolapi.entity.RoverNewsEntity
import com.marspatrol.marspatrolapi.exception.RoverNewsNotFoundException
import com.marspatrol.marspatrolapi.repository.RoverNewsRepository
import com.marspatrol.marspatrolapi.service.RoverNewsService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class RoverNewsServiceImpl(
    private val roverNewsRepository: RoverNewsRepository
) : RoverNewsService {

    override fun getAllRoverNews(): List<RoverNewsDto> {
        return roverNewsRepository.findByOrderByIdDesc().map { it.toDto() }
    }

    override fun getById(id: Int): RoverNewsDto {
        return roverNewsRepository.findByIdOrNull(id = id)?.toDto() ?: throw RoverNewsNotFoundException(newsId = id)
    }

    override fun search(prefix: String): List<RoverNewsDto> =
        roverNewsRepository.findByNewsTitleContainingIgnoreCaseOrderByIdDesc(prefix)
            .map { it.toDto() }

    override fun create(dto: RoverNewsDto): Int {
        return roverNewsRepository.save(dto.toEntity()).id
    }

    override fun update(id: Int, dto: RoverNewsDto) {
        val existingNews = roverNewsRepository.findByIdOrNull(id = id) ?: throw RoverNewsNotFoundException(newsId = id)

        existingNews.newsTitle = dto.newsTitle
        existingNews.newsUrl = dto.newsUrl
        existingNews.newsPost = dto.newsPost
        existingNews.isActual = dto.isActual

        roverNewsRepository.save(existingNews)
    }

    override fun delete(id: Int) {
        val existingNews = roverNewsRepository.findByIdOrNull(id = id) ?: throw RoverNewsNotFoundException(newsId = id)

        roverNewsRepository.deleteById(existingNews.id)
    }

    private fun RoverNewsEntity.toDto(): RoverNewsDto =
        RoverNewsDto(
            id = this.id,
            newsTitle = this.newsTitle,
            newsUrl = this.newsUrl,
            newsPost = this.newsPost,
            isActual = this.isActual,
        )

    private fun RoverNewsDto.toEntity(): RoverNewsEntity =
        RoverNewsEntity(
            newsTitle = this.newsTitle,
            newsUrl = this.newsUrl,
            newsPost = this.newsPost,
            isActual = this.isActual,
        )
}