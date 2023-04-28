package com.capgemini.be.lms.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;


public class LeaveRequest {
    private int localEmployeeId;
    private LeaveType leaveType;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate endDate;


    private int startHours;


    private int endDateHours;


    private int totalHours;
    private Reason reason;
    private Status status;

    private LeaveRequest() {
    }

    public static class Builder {
        private final int localEmployeeId;
        private final LeaveType leaveType;
        private final LocalDate startDate;
        private final LocalDate endDate;

        private int startHours;
        private int endDateHours;
        private int totalHours;
        private Reason reason = null;
        private Status status = null;


        public Builder(int localEmployeeId, LeaveType leaveType, LocalDate startDate, LocalDate endDate) {
            this.localEmployeeId = localEmployeeId;
            this.leaveType = leaveType;
            this.startDate = startDate;
            this.endDate = endDate;
        }


        public Builder startHours(int startHours) {
            this.startHours = startHours;
            return this;
        }

        public Builder endDateHours(int endDateHours) {
            this.endDateHours = endDateHours;
            return this;
        }

        public Builder totalHours(int totalHours) {
            this.totalHours = totalHours;
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
            leaveRequest.reason = this.reason;
            leaveRequest.status = this.status;

            return leaveRequest;
        }
    }
    @Override
    public String toString() {
        return "LeaveRequest{" +
                "localEmployeeId=" + localEmployeeId +
                ", leaveType=" + leaveType +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", startHours=" + startHours +
                ", endDateHours=" + endDateHours +
                ", totalHours=" + totalHours +
                ", reason=" + reason +
                ", status=" + status +
                '}';
    }


    public int getLocalEmployeeId() {
        return localEmployeeId;
    }

    public LeaveType getLeaveType() {
        return leaveType;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public int getStartHours() {
        return startHours;
    }

    public int getEndDateHours() {
        return endDateHours;
    }

    public int getTotalHours() {
        return totalHours;
    }

    public Reason getReason() {
        return reason;
    }

    public Status getStatus() {
        return status;
    }
}
