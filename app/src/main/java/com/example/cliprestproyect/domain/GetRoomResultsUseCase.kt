package com.example.cliprestproyect.domain

import android.content.Context
import com.example.cliprestproyect.data.ResultsRepository
import com.example.cliprestproyect.data.model.Results
import javax.inject.Inject

class GetRoomResultsUseCase @Inject constructor(private val repository : ResultsRepository) {

    suspend operator fun invoke(): List<Results>{
        val results : List<Results> = repository.getRoomResults();
        return results;
    }

}