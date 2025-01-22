package com.wearerommies.roomie.domain.usecase

import com.wearerommies.roomie.domain.entity.DetailHouseEntity
import com.wearerommies.roomie.domain.repository.HouseRepository
import com.wearerommies.roomie.presentation.core.util.UiState
import timber.log.Timber
import javax.inject.Inject

class GetDetailHouseUseCase @Inject constructor(
    private val houseRepository: HouseRepository
) {
    suspend operator fun invoke(houseId: Long): Result<DetailHouseEntity> {
        return runCatching {
            val houseDetail = houseRepository.getHouseDetailImage(houseId).getOrThrow()
            val rooms = houseRepository.getRoomDetail(houseId).getOrThrow()
            DetailHouseEntity(
                detailHouseImageEntity = houseDetail, rooms = rooms

            )
        }.onFailure { error ->
            Timber.e(error)
        }
    }
}