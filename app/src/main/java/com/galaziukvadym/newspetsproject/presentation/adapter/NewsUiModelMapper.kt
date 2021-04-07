package com.galaziukvadym.newspetproject.presentation.adapter

import com.galaziukvadym.newspetproject.NewsDomainModel

object NewsUiModelMapper {

    fun map(newsDomainModels: List<NewsDomainModel>): List<NewsUiModel> {
        return newsDomainModels.map {
            NewsUiModel(
                title = it.title,
                author = it.author,
                content = it.content,
                urlImage = it.urlImage,
                urlPath = it.urlPath,
            )
        }
    }
}