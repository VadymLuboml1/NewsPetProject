package com.galaziukvadym.newspetproject.data

import com.galaziukvadym.newspetproject.NewsDomainModel
import com.galaziukvadym.newspetproject.data.database.LocalSavedNewsDatabase
import com.galaziukvadym.newspetproject.data.mappers.NewsCachedItemsMapper
import com.galaziukvadym.newspetproject.domain.data.CachedNewsRepository
import io.reactivex.Observable
import javax.inject.Inject

class CachedNewsRepositoryImpl @Inject constructor(database: LocalSavedNewsDatabase) :
    CachedNewsRepository {

    private val cachedNewsDao = database.localSavedNewsDao

    override fun restoreNews(newsList: List<NewsDomainModel>) {
        val cachedItems = NewsCachedItemsMapper.mapNewsDomainModels(newsList)

        cachedNewsDao.clearAll()
        cachedNewsDao.addAll(cachedItems)
    }

    override fun getNewsObservable(): Observable<List<NewsDomainModel>> =
        cachedNewsDao.getAll()
            .map(NewsCachedItemsMapper::mapCachedItems)

}