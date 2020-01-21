package com.structure.repository


import com.structure.network.BaseDataSource
import com.structure.network.NetworkAPI

class AuthRepository constructor(var networkAPI: NetworkAPI)  : BaseDataSource() {

//    suspend fun getAllUsers1(id : Int) = networkAPI.getAllUsers(id)


    suspend fun getAllUsers(id : Int) = getResult { networkAPI.getAllUsers(id) }
}