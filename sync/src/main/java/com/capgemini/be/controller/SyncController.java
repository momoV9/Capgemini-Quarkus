package com.capgemini.be.controller;

import com.capgemini.be.clarity.model.TimeSheet;
import com.capgemini.be.client.SyncClient;
import com.capgemini.be.lms.model.LeaveRequest;
import com.capgemini.be.mapper.TimesheetMapper;
import org.eclipse.microprofile.rest.client.inject.RestClient;

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
    TimesheetMapper timesheetMapper;

    @Inject
    @RestClient
    SyncClient syncClient;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void sendLeaveRequestToClarity(LeaveRequest leaveRequest) {
        LOGGER.info("Received leave request: " + leaveRequest);
        TimeSheet timeSheet = timesheetMapper.transformToTimesheet(leaveRequest);
        syncClient.sendTimesheetToClarity(timeSheet);
    }
}