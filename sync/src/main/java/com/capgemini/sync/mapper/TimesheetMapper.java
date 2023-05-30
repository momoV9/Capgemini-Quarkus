package com.capgemini.sync.mapper;

import com.capgemini.sync.model.LeaveRequest;
import com.capgemini.sync.model.LeaveType;
import com.capgemini.sync.model.TimeSheet;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

@ApplicationScoped
public class TimesheetMapper {
    private final EnumMap<LeaveType, String> investmentIdMapping;
    public TimesheetMapper() {
        investmentIdMapping = new EnumMap<>(LeaveType.class);
        investmentIdMapping.put(LeaveType.VACATION, "123456");
    }

    public TimeSheet transformToTimesheet(LeaveRequest leaveRequest) {
        TimeSheet timeSheet = new TimeSheet();
        timeSheet.setUser(leaveRequest.getLocalEmployeeId());
        timeSheet.setEntries(createEntries(leaveRequest));
        return timeSheet;
    }

    private List<TimeSheet.TimesheetEntry> createEntries(LeaveRequest leaveRequest) {
        List<TimeSheet.TimesheetEntry> entries = new ArrayList<>();
        TimeSheet.TimesheetEntry entry = createEntry(leaveRequest);
        entries.add(entry);
        return entries;
    }

    private TimeSheet.TimesheetEntry createEntry(LeaveRequest leaveRequest) {
        TimeSheet.TimesheetEntry entry = new TimeSheet.TimesheetEntry();
        entry.setDate(leaveRequest.getStartDate());
        entry.setHours(leaveRequest.getStartHours() * 8);
        entry.setInvestmentId(findInvestmentId(leaveRequest.getLeaveType()));
        return entry;
    }

    private String findInvestmentId(LeaveType leaveType) {
        return investmentIdMapping.getOrDefault(leaveType, "");
    }
}
