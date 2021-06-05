package com.galaziukvadym.newspetproject.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.news_view_holder_layout.view.*

abstract class BaseRecordViewHolder<T : RecordUiModel>(itemView: View) :
    RecyclerView.ViewHolder(itemView) {

    abstract fun bind(recordUiModel: T)
}

class NewsViewHolder(itemView: View, private val newsCallback: NewsCallback) :
    BaseRecordViewHolder<NewsUiModel>(itemView) {

    override fun bind(recordUiModel: NewsUiModel) {
        with(itemView) {
            tvTitle.text = recordUiModel.title
            tvAuthor.text = recordUiModel.author
            tvDescription.text = recordUiModel.content

            Glide.with(this).load(recordUiModel.urlImage).into(ivPicture)

            tvTitle.setOnClickListener {
                newsCallback(OnTitleClicked(recordUiModel.author))
            }

            ivPicture.setOnClickListener {
                newsCallback(OnImageClicked(recordUiModel.urlImage))
            }

            cvNewsContainer.setOnClickListener {
                newsCallback(OnItemClicked(recordUiModel.urlPath))
            }

            cvNewsContainer.setOnLongClickListener {
                newsCallback(OnLongItemClick)
                true
            }
        }
    }
}

class AdditionalInfoViewHolder(itemView: View) :
    BaseRecordViewHolder<AdditionalInfoUiModel>(itemView) {


    override fun bind(recordUiModel: AdditionalInfoUiModel) {
        TODO("Not yet implemented")
    }
}

