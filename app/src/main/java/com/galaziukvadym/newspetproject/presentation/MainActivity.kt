package com.galaziukvadym.newspetproject.presentation

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.LinearLayoutManager
import com.galaziukvadym.newspetproject.R
import com.galaziukvadym.newspetproject.app.AndroidApplication
import com.galaziukvadym.newspetproject.presentation.adapter.NewsUiModelAdapter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var newsViewModel: NewsViewModel

    lateinit var adapter: NewsUiModelAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as AndroidApplication).getAppComponent().inject(this)

        adapter = NewsUiModelAdapter(newsViewModel::handleNewsAction)
        rvNews.adapter = adapter
        rvNews.layoutManager = LinearLayoutManager(this)

        newsViewModel.getLiveData().observe(this, ::handleState)
    }

    private fun handleState(state: State) {
        when (state) {
            is ShowContent -> adapter.submitList(state.uiModels)
            is OpenScreen -> {
                CustomTabsIntent.Builder().build()
                    .launchUrl(this, Uri.parse(state.url))
            }
        }
    }
}