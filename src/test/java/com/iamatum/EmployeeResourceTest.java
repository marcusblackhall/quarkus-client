package com.iamatum;

import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.response.Response;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@QuarkusTest
class EmployeeResourceTest {

    @Inject
    EmployeeResource employeeResource;

    @InjectMock
    @RestClient
    EmployeeService employeeService;

    @Test
    void testHelloEndpoint() {
        Employee emp = new Employee();
        emp.setFirstName("test");
        emp.setLastName("user");
        var employees = List.of(emp);
        when(employeeService.getEmployees()).thenReturn(employees);

        Response response =
                given()
                        .when().get("/service")
                        .prettyPeek();

        assertEquals(200, response.statusCode());
        assertAll(() -> assertEquals("test", response.path("[0].first_name")),
                () -> assertEquals("user", response.path("[0].last_name"))
        );

    }

}