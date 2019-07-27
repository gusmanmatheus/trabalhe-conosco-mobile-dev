package com.example.picpaytest.base

interface BaseView<out T: BasePresenter<*>> {
    val presenter: T
}