package com.capgemini.be.controller;

import com.capgemini.be.lms.model.LeaveRequest;
import com.capgemini.be.mapper.TimesheetMapper;
import com.capgemini.be.service.SyncService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.logging.Logger;

@Produces(MediaType.APPLICATION_JSON)
@Path("/sync")
public class SyncController {

    public static Logger LOGGER = Logger.getLogger(SyncController.class.getName());

    @Inject
    SyncService syncService;

    @Inject
    TimesheetMapper timesheetMapper;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void syncLeaveRequest(LeaveRequest leaveRequest) {
        LOGGER.info("Received leave request: " + leaveRequest);
        sendToClarity(leaveRequest);
    }

    public void sendToClarity(LeaveRequest leaveRequest) {
        LOGGER.info("Sending timesheet to Clarity.");
        syncService.sendToClarity(timesheetMapper);
        timesheetMapper.map(leaveRequest);
        syncService.logRequest(leaveRequest);
    }
}
