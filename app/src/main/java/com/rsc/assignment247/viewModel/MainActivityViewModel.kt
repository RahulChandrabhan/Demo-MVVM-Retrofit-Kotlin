package com.rsc.assignment247.viewModel

import android.app.Application
import android.app.ProgressDialog
import android.content.Context
import androidx.lifecycle.*
import com.rsc.assignment247.model.UserRepository
import com.rsc.assignment247.model.UserResult


class MainActivityViewModel(application: Application) : AndroidViewModel(application),
    LifecycleObserver {

    private var userRepository: UserRepository = UserRepository(application)
    private lateinit var progressDialog: ProgressDialog

    fun getUserResult(): LiveData<List<UserResult>> {
        return userRepository.getUserDetails()
    }

    fun showProgressDialog(context: Context) {
        progressDialog = ProgressDialog(context)
        progressDialog.setMessage("Please Wait")
        progressDialog.show()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun dismissProgressDialog() {
        if (progressDialog.isShowing)
            progressDialog.dismiss()
    }

}