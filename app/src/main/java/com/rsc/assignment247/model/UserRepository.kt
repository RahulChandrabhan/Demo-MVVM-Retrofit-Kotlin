package com.rsc.assignment247.model

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.rsc.assignment247.service.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository(private val application: Application? = null) {

    private var userResultMutableLiveData: MutableLiveData<List<UserResult>> = MutableLiveData()

    fun getUserDetails(): MutableLiveData<List<UserResult>> {

        val userDetailsCall: Call<UserResponse> =
            RetrofitInstance.getService()!!.getUserDetails()

        userDetailsCall.enqueue(object : Callback<UserResponse> {
            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.localizedMessage}")
            }

            override fun onResponse(
                call: Call<UserResponse>,
                response: Response<UserResponse>
            ) {
                if (response.body() != null && response.body()!!.data != null && response.body()!!.data?.isNotEmpty()!!) {
                    val userResult = arrayListOf<UserResult>()
                    for (items in response.body()!!.data!!) {
                        val name: String? = items?.name
                        val email: String? = items?.email
                        val gender: String? = items?.gender
                        val status: String? = items?.status
                        userResult.add(
                            UserResult(
                                name.toString(), email.toString(),
                                gender.toString(), status.toString()
                            )
                        )
                    }
                    userResultMutableLiveData.value = userResult
                } else {
                    Log.e(TAG, "onResponse: $response")
                }
            }

        })
        return userResultMutableLiveData

    }

    companion object {
        private const val TAG = "UserRepository"
    }


}