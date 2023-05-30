package com.capgemini.be.mapper;

import com.capgemini.sync.mapper.TimesheetMapper;
import com.capgemini.sync.model.LeaveRequest;
import com.capgemini.sync.model.TimeSheet;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TimesheetMapperTest {
    private LeaveRequest leaveRequest;
    private final TimesheetMapper mapper = new TimesheetMapper();

    @Test
    void testMap() {
        // Arange
        leaveRequest = new LeaveRequest();
        leaveRequest.setLocalEmployeeId(123456);
        leaveRequest.setStartDate(LocalDate.of(2023, 5, 10));
        leaveRequest.setStartHours(1);

        // Act
        TimeSheet timeSheet = mapper.transformToTimesheet(leaveRequest);

        // Assert
        assertNotNull(timeSheet);
        assertEquals(123456, timeSheet.getUser());
        assertEquals(1, timeSheet.getEntries().size());

        TimeSheet.TimesheetEntry entry = timeSheet.getEntries().get(0);
        assertEquals(LocalDate.of(2023, 5, 10), entry.getDate());
        assertEquals(8, entry.getHours());
    }

    @Test
    void testMapSingleEntry() {
        // Arange
        leaveRequest = new LeaveRequest();
        leaveRequest.setLocalEmployeeId(12345);
        leaveRequest.setStartDate(LocalDate.now());
        leaveRequest.setStartHours(8);

        // Act
        TimeSheet timeSheet = mapper.transformToTimesheet(leaveRequest);

        // Assert
        assertEquals(1, timeSheet.getEntries().size());
        assertEquals(12345L, timeSheet.getUser());

        TimeSheet.TimesheetEntry entry = timeSheet.getEntries().get(0);
        assertEquals(leaveRequest.getStartDate(), entry.getDate());
        assertEquals(8 * 8, entry.getHours());
    }

    @Test
    void testMapHalfDayEntry() {
        // Arange
        leaveRequest = new LeaveRequest();
        leaveRequest.setLocalEmployeeId(123456);
        leaveRequest.setStartDate(LocalDate.of(2023, 5, 12));
        leaveRequest.setStartHours(4);

        // Act
        TimeSheet timeSheet = mapper.transformToTimesheet(leaveRequest);

        // Assert
        assertEquals(1, timeSheet.getEntries().size());
        assertEquals(123456L, timeSheet.getUser());

        TimeSheet.TimesheetEntry entry = timeSheet.getEntries().get(0);
        assertEquals(leaveRequest.getStartDate(), entry.getDate());
        assertEquals(4 * 8, entry.getHours());
    }
}
