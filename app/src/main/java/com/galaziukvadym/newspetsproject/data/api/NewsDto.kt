package com.galaziukvadym.newspetproject.data.services

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class NewsResponse(@SerializedName("articles") val articles: List<NewsDto>?)

data class NewsDto(
    @SerializedName("sources") val sources: String?,
    @SerializedName("author") val author: String?,
    @SerializedName("title") val title: String?,
    @SerializedName("discription") val description: String?,
    @SerializedName("URL", alternate = ["url"]) val url: String?,
    @SerializedName("urlToImage") val urlToImage: String?,
    @SerializedName("publishedAt") val publishedAt: String?,
    @SerializedName("content") val content: String?,
) : Serializable