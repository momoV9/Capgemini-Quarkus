package com.capgemini.be.service;

import com.capgemini.be.MyLogger;
import com.capgemini.be.lms.model.LeaveRequest;
import com.capgemini.be.proxy.SyncProxy;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;

@ApplicationScoped
public class SyncService {

    private static final Logger LOGGER = Logger.getLogger(SyncService.class.getName());

    @Inject
    @RestClient
    SyncProxy syncProxy;

    public SyncService() {
        MyLogger.setup();
    }

    public LeaveRequest createLeaveRequest(LeaveRequest leaveRequest) {
        // create the leave request in the local database
        // ...

        // send the leave request to the sync application
        try {
            Response response = syncProxy.syncLeaveRequest(leaveRequest);
            if (response.getStatus() != Response.Status.OK.getStatusCode()) {
                throw new WebApplicationException("Failed to sync leave request. Response code: " + response.getStatus());
            }
            LOGGER.info("Leave request synced successfully: " + leaveRequest.toString());
        } catch (Exception e) {
            LOGGER.severe("Failed to sync leave request: " + e.getMessage());
            throw new WebApplicationException("Failed to sync leave request. Reason: " + e.getMessage());
        }

        return leaveRequest;
    }
}
