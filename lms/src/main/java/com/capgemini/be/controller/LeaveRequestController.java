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

@Path("/lms")
@Produces(MediaType.APPLICATION_JSON)
public class LeaveRequestController {

    @Inject
    SyncService syncService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createLeaveRequest(LeaveRequest leaveRequest) {
        try {
            syncService.syncLeaveRequest(leaveRequest);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}
