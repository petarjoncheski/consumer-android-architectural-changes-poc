package com.example.myapplication.mangers

import io.reactivex.Observable


class UserManager {
    val id: Observable<String>
        get() = Observable.just("1")
}