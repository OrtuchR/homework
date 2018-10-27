package com.gmail.ortuchr.homework.presentation.screen.homework.hw10

import android.databinding.BindingAdapter
import android.databinding.ObservableField
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.gmail.ortuchr.homework.presentation.base.BaseViewModel

class PersonInfoViewModel : BaseViewModel<PersonInfoRouter>() {
    private val defaultString = "no data"
    val personURL = ObservableField<String>("http://www.pravoslavie.ru/sas/image/102180/218007.p.jpg?mtime=1445430713")
    val personFIO = ObservableField<String>(defaultString)
    val personAge = ObservableField<String>(defaultString)
    val personSex = ObservableField<String>(defaultString)

    init {
        personFIO.set("Пушкин Александр Сергеевич")
        personAge.set("Age: 28")
        personSex.set("Sex: M")
    }
}