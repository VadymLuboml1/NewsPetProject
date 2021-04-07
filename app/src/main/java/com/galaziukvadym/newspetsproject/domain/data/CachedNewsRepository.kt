package com.galaziukvadym.newspetproject.domain.data

import com.galaziukvadym.newspetproject.NewsDomainModel
import io.reactivex.Completable
import io.reactivex.Observable

interface CachedNewsRepository {

    fun restoreNews(newsList: List<NewsDomainModel>)

    fun getNewsObservable(): Observable<List<NewsDomainModel>>
}