package com.retro.service.retrofitMicro.newretro;


import com.retro.service.retrofitMicro.dto.Employee;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface RepositoryInterface {
    @POST("insertUser")
    public  Call<Employee> insertEmployee(@Body Employee user);

    @GET("getById/{id}")
    public Call<Employee> getUser(@Path("id") long id);
@GET("getAll")
    public Call<List<Employee>> getAll();
@DELETE("deleteById/{id}")
    public Call<String> deleteById(@Path("id") int id);

}