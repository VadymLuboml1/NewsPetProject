package com.galaziukvadym.newspetproject.domain.data

import com.galaziukvadym.newspetproject.NewsDomainModel
import io.reactivex.Single

interface NewsRepository {

    fun requestNews(): Single<List<NewsDomainModel>>
}