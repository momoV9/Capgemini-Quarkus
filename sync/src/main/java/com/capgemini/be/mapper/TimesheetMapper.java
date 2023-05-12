package com.capgemini.be.mapper;

import com.capgemini.be.clarity.model.TimeSheet;
import com.capgemini.be.lms.model.LeaveRequest;
import com.capgemini.be.lms.model.LeaveType;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@ApplicationScoped
public class TimesheetMapper {

    public TimesheetMapper() {
        HashMap<String, String> investmentIdMapping = new HashMap<>();
        investmentIdMapping.put("VACATION", "123456");
    }

    public TimeSheet map(LeaveRequest leaveRequest) {
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
        return "";
    }
}
