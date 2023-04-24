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
import java.net.URI;

@Path("/leaves")
public class LeaveRequestController {

    @Inject
    LeaveRequestService leaveRequestService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createLeaveRequest(LeaveRequest leaveRequest) {
        try {
            LeaveRequest createdLeaveRequest = leaveRequestService.createLeaveRequest(leaveRequest);
            return Response.created(new URI("/test")).entity(createdLeaveRequest).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

}
