package com.capgemini.be.controller;

import com.capgemini.be.sync.model.TimeSheet;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/clarity")
@Produces(MediaType.APPLICATION_JSON)
public class TimesheetController {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public TimeSheet createTimesheet(TimeSheet timesheet) {
        // Save the timesheet to the database
        // ...

        // Map the data from the received timesheet to the Clarity format
        // and send it to the Clarity API

        return timesheet; // Return the created timesheet as confirmation
    }
}
