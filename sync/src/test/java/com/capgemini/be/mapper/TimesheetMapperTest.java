package com.capgemini.be.mapper;

import com.capgemini.be.clarity.model.TimeSheet;
import com.capgemini.be.lms.model.LeaveRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.wildfly.common.Assert.assertNotNull;

public class TimesheetMapperTest {
    private LeaveRequest leaveRequest;
    private TimesheetMapper mapper;

    @BeforeEach
    public void setup() {
        // set up the LeaveRequest object
        leaveRequest = new LeaveRequest();
        leaveRequest.setLocalEmployeeId(123456);
        leaveRequest.setStartDate(LocalDate.of(2023, 5, 10));
        leaveRequest.setStartHours(1);

        // set up the TimesheetMapper object
        mapper = new TimesheetMapper();
    }

    @Test
    public void testMap() {
        // call the map method
        TimeSheet timeSheet = mapper.map(leaveRequest);

        // verify that the TimeSheet object is created correctly
        assertNotNull(timeSheet);
        assertEquals(123456, timeSheet.getUser());
        assertEquals(1, timeSheet.getEntries().size());

        // verify that the TimesheetEntry object is created correctly
        TimeSheet.TimesheetEntry entry = timeSheet.getEntries().get(0);
        assertEquals(LocalDate.of(2023, 5, 10), entry.getDate());
        assertEquals(8, entry.getHours());
        assertEquals("investmentid123", entry.getInvestmentId());
    }

    @Test
    void testMapSingleEntry() {
        // set up the LeaveRequest object
        leaveRequest.setLocalEmployeeId(12345);
        leaveRequest.setStartDate(LocalDate.now());
        leaveRequest.setStartHours(8);

        // call the map method
        TimeSheet timeSheet = mapper.map(leaveRequest);

        // verify that the TimeSheet object is created correctly
        assertEquals(1, timeSheet.getEntries().size());
        assertEquals(12345L, timeSheet.getUser());

        // verify that the TimesheetEntry object is created correctly
        TimeSheet.TimesheetEntry entry = timeSheet.getEntries().get(0);
        assertEquals(leaveRequest.getStartDate(), entry.getDate());
        assertEquals(8 * 8, entry.getHours());
        assertEquals("investmentid123", entry.getInvestmentId());
    }
    @Test
    void testMapHalfDayEntry() {
        // set up the LeaveRequest object
        leaveRequest.setLocalEmployeeId(123456);
        leaveRequest.setStartDate(LocalDate.of(2023, 5, 12));
        leaveRequest.setStartHours(4);

        // call the map method
        TimeSheet timeSheet = mapper.map(leaveRequest);

        // verify that the TimeSheet object is created correctly
        assertEquals(1, timeSheet.getEntries().size());
        assertEquals(123456L, timeSheet.getUser());

        // verify that the TimesheetEntry object is created correctly
        TimeSheet.TimesheetEntry entry = timeSheet.getEntries().get(0);
        assertEquals(leaveRequest.getStartDate(), entry.getDate());
        assertEquals(4 * 8, entry.getHours());
        assertEquals("investmentid123", entry.getInvestmentId());
    }
}
