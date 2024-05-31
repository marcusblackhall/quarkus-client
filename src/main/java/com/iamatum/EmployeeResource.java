package com.iamatum;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/service")
public class EmployeeResource {

    @RestClient
    EmployeeService employeeService;
//    private AtomicLong counter = new AtomicLong(0);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Retry(maxRetries = 4, delay = 1000)
    public Response service() {
//        final Long invocationNumber = counter.getAndIncrement();
//        maybeFail(String.format("EmployeeResource#employees() invocation #%d failed", invocationNumber));
//        logger.infof("EmployeeResource#employees() invocation #%d returning successfully", invocationNumber);
        return Response.ok().entity(employeeService.getEmployees()).build();


    }
//
//    private void maybeFail(String failureLogMessage) {
//        if (counter.get() < 4) {
//            logger.error(failureLogMessage);
//            throw new RuntimeException("Resource failure.");
//        }
//    }

}
