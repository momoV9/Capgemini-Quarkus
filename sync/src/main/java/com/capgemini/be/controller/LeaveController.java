package com.capgemini.be.controller;

import com.capgemini.be.lms.model.LeaveRequest;
import com.capgemini.be.service.SyncService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/leaves")
@Produces(MediaType.APPLICATION_JSON)
public class LeaveController {

    @Inject
    SyncService syncService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createLeaveRequest(LeaveRequest leaveRequest) {
        LeaveRequest createdRequest = syncService.createLeaveRequest(leaveRequest);
        return Response.status(Response.Status.CREATED).entity(createdRequest).build();
    }
}
