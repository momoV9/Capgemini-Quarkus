package com.capgemini.sync.controller;

import com.capgemini.sync.client.SyncClient;
import com.capgemini.sync.mapper.TimesheetMapper;
import com.capgemini.sync.model.LeaveRequest;
import com.capgemini.sync.model.TimeSheet;
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

    public static final Logger logger = Logger.getLogger(SyncController.class.getName());

    @Inject
    TimesheetMapper timesheetMapper;

    @Inject
    @RestClient
    SyncClient syncClient;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void sendLeaveRequestToClarity(LeaveRequest leaveRequest) {
        logger.info("Received Leaverequest: " + leaveRequest );
        TimeSheet timeSheet = timesheetMapper.transformToTimesheet(leaveRequest);
        syncClient.sendTimesheetToClarity(timeSheet);
    }
}
