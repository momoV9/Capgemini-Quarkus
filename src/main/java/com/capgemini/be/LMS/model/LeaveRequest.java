package com.capgemini.be.LMS.model;

import java.sql.Time;
import java.util.Date;

public class LeaveRequest {
    private int localEmployeeId;
    private LeaveType leaveType;
    private Date startDate;
    private Date endDate;
    private Time startHours;
    private Time endDateHours;
    private Time totalHours;
    private Unit unit;
    private Reason reason;
    private Status status;

    private LeaveRequest() {
    }

    public static class Builder {
        private final int localEmployeeId;
        private final LeaveType leaveType;
        private final Date startDate;
        private final Date endDate;

        private Time startHours = null;
        private Time endDateHours = null;
        private Time totalHours = null;
        private Unit unit = null;
        private Reason reason = null;
        private Status status = null;


        public Builder(int localEmployeeId, LeaveType leaveType, Date startDate, Date endDate) {
            this.localEmployeeId = localEmployeeId;
            this.leaveType = leaveType;
            this.startDate = startDate;
            this.endDate = endDate;
        }


        public Builder startHours(Time startHours) {
            this.startHours = startHours;
            return this;
        }

        public Builder endDateHours(Time endDateHours) {
            this.endDateHours = endDateHours;
            return this;
        }

        public Builder totalHours(Time totalHours) {
            this.totalHours = totalHours;
            return this;
        }

        public Builder unit(Unit unit) {
            this.unit = unit;
            return this;
        }

        public Builder reason(Reason reason) {
            this.reason = reason;
            return this;
        }

        public Builder status(Status status) {
            this.status = status;
            return this;
        }

        public LeaveRequest build() {
            LeaveRequest leaveRequest = new LeaveRequest();
            leaveRequest.localEmployeeId = this.localEmployeeId;
            leaveRequest.leaveType = this.leaveType;
            leaveRequest.startDate = this.startDate;
            leaveRequest.endDate = this.endDate;
            leaveRequest.startHours = this.startHours;
            leaveRequest.endDateHours = this.endDateHours;
            leaveRequest.totalHours = this.totalHours;
            leaveRequest.unit = this.unit;
            leaveRequest.reason = this.reason;
            leaveRequest.status = this.status;

            return leaveRequest;
        }
    }

    public int getLocalEmployeeId() {
        return localEmployeeId;
    }

    public LeaveType getLeaveType() {
        return leaveType;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Time getStartHours() {
        return startHours;
    }

    public Time getEndDateHours() {
        return endDateHours;
    }

    public Time getTotalHours() {
        return totalHours;
    }

    public Unit getUnit() {
        return unit;
    }

    public Reason getReason() {
        return reason;
    }
}
