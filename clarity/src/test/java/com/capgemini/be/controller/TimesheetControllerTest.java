package com.capgemini.be.controller;

import com.capgemini.clarity.model.TimeSheet;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.MediaType;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
class TimesheetControllerTest {

    @Test
    void createTimesheet() {
        // Arrange
        TimeSheet timesheet = new TimeSheet();

        timesheet.setUser(5);
        List<TimeSheet.TimesheetEntry> entries = new ArrayList<>();
        TimeSheet.TimesheetEntry entry1 = new TimeSheet.TimesheetEntry();
        entry1.setDate(LocalDate.of(2023, 5, 16));
        entry1.setHours(8);
        entry1.setInvestmentId("6f43w5r");
        entries.add(entry1);

        TimeSheet.TimesheetEntry entry2 = new TimeSheet.TimesheetEntry();
        entry2.setDate(LocalDate.of(2023, 5, 18));
        entry2.setHours(7);
        entry2.setInvestmentId("3f43w5r");
        entries.add(entry2);
        timesheet.setEntries(entries);
        int expectedStatusCode = 200;


        // Act
        Response response = RestAssured.given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(timesheet)
                .when()
                .post("/clarity")
                .then()
                .extract()
                .response();

        // Assert
        assertEquals(expectedStatusCode, response.getStatusCode());
    }
}
