package com.galaziukvadym.newspetproject.presentation.adapter

sealed class RecordUiModel()

data class NewsUiModel(
    val title: String,
    val author: String,
    val content: String,
    val urlImage: String,
    val urlPath: String,
) : RecordUiModel()

//not implemented
data class AdditionalInfoUiModel(val some: String) : RecordUiModel()