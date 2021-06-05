package com.galaziukvadym.newspetproject.presentation

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.galaziukvadym.newspetproject.NewsListUseCase
import com.galaziukvadym.newspetproject.presentation.adapter.*
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


sealed class State
data class ShowContent(val uiModels: List<NewsUiModel>) : State()
data class OpenScreen(val url: String) : State()

class NewsViewModel @Inject constructor(
    private val newsListUseCase: NewsListUseCase,
    private val context: Context
) :
    ViewModel() {

    private val mutableLiveData: MutableLiveData<State> = MutableLiveData()
    private var newsDisposable: Disposable? = null

    init {
        loadData()
    }

    private fun loadData() {
        newsDisposable = newsListUseCase.subscribeOnNews()
            .subscribeOn(Schedulers.io())
            .map { ShowContent(NewsUiModelMapper.map(it)) }
            .subscribe(mutableLiveData::postValue)
    }

    fun handleNewsAction(newsAction: NewsAction) {
        when (newsAction) {
            is OnItemClicked -> {
                mutableLiveData.postValue(OpenScreen(newsAction.url))
            }
            is OnImageClicked -> {
                mutableLiveData.postValue(OpenScreen(newsAction.imageUrl))
            }
            is OnTitleClicked -> {
                Toast.makeText(context, "You cliked on ${newsAction.author}", Toast.LENGTH_SHORT)
                    .show()
            }
            OnLongItemClick -> {
                Toast.makeText(context, "You cliked on long dick", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun refreshNews() = newsListUseCase.requestActualNews()


    fun getLiveData(): LiveData<State> =
        mutableLiveData


    override fun onCleared() {
        newsDisposable?.dispose()

        super.onCleared()
    }

}