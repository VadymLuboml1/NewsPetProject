package com.galaziukvadym.newspetproject.di

import com.galaziukvadym.newspetproject.presentation.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RestModule::class, AppModule::class])
interface GeneralComponent {

    fun inject(mainActivity: MainActivity)
}