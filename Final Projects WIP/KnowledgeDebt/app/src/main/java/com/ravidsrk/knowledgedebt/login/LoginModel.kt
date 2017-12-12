package com.ravidsrk.knowledgedebt.login

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.text.TextUtils
import com.ravidsrk.knowledgedebt.BR

class LoginModel : BaseObservable() {

    @get:Bindable
    var email: String? = null
        set(email) {
            field = email
            notifyPropertyChanged(BR.email)
            isLoginEnabled = isEmailAndPasswordSet
        }
    @get:Bindable
    var password: String? = null
        set(password) {
            field = password
            notifyPropertyChanged(BR.password)
            isLoginEnabled = isEmailAndPasswordSet
        }
    @get:Bindable
    var isLoginEnabled: Boolean = false
        private set(loginEnabled) {
            field = loginEnabled
            notifyPropertyChanged(BR.isLoginEnabled)
        }

    private val isEmailAndPasswordSet: Boolean
        get() = !TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)
}
