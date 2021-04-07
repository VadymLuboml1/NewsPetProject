package com.galaziukvadym.newspetproject.data.mappers

import com.galaziukvadym.newspetproject.NewsDomainModel
import com.galaziukvadym.newspetproject.data.database.NewsDatabaseDto

object NewsCachedItemsMapper {

    fun mapCachedItems(items: List<NewsDatabaseDto>): List<NewsDomainModel> =
        items.map { newsItem ->
            NewsDomainModel(
                author = newsItem.author,
                title = newsItem.title,
                description = newsItem.description,
                urlPath = newsItem.urlPath,
                urlImage = newsItem.urlImage,
                content = newsItem.content,
            )
        }

    fun mapNewsDomainModels(newsDomainModels: List<NewsDomainModel>): List<NewsDatabaseDto> =
        newsDomainModels.map { newsDomainModel ->
            NewsDatabaseDto(
                author = newsDomainModel.author,
                title = newsDomainModel.title,
                description = newsDomainModel.description,
                urlPath = newsDomainModel.urlPath,
                urlImage = newsDomainModel.urlImage,
                content = newsDomainModel.content,
            )
        }

}