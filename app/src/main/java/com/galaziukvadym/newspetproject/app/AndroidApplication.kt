package com.galaziukvadym.newspetproject.app

import android.app.Application
import com.galaziukvadym.newspetproject.di.AppModule
import com.galaziukvadym.newspetproject.di.DaggerGeneralComponent
import com.galaziukvadym.newspetproject.di.GeneralComponent

class AndroidApplication : Application() {

    private lateinit var applicationComponent: GeneralComponent

    fun getAppComponent() = applicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerGeneralComponent.builder()
            .appModule(AppModule(this)).build()
    }
}