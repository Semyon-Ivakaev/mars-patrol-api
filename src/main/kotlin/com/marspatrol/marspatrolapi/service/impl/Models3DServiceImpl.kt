package com.marspatrol.marspatrolapi.service.impl

import com.marspatrol.marspatrolapi.dto.Models3DDto
import com.marspatrol.marspatrolapi.entity.Models3DEntity
import com.marspatrol.marspatrolapi.repository.Models3DRepository
import com.marspatrol.marspatrolapi.service.Models3DService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class Models3DServiceImpl(
    private val models3DRepository: Models3DRepository
): Models3DService {
    override fun getAllModels(): List<Models3DDto> {
        return models3DRepository.findByOrderById().map { it.toDto() }
    }

    override fun create(dto: Models3DDto): Int {
        return models3DRepository.save(dto.toEntity()).id
    }

    override fun getModelById(id: Int): Models3DDto {
        return models3DRepository.findByIdOrNull(id)?.toDto() ?: throw RuntimeException("Error")
    }

    override fun update(id: Int, dto: Models3DDto) {
        val existingModel = models3DRepository.findByIdOrNull(id) ?: throw RuntimeException("Error")

        existingModel.modelTitle = dto.modelTitle
        existingModel.modelUrl = dto.modelUrl
        existingModel.modelPosterUrl = dto.modelPosterUrl
        existingModel.isPremium = dto.isPremium

        models3DRepository.save(existingModel)
    }

    override fun delete(id: Int) {
        val existingModel = models3DRepository.findByIdOrNull(id) ?: throw RuntimeException("Error")

        models3DRepository.deleteById(existingModel.id)
    }

    private fun Models3DEntity.toDto(): Models3DDto =
        Models3DDto(
            id = this.id,
            modelTitle = this.modelTitle,
            modelUrl = this.modelUrl,
            modelPosterUrl = this.modelPosterUrl,
            isPremium = this.isPremium,
        )

    private fun Models3DDto.toEntity(): Models3DEntity =
        Models3DEntity(
            modelTitle = this.modelTitle,
            modelUrl = this.modelUrl,
            modelPosterUrl = this.modelPosterUrl,
            isPremium = this.isPremium,
        )
}