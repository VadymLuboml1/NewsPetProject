package com.galaziukvadym.newspetproject.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.galaziukvadym.newspetproject.R
import com.galaziukvadym.newspetsproject.presentation.adapter.NewsViewHolder

class NewsUiModelAdapter : ListAdapter<RecordUiModel, RecyclerView.ViewHolder>(diffUtil) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(newsLayout, parent, false)
        return NewsViewHolder(view)
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val newsItem = getItem(position) as NewsUiModel

        return (holder as NewsViewHolder).bind(newsItem)
    }

    companion object {
        const val newsLayout = R.layout.news_view_holder_layout
    }
}

val diffUtil = object : DiffUtil.ItemCallback<RecordUiModel>() {

    override fun areItemsTheSame(oldItem: RecordUiModel, newItem: RecordUiModel) =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: RecordUiModel, newItem: RecordUiModel) =
        oldItem == newItem

}
