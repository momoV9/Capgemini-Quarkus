package com.capgemini.clarity.controller;

import com.capgemini.clarity.model.TimeSheet;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Path("/clarity")
@Produces(MediaType.APPLICATION_JSON)
public class TimesheetController {

    private static final Logger LOGGER = Logger.getLogger(TimesheetController.class.getName());

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createTimesheet(TimeSheet timesheet) {
        LOGGER.info("Creating timesheet for user: " + timesheet.getUser());

        // Add test entries
        List<TimeSheet.TimesheetEntry> entries = new ArrayList<>();
        entries.add(createTimesheetEntry("2023-05-01","Sick", 8, "Investment 1"));
        entries.add(createTimesheetEntry("2023-05-02","Holiday", 6, "Investment 2"));

        timesheet.setEntries(entries);

        for (int i = 0; i < entries.size(); i++) {
            TimeSheet.TimesheetEntry entry = entries.get(i);
            LOGGER.info("Entry " + (i + 1) + ":");
            LOGGER.info("Date: " + entry.getDate());
            LOGGER.info("Hours: " + entry.getHours());
            LOGGER.info("Investment ID: " + entry.getInvestmentId());
            LOGGER.info("Investment: " + entry.getInvestment());
        }

        return Response.ok(timesheet).build();
    }

    private TimeSheet.TimesheetEntry createTimesheetEntry(String date,String investment, int hours, String investmentId) {
        TimeSheet.TimesheetEntry entry = new TimeSheet.TimesheetEntry();
        entry.setDate(LocalDate.parse(date));
        entry.setHours(hours);
        entry.setInvestmentId(investmentId);
        entry.setInvestment(investment);
        return entry;
    }
}
