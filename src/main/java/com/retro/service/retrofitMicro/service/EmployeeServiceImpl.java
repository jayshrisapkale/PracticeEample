package com.retro.service.retrofitMicro.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.retro.service.retrofitMicro.dto.Employee;

import com.retro.service.retrofitMicro.newretro.RepositoryInterface;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.io.IOException;
import java.util.List;
@Service
public class EmployeeServiceImpl {
    private RepositoryInterface service;

    public EmployeeServiceImpl() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()  //just we created the client
                .baseUrl("http://localhost:8082/")
                .addConverterFactory(ScalarsConverterFactory.create())  //to conver of our return type
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        service = retrofit.create(RepositoryInterface.class);  // ask retrofit to create implementation of that interface for us

    }


    public Employee getUser(int id) throws IOException {
        // prepare to make a call
        Call<Employee> retrofitCall = service.getUser(id);
        Response<Employee> response = retrofitCall.execute(); // execute that call
        if (!response.isSuccessful()) {  // if http code is 200 then
            throw new IOException();
        }
        return response.body(); // and make extracted that response
    }


    public Employee insertEmployee(Employee user) throws IOException {
        Call<Employee> retrofitCall = service.insertEmployee(user);
        Response<Employee> response = retrofitCall.execute();
        if (!response.isSuccessful()) {
            throw new IOException(response.errorBody() != null
                    ? response.errorBody().string() : "Unknown error");
        }
        return response.body();
    }
public List<Employee> getAllEmployee()throws IOException {

    Call<List<Employee>> retrofitCall = service.getAll();
    Response<List<Employee>> response = retrofitCall.execute();
    if (!response.isSuccessful()) {
        throw new IOException();
    }
    return response.body();
}
    public String deleteById(int id)throws IOException {

        Call<String> retrofitCall = service.deleteById(id);
        Response<String> response = retrofitCall.execute();
        if (!response.isSuccessful()) {
            throw new IOException();
        }
        return response.body();
    }
}