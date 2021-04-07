package com.galaziukvadym.newspetproject.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.galaziukvadym.newspetproject.NewsListUseCase
import com.galaziukvadym.newspetproject.presentation.adapter.NewsUiModel
import com.galaziukvadym.newspetproject.presentation.adapter.NewsUiModelMapper
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class NewsViewModel @Inject constructor(private val newsListUseCase: NewsListUseCase) :
    ViewModel() {

    private val mutableLiveData: MutableLiveData<List<NewsUiModel>> = MutableLiveData()
    private var newsDisposable: Disposable? = null

    init {
        loadData()
    }

    private fun loadData() {
        newsDisposable = newsListUseCase.subscribeOnNews()
            .subscribeOn(Schedulers.io())
            .map(NewsUiModelMapper::map)
            .subscribe(mutableLiveData::postValue)
    }

    fun refreshNews() = newsListUseCase.requestActualNews()

    fun getLiveData(): LiveData<List<NewsUiModel>> =
        mutableLiveData


    override fun onCleared() {
        newsDisposable?.dispose()

        super.onCleared()
    }

}