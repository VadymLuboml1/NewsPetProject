package com.galaziukvadym.newspetproject.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.galaziukvadym.newspetproject.R
import com.galaziukvadym.newspetproject.app.AndroidApplication
import com.galaziukvadym.newspetproject.presentation.adapter.NewsUiModelAdapter
import io.reactivex.subjects.BehaviorSubject
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
    }

    override fun onStart() {
        super.onStart()

        BehaviorSubject.create<String>().replay().autoConnect()

        adapter = NewsUiModelAdapter()
        rvNews.adapter = adapter
        rvNews.layoutManager = LinearLayoutManager(this)

        newsViewModel.getLiveData().observe(this, adapter::submitList)
    }
}