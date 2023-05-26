package com.capgemini.be.controller;

import com.capgemini.be.client.LeaveRequestClient;
import com.capgemini.be.lms.model.LeaveRequest;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Produces
@Path("/leaves")
public class LeaveRequestController {

    @Inject
    @RestClient
    LeaveRequestClient leaveRequestClient;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void SendLeaveRequestToSync(LeaveRequest leaveRequest) {
        leaveRequestClient.sendDataToSync(leaveRequest);
    }
}
