package com.galaziukvadym.newspetproject.data.services

import io.reactivex.Single
import retrofit2.http.GET

interface NewsService {

    @GET("/v2/top-headlines?country=us&category=business&apiKey=${API_KEY}")
    fun requestNews(): Single<NewsResponse>

}

