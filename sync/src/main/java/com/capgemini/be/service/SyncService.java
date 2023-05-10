package com.capgemini.be.service;

import com.capgemini.be.lms.model.LeaveRequest;
import com.capgemini.be.mapper.TimesheetMapper;

import javax.inject.Singleton;
import java.util.logging.Logger;

@Singleton
public class SyncService {

    private static final Logger LOGGER = Logger.getLogger(SyncService.class.getName());

    public void logRequest(LeaveRequest leaveRequest) {
        LOGGER.info("Leave request synced successfully: " + leaveRequest);
    }

    public void sendToClarity(TimesheetMapper timesheetMapper) {
        LOGGER.info("Sending timesheet to Clarity: " + timesheetMapper);
    }
}