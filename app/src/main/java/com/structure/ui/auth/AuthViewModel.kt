package com.structure.ui.auth

import androidx.lifecycle.*
import com.structure.model.UserModel
import com.structure.repository.AuthRepository
import com.structure.network.Result
import com.structure.network.resultLiveData

class AuthViewModel constructor(var authRepository: AuthRepository) : ViewModel() {

// thats manual approach
//    val loginResponse: LiveData<Response<UserLoginModel>> = MutableLiveData<Response<UserLoginModel>>()
//
//    fun login(model: UserLoginModel) = viewModelScope.launch(IO) {
////        try {
////            (loginResponse as MutableLiveData).postValue(authRepository.getAllUsers())
////        } catch (e: Exception) {
////            Log.e("exception", "${e.message}")
////        }
//    }


//   val allUsers = liveData(Dispatchers.IO) {
//       try {
//           val retrivedData = authRepository.getAllUsers(1)
//           emit(retrivedData)
//       } catch (ex: Exception){
//           when(ex) {
//               is HttpException -> Log.d("error","${ex.code()}: ${ex.message()}")
//           }
//       }
//    }

//    old style
//    fun getSpecificUser(id: Int, progressBar: ProgressBar): LiveData<UserModel> {
//        progressBar.visibility = VISIBLE
//        return liveData(Dispatchers.IO) {
//            try {
//                progressBar.visibility = GONE
//                val retrivedData = authRepository.getAllUsers(id)
//                emit(retrivedData)
//            } catch (ex: Exception) {
//                progressBar.visibility = GONE
//                when (ex) {
//                    is HttpException ->
//                        Log.d("error", "${ex.code()}: ${ex.message()}")
//                }
//            }
//        }
//    }


    fun getSpecificUser1(id: Int): LiveData<Result<UserModel>> {
        return  resultLiveData { authRepository.getAllUsers(id)  }
    }

}