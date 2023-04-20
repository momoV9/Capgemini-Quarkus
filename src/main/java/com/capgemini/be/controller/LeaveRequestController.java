package com.capgemini.be.controller;


import com.capgemini.be.LMS.model.LeaveRequest;
import com.capgemini.be.service.LeaveRequestService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/leave-requests")
public class LeaveRequestController {

    @Inject
    LeaveRequestService leaveRequestService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createLeaveRequest(LeaveRequest leaveRequest) {
        LeaveRequest createdLeaveRequest = leaveRequestService.createLeaveRequest(leaveRequest);
        return Response.ok().entity(createdLeaveRequest).build();
    }
}
