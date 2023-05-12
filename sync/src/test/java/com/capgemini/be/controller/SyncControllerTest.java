package com.capgemini.be.controller;

import com.capgemini.be.clarity.model.TimeSheet;
import com.capgemini.be.lms.model.LeaveRequest;
import com.capgemini.be.mapper.TimesheetMapper;
import com.capgemini.be.service.SyncService;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.MediaType;
import java.time.LocalDate;

import static io.restassured.RestAssured.given;
import static org.mockito.Mockito.when;


public class SyncControllerTest {

    @InjectMock
    @RestClient
    SyncService syncService;

    @InjectMock
    @RestClient
    TimesheetMapper timesheetMapper;

    @Test
    void testSyncLeaveRequest() {
        LeaveRequest leaveRequest = new LeaveRequest();
        leaveRequest.setLocalEmployeeId(12345);
        leaveRequest.setStartDate(LocalDate.now());
        leaveRequest.setStartHours(8);

        when(timesheetMapper.map(leaveRequest)).thenReturn(new TimeSheet());

        given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(leaveRequest)
                .when()
                .post("/sync")
                .then()
                .statusCode(200);
    }
}
