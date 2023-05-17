package com.capgemini.be.controller;

import com.capgemini.be.clarity.model.TimeSheet;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.logging.Logger;

@Path("/clarity")
@Produces(MediaType.APPLICATION_JSON)
public class TimesheetController {

    private static final Logger LOGGER = Logger.getLogger(TimesheetController.class.getName());

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public TimeSheet createTimesheet(TimeSheet timesheet) {
        LOGGER.info("Creating timesheet for user: " + timesheet.getUser());
        List<TimeSheet.TimesheetEntry> entries = timesheet.getEntries();
        for (int i = 0; i < entries.size(); i++) {
            TimeSheet.TimesheetEntry entry = entries.get(i);
            LOGGER.info("Entry " + (i + 1) + ":");
            LOGGER.info("Date: " + entry.getDate());
            LOGGER.info("Hours: " + entry.getHours());
            LOGGER.info("Investment ID: " + entry.getInvestmentId());
        }
        return timesheet;
    }

}
