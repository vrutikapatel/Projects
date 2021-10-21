package com.example.retrofitpostdataresponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIInterface {

    @POST("/HDWallpaper/index.php/api/getcategory")
    Call<GetCategoryData> doCreateUserWithField();

    /*@POST("/api/users")
    Call<User> createUser(@Body User user);*/

    @FormUrlEncoded
    @POST("/api/users?")
    Call<UserList> doCreateUserWithField(@Field("page") Integer page, @Field("total") Integer total,@Field("total_pages") Integer total_pages);

}
