package com.structure.network

import com.structure.model.UserModel
import retrofit2.Response
import retrofit2.http.*

interface NetworkAPI {

//    @GET("users/{id}")
//    suspend fun getAllUsers(@Path(value = "id") userId: Int) : UserModel

    @GET("users/{id}")
    suspend fun getAllUsers(@Path(value = "id") userId: Int) : Response<UserModel>

// dummy apis

//    @FormUrlEncoded
//    @PUT("user-info/")
//    abstract fun updateUser(@Header("Authorization") token : String, @Field("first_name") firstName: String, @Field("last_name") lastName: String): Flowable<ResponseModel>
//
//    @GET("members/{member_type}")
//    abstract fun getMembersOrClients(@Header("Authorization") token : String, @Query("member_type") type : String): Flowable<MemberInfoResponseModel>
//
//    @GET("members/")
//    abstract fun getAllMembers(@Header("Authorization") token : String): Call<MemberInfoResponseModel>
//
//    @GET("members/{member_type}/{page}/{page_size}")
//    abstract fun getMembersOrClientsWithPagination(@Header("Authorization") token : String, @Query("member_type") type : String, @Query("page") page : Int, @Query("page_size") numberOfRecords : Int): Flowable<MemberInfoResponseModel>

}