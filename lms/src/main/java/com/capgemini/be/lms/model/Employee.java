package com.capgemini.be.lms.model;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private final List<LeaveRequest> leaveRequests;

    public Employee(int id, String firstName, String lastName, String email, String phoneNumber, String jobTitle, String department) {
        this.leaveRequests = new ArrayList<>();
    }

    public void addLeaveRequest(LeaveRequest leaveRequest) {
        this.leaveRequests.add(leaveRequest);
    }

    public void removeLeaveRequest(LeaveRequest leaveRequest) {
        this.leaveRequests.remove(leaveRequest);
    }

    public List<LeaveRequest> getLeaveRequests() {
        return leaveRequests;
    }
}

