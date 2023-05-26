package com.capgemini.be.controller;

import com.capgemini.be.client.LeaveRequestClient;
import com.capgemini.be.lms.model.LeaveRequest;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
public class LeaveRequestControllerTest {

    private static class MockLeaveRequestClient implements LeaveRequestClient {
        private LeaveRequest capturedLeaveRequest;

        @Override
        public Response sendDataToSync(LeaveRequest leaveRequest) {
            capturedLeaveRequest = leaveRequest;
            return Response.ok().build();
        }

        public LeaveRequest getCapturedLeaveRequest() {
            return capturedLeaveRequest;
        }
    }

    @Test
    void sendLeaveRequestToSync() {
        // Arrange
        LeaveRequest leaveRequest = new LeaveRequest();

        MockLeaveRequestClient mockLeaveRequestClient = new MockLeaveRequestClient();
        LeaveRequestController leaveRequestController = new LeaveRequestController();
        leaveRequestController.leaveRequestClient = mockLeaveRequestClient;

        // Act
        leaveRequestController.sendLeaveRequestToSync(leaveRequest);

        // Assert
        LeaveRequest capturedRequest = mockLeaveRequestClient.getCapturedLeaveRequest();
        assertEquals(leaveRequest, capturedRequest);
    }
}
