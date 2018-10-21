package com.sqsong.wanandroid.ui.home.mvp

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.sqsong.wanandroid.mvp.IView

interface MainContract {

    interface View : IView {
        fun getFab(): FloatingActionButton
        fun getCurrentIndex(): Int
        fun setupDrawerAndToolbar()
        fun supportFragmentManager(): FragmentManager
        fun setPagerAdapter(adapter: FragmentStatePagerAdapter)
        fun startLoginActivity()
    }

}