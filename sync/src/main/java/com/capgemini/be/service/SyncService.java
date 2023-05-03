package com.capgemini.be.service;

import com.capgemini.be.lms.model.LeaveRequest;

import javax.enterprise.context.ApplicationScoped;
import java.util.logging.Logger;

@ApplicationScoped
public class SyncService {

    private static final Logger LOGGER = Logger.getLogger(SyncService.class.getName());

    public void syncLeaveRequest(LeaveRequest leaveRequest) {
        // create the leave request in the local database
        // ...

        // send the leave request to the other system
        // ...

        LOGGER.info("Leave request synced successfully: " + leaveRequest.toString());
    }
}