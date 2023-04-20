package com.capgemini.be.service;

import com.capgemini.be.LMS.model.LeaveRequest;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LeaveRequestService {

    public LeaveRequest createLeaveRequest(LeaveRequest leaveRequest) {
        return leaveRequest;
    }
}

