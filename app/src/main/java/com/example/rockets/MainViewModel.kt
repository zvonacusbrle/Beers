package com.example.rockets

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.apollographql.apollo3.ApolloClient
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepo: MainRepo,
    private val apolloClient: ApolloClient
) : ViewModel() {
    fun getRockets() = liveData(Dispatchers.IO) {
        emit(Resource.Loading(null))
        try {
            val apiResponse = mainRepo.getRockets()
            Log.d(ContentValues.TAG, "apiResponse - Called $apiResponse")

            if (!apiResponse.hasErrors()) {
                Log.d(ContentValues.TAG, "apiResponse - !hasErrors ")

                emit(Resource.Success(apiResponse.data?.rockets))
            } else {
                Log.d(ContentValues.TAG, "apiResponse - ${apiResponse.errors} ")
                emit(Resource.Error(null, apiResponse.errors.toString()))
            }
        } catch (exception: Exception) {
            Log.d(ContentValues.TAG, "apiResponse exception - $exception} ")

            emit(exception.localizedMessage?.let { Resource.Error(null, it) })
        }
    }
}