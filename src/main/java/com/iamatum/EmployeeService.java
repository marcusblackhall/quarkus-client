package com.iamatum;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@RegisterRestClient(configKey = "employee-api")
@Path("/employees")
public interface EmployeeService {

    @GET
    List<Employee> getEmployees();


}
