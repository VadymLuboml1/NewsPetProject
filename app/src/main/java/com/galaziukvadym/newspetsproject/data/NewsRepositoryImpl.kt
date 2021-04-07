package com.galaziukvadym.newspetproject.data

import com.galaziukvadym.newspetproject.NewsDomainModel
import com.galaziukvadym.newspetproject.data.mappers.NewsResponseMapper
import com.galaziukvadym.newspetproject.data.services.NewsService
import com.galaziukvadym.newspetproject.domain.data.NewsRepository
import io.reactivex.Single

class NewsRepositoryImpl constructor(
    private val newsService: NewsService,
) : NewsRepository {

    override fun requestNews(): Single<List<NewsDomainModel>> =
        newsService.requestNews()
            .map(NewsResponseMapper::mapResponse)

}