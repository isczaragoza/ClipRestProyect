package com.example.cliprestproyect.domain

import android.content.Context
import com.example.cliprestproyect.data.ResultsRepository
import javax.inject.Inject

class DeleteAllResultsRoomUseCase @Inject constructor(private val repository : ResultsRepository) {

    suspend operator fun invoke() {
        repository.deleteRoomAllResults();
    }

}