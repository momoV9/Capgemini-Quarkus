package com.capgemini.be.service;

import com.capgemini.be.lms.model.LeaveRequest;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SyncService {

    private static final Logger logger = Logger.getLogger(SyncService.class.getName());

    public void syncLeaveRequest(LeaveRequest leaveRequest) {
        logger.log(Level.INFO, "Received leave request: {0}", leaveRequest);
    }

}
