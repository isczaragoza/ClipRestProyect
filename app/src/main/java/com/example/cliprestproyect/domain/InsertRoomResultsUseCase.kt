package com.example.cliprestproyect.domain

import android.content.Context
import com.example.cliprestproyect.data.ResultsRepository
import com.example.cliprestproyect.data.model.Results
import javax.inject.Inject

class InsertRoomResultsUseCase @Inject constructor(private val repository : ResultsRepository) {

    suspend fun insert(result: Results) {
        repository.insertRoomResults(result);
    }

}