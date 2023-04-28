package com.capgemini.be.proxy;

import com.capgemini.be.lms.model.LeaveRequest;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/sync")
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient(baseUri = "http://localhost:8080/leaves")

public interface SyncProxy {

    @POST
    @Path("/leaves")
    @Consumes(MediaType.APPLICATION_JSON)
    Response syncLeaveRequest(LeaveRequest leaveRequest);

}
