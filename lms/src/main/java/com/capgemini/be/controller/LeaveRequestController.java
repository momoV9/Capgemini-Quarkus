package com.capgemini.be.controller;

import com.capgemini.be.lms.model.LeaveRequest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Produces
@Path("/leaves")
public class LeaveRequestController {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void sendToSync(LeaveRequest leaveRequest) {
    }
}