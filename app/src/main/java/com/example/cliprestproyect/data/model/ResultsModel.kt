package com.example.cliprestproyect.data.model

import com.google.gson.annotations.SerializedName
import java.util.*

class ResultsModel(
    @SerializedName("results") val results: List<Results>,
    @SerializedName("info") val info: Objects
) {
}