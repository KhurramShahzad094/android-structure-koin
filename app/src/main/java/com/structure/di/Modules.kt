package com.structure.di

import android.app.Application
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.structure.network.NetworkAPI
import com.structure.repository.AuthRepository
import com.structure.ui.auth.AuthViewModel
import com.structure.ui.auth.SharedViewModel
import com.structure.ui.auth.TestViewModel
import com.structure.util.Constants
import com.structure.util.PreferenceManager
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val appModule = module {

    single {
        Retrofit.Builder()
            .baseUrl(Constants.baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NetworkAPI::class.java)
    }

    single {
        EncryptedSharedPreferences
            .create(
                Constants.sharedPreferenceFileName,
                MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC),
                androidContext(),
                EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
            )
    }

    single {
        PreferenceManager(get())
    }

    single{
        AuthRepository(get())
    }
}


val viewModelModule = module {

    viewModel { AuthViewModel(get()) }
    viewModel { SharedViewModel() }
    viewModel { TestViewModel() }
}