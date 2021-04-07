package com.galaziukvadym.newspetproject.presentation.adapter

import android.net.Uri
import android.view.View
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.news_view_holder_layout.view.*

abstract class BaseRecordViewHolder<T : RecordUiModel>(itemView: View) :
    RecyclerView.ViewHolder(itemView) {

    abstract fun bind(recordUiModel: T)
}

class NewsViewHolder(itemView: View) : BaseRecordViewHolder<NewsUiModel>(itemView) {

    override fun bind(recordUiModel: NewsUiModel) {
        with(itemView) {
            tvTitle.text = recordUiModel.title
            tvAuthor.text = recordUiModel.author
            tvDescription.text = recordUiModel.content

            Glide.with(this).load(recordUiModel.urlImage).into(ivPicture)

            cvNewsContainer.setOnClickListener {
                CustomTabsIntent.Builder().build()
                    .launchUrl(this.context, Uri.parse(recordUiModel.urlPath))
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

