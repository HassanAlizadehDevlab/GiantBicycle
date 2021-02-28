package com.android.shared.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Base class for all ViewModels.
 */
open class BaseViewModel : ViewModel() {

    protected val _messageObservable = MutableLiveData<String>()
    val messageObservable: LiveData<String>
        get() = _messageObservable

}