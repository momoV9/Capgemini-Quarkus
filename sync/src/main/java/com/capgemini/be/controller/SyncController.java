package com.capgemini.be.controller;

import com.capgemini.be.lms.model.LeaveRequest;

import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Produces
@Path("/sync")
public class SyncController {

    private static final Logger LOGGER = Logger.getLogger(SyncController.class.getName());

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void logRequest(LeaveRequest leaveRequest) {
        LOGGER.info("Leave request synced successively: " + leaveRequest);
    }
}
