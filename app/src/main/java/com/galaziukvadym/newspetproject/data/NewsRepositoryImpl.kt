package com.galaziukvadym.newspetproject.data

import com.galaziukvadym.newspetproject.NewsDomainModel
import com.galaziukvadym.newspetproject.data.mappers.NewsResponseMapper
import com.galaziukvadym.newspetproject.data.api.NewsApi
import com.galaziukvadym.newspetproject.domain.data.NewsRepository
import io.reactivex.Single

class NewsRepositoryImpl constructor(
    private val newsApi: NewsApi,
) : NewsRepository {

    override fun requestNews(): Single<List<NewsDomainModel>> =
        newsApi.requestNews()
            .map(NewsResponseMapper::mapResponse)

}