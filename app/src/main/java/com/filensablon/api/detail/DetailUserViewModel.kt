package com.filensablon.api.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.filensablon.api.data.NewsUser
import com.filensablon.api.data.UserDummy
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailUserViewModel : ViewModel(){
    val user = MutableLiveData<NewsUser>()

    fun setUserDetail(username: String){
        UserDummy.apiInstance
            .getUserDetail(username)
            .enqueue(object : Callback<NewsUser> {
                override fun onFailure(call: Call<NewsUser>, t: Throwable) {
                    t.message?.let { Log.d("Failure", it) }
                }

                override fun onResponse(
                    call: Call<NewsUser>,
                    response: Response<NewsUser>
                ) {
                    if(response.isSuccessful){
                        user.postValue(response.body())
                    }
                }

            })
    }

    fun getUserDetail() : LiveData<NewsUser> {
        return user
    }
}