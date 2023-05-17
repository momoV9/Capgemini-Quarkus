package com.capgemini.be.service;

import com.capgemini.be.lms.model.LeaveRequest;
import com.capgemini.be.model.MetricsEntry;
import com.capgemini.be.repository.MetricsRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class MetricsService {

    @Inject
    MetricsRepository metricsRepository;

    public void addMetricsEntry(LeaveRequest leaveRequest) {
        MetricsEntry entry = new MetricsEntry();
        entry.setUser(String.valueOf(leaveRequest.getLocalEmployeeId()));
        entry.setStartDate(leaveRequest.getStartDate());
        entry.setEndDate(leaveRequest.getEndDate());
        entry.setLeaveType(leaveRequest.getLeaveType());
        entry.setHours(leaveRequest.getTotalHours());

        metricsRepository.addEntry(entry);
    }
}

