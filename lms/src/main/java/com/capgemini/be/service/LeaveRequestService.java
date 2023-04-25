package com.capgemini.be.service;

import com.capgemini.be.lms.model.LeaveRequest;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;

@ApplicationScoped
public class LeaveRequestService {

    public LeaveRequest createLeaveRequest(LeaveRequest leaveRequest) {
        // Lege ArrayList
        ArrayList<String> myList = new ArrayList<String>();

        return leaveRequest;
    }

    public LeaveRequestService() {
    }
}
