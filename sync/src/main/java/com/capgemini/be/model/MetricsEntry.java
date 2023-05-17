package com.capgemini.be.model;

import com.capgemini.be.lms.model.LeaveType;

import java.time.LocalDate;

public class MetricsEntry {
    private String user;
    private LocalDate startDate;
    private LocalDate endDate;
    private LeaveType leaveType;
    private int hours;

    public MetricsEntry() {
    }

    public MetricsEntry(String user, LocalDate startDate, LocalDate endDate, LeaveType leaveType, int hours) {
        this.user = user;
        this.startDate = startDate;
        this.endDate = endDate;
        this.leaveType = leaveType;
        this.hours = hours;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LeaveType getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(LeaveType leaveType) {
        this.leaveType = leaveType;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return "MetricsEntry{" +
                "user='" + user + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", leaveType=" + leaveType +
                ", hours=" + hours +
                '}';
    }
}
