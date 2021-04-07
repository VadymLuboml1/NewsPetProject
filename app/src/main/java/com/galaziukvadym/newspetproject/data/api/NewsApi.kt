package com.galaziukvadym.newspetproject.data.api

import io.reactivex.Single
import retrofit2.http.GET

interface NewsApi {

    @GET("/v2/top-headlines?country=us&category=business&apiKey=$API_KEY")
    fun requestNews(): Single<NewsResponse>

}

