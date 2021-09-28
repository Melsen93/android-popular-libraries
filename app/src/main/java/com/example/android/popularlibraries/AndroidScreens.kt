package com.example.android.popularlibraries

import com.example.android.popularlibraries.model.GithubUser
import com.example.android.popularlibraries.presenter.IScreens

class AndroidScreens : IScreens {
    override fun users() = UsersScreen()

    override fun user(user: GithubUser) = UserScreen(user)
}