package com.example.cliprestproyect.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cliprestproyect.data.model.Results
import com.example.cliprestproyect.data.model.ResultsModel
import com.example.cliprestproyect.domain.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ResultsViewModel @Inject constructor(
    private val getRoomResultsUseCase: GetRoomResultsUseCase,
    private val getApiResultsUseCase: GetApiResultsUseCase,
    private val insertRoomResultsUseCase: InsertRoomResultsUseCase,
    private val getApiNewResultUseCase: GetApiNewResultUseCase,
    private val deleteAllResultsRoomUseCase: DeleteAllResultsRoomUseCase
) : ViewModel() {

    val isLoading = MutableLiveData<Boolean>();
    val resultsModel = MutableLiveData<List<Results>>();

    fun getResultsFromRoom() {
        viewModelScope.launch {
            isLoading.postValue(true);
            val results: List<Results> = getRoomResultsUseCase();
            if (results.isNullOrEmpty()) {
                requestResultsFromApi();
                isLoading.postValue(false)
                return@launch;
            }
            resultsModel.postValue(results);
            isLoading.postValue(false);
        }
    }

    suspend fun requestResultsFromApi() {
        val result: ResultsModel? = getApiResultsUseCase();
        if (result == null) {
            return;
        }
        insertRoomResultsUseCase.insert(result.results[0]);
        val roomResults: List<Results> = getRoomResultsUseCase();
        resultsModel.postValue(roomResults);
    }

    fun requestApiNewResult() {
        viewModelScope.launch {
            isLoading.postValue(true);
            val results: ResultsModel? = getApiNewResultUseCase();
            if (results == null) {
                return@launch;
            }
            insertRoomResultsUseCase.insert(results.results[0]);
            val roomResults: List<Results> = getRoomResultsUseCase();
            resultsModel.postValue(roomResults);
            isLoading.postValue(false);
        }
    }

    fun deleteAllResultsRoom() {
        viewModelScope.launch {
            isLoading.postValue(true);
            deleteAllResultsRoomUseCase();
            resultsModel.postValue(emptyList());
            isLoading.postValue(false);
        }
    }

}