package com.example.cliprestproyect.domain

import android.content.Context
import com.example.cliprestproyect.data.ResultsRepository
import com.example.cliprestproyect.data.model.ResultsModel
import javax.inject.Inject

class GetApiNewResultUseCase @Inject constructor(private val repository : ResultsRepository) {

    suspend operator fun invoke(): ResultsModel?{
        return repository.requestApiResults();
    }

}