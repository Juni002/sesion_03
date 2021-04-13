package com.example.sesion_3.api;

import com.example.sesion_3.entity.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServiceApi {
   //  https://jsonplaceholder.typicode.com/users
    @GET("users")
    public abstract Call<List<User>> listaUsuario();

}
