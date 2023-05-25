package com.capgemini.be.client;

import com.capgemini.be.lms.model.LeaveRequest;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;


import javax.ws.rs.POST;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RegisterRestClient(configKey = "leave")
public interface LeaveRequestClient {
    @POST
    @Path("/sync")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Response sendDataToSync(LeaveRequest leaveRequest);
}
