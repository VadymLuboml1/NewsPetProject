package com.galaziukvadym.newspetproject.data.mappers

import com.galaziukvadym.newspetproject.NewsDomainModel
import com.galaziukvadym.newspetproject.data.services.NewsResponse

object NewsResponseMapper {

    fun mapResponse(newsResponse: NewsResponse): List<NewsDomainModel> {
        return newsResponse.articles?.map { newsItem ->
            NewsDomainModel(
                author = newsItem.author.orEmpty(),
                title = newsItem.title.orEmpty(),
                description = newsItem.description.orEmpty(),
                urlPath = newsItem.url.orEmpty(),
                urlImage = newsItem.urlToImage.orEmpty(),
                content = newsItem.content.orEmpty(),
            )
        } ?: emptyList()
    }
}