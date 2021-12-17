package com.example.cliprestproyect.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**Objeto no necesario, ya que se hace con un provide de Dagger Hilt**/
object RetrofitHelper {

    fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://randomuser.me/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    }

}