package com.galaziukvadym.newspetproject

import android.util.Log
import com.galaziukvadym.newspetproject.domain.data.CachedNewsRepository
import com.galaziukvadym.newspetproject.domain.data.NewsRepository
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject

class NewsListUseCase @Inject constructor(
    private val newsRepository: NewsRepository,
    private val cachedNewsRepository: CachedNewsRepository,
) {

    private val requestMoreSubject = BehaviorSubject.createDefault(Unit)

    fun subscribeOnNews(): Observable<List<NewsDomainModel>> {
        return actualNewsObservable()
            .mergeWith(
                cachedNewsRepository.getNewsObservable().subscribeOn(Schedulers.io()).doOnNext {
                    Log.d("NewsListUseCase", "cachedNewsRepository.getNews $it")
                })
            .distinctUntilChanged()
            .doOnNext { Log.d("NewsListUseCase", "subscribeOnNews $it") }
    }

    fun requestActualNews() = requestMoreSubject.onNext(Unit)

    private fun actualNewsObservable(): Observable<List<NewsDomainModel>> =
        requestMoreSubject
            .subscribeOn(Schedulers.io())
            .flatMapSingle {
                newsRepository.requestNews()
            }
            .doOnNext(cachedNewsRepository::restoreNews)
            .doOnNext { Log.d("NewsListUseCase", "actualNewsObservable $it") }
            .onErrorResumeNext(
                cachedNewsRepository.getNewsObservable()
            )
}

data class NewsDomainModel(
    val author: String,
    val title: String,
    val description: String,
    val urlPath: String,
    val urlImage: String,
    val content: String,
)