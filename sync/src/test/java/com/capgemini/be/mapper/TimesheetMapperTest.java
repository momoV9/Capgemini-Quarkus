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
        // Arrange
        leaveRequest = new LeaveRequest();
        leaveRequest.setLocalEmployeeId(123456);
        leaveRequest.setStartDate(LocalDate.of(2023, 5, 10));
        leaveRequest.setStartHours(1);


        mapper = new TimesheetMapper();
    }

    @Test
    void testMap() {
        // Arrange
        leaveRequest.setLocalEmployeeId(123456);
        leaveRequest.setStartDate(LocalDate.of(2023, 5, 10));
        leaveRequest.setStartHours(1);
        mapper = new TimesheetMapper();

        // Act
        TimeSheet timeSheet = mapper.map(leaveRequest);

        // Assert
        assertNotNull(timeSheet);
        assertEquals(123456, timeSheet.getUser());
        assertEquals(1, timeSheet.getEntries().size());

        TimeSheet.TimesheetEntry entry = timeSheet.getEntries().get(0);
        assertEquals(LocalDate.of(2023, 5, 10), entry.getDate());
        assertEquals(8, entry.getHours());
        assertEquals("investmentid123", entry.getInvestmentId());
    }

    @Test
    void testMapSingleEntry() {
        // Arrange
        leaveRequest.setLocalEmployeeId(12345);
        leaveRequest.setStartDate(LocalDate.now());
        leaveRequest.setStartHours(8);
        mapper = new TimesheetMapper();

        // Act
        TimeSheet timeSheet = mapper.map(leaveRequest);

        // Assert
        assertEquals(1, timeSheet.getEntries().size());
        assertEquals(12345L, timeSheet.getUser());

        TimeSheet.TimesheetEntry entry = timeSheet.getEntries().get(0);
        assertEquals(leaveRequest.getStartDate(), entry.getDate());
        assertEquals(8 * 8, entry.getHours());
        assertEquals("investmentid123", entry.getInvestmentId());
    }

    @Test
    void testMapHalfDayEntry() {
        // Arrange
        leaveRequest.setLocalEmployeeId(123456);
        leaveRequest.setStartDate(LocalDate.of(2023, 5, 12));
        leaveRequest.setStartHours(4);
        mapper = new TimesheetMapper();

        // Act
        TimeSheet timeSheet = mapper.map(leaveRequest);

        // Assert
        assertEquals(1, timeSheet.getEntries().size());
        assertEquals(123456L, timeSheet.getUser());

        TimeSheet.TimesheetEntry entry = timeSheet.getEntries().get(0);
        assertEquals(leaveRequest.getStartDate(), entry.getDate());
        assertEquals(4 * 8, entry.getHours());
        assertEquals("investmentid123", entry.getInvestmentId());
    }
}
