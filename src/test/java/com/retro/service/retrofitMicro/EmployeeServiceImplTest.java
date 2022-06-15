package com.retro.service.retrofitMicro;

import com.retro.service.retrofitMicro.dto.Employee;
import com.retro.service.retrofitMicro.newretro.RepositoryInterface;
import com.retro.service.retrofitMicro.service.EmployeeServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceImplTest {
    @InjectMocks
    EmployeeServiceImpl employeeService;
    @Mock
    RepositoryInterface repositoryInterface;

    @Test
    public void getByIdTest() throws IOException {
        Employee employee = new Employee();
int id=1;
        employee.setId(1);
        employee.setName("jayu");
        employee.setAge(24);
        Response<Employee>  expectedResponse = Response.success(employee);
        Call<Employee> call=mock(Call.class);
        when(repositoryInterface.getUser(id)).thenReturn(call);
        when(call.execute()).thenReturn(expectedResponse);
        RepositoryInterface repositoryInterface = mock(RepositoryInterface.class);
employeeService.getUser(id);
    }

    @Test
    public void insertEmployeeTest() throws IOException{

        Employee employee=new Employee(1,"ram",15);
        Response<Employee> expectedResponse2=Response.success(employee);
        Call<Employee> call2=mock(Call.class);
        when(repositoryInterface.insertEmployee(employee)).thenReturn(call2);
        when(call2.execute()).thenReturn(expectedResponse2);
        employeeService.insertEmployee(employee);
    }
    @Test
    public void getAllTest() throws IOException{
        List<Employee> list= new ArrayList<>();
        list.add(new Employee(1,"jayu",24));
        list.add(new Employee(2,"dhanu",20));
        Response<List<Employee>> expectedresponse = Response.success(list);
        Call<List<Employee>> call1=mock(Call.class);
        when(repositoryInterface.getAll()).thenReturn(call1);
        when(call1.execute()).thenReturn(expectedresponse);
        employeeService.getAllEmployee();
    }
@Test
    public void deleteById() throws IOException{
    Response<String> expectedResponse2=Response.success("User deleted successfully");
    Call<String> call=mock(Call.class);
    when(repositoryInterface.deleteById(ArgumentMatchers.anyInt())).thenReturn(call);
    when(call.execute()).thenReturn(expectedResponse2);
    RepositoryInterface repositoryInterface=mock(RepositoryInterface.class);
    employeeService.deleteById(Mockito.anyInt());
}

}