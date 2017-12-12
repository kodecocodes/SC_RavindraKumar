package com.ravidsrk.knowledgedebt.utils

import android.app.Activity
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.ViewGroup
import kotlin.reflect.KProperty

/**
 * Created by ravindra on 12/12/17.
 */

/**
 * This is a replacement for DataBindingUtil.setContentView(activity, layoutRes)
 *
 * use val binding: ActivityMainBinding by BindActivity(R.layout.activity_main) instead
 * Inpiration Lisa Wray
 */
class BindActivity<in R: Activity, out T: ViewDataBinding>(
        @LayoutRes private val layoutRes: Int) {

    private var value: T? = null

    operator fun getValue(thisRef: R, property: KProperty<*>): T {
        if (value == null) {
            value = DataBindingUtil.setContentView<T>(thisRef, layoutRes)
        }
        return value!!
    }
}

/**
 * This is a replacement for DataBindingUtil.inflate(inflater, layoutRes,
 * rootView, boolean)
 *
 * use private val binding: FragmentMainBinding by BindFragment(R.layout.fragment_main) instead
 */
class BindFragment<in R: Fragment, out T: ViewDataBinding>(
        @LayoutRes private val layoutRes: Int) {

    private var value: T? = null

    operator fun getValue(thisRef: R, property: KProperty<*>): T {
        if (value == null) {
            value = DataBindingUtil.inflate<T>(thisRef.layoutInflater, layoutRes,
                    thisRef.view?.rootView as ViewGroup?, false)
        }
        return value!!
    }
}