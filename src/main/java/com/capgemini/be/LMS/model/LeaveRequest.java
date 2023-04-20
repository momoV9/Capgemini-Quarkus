package com.capgemini.be.LMS.model;

public class LeaveRequest {
    private int localEmployeeId;
    private String employeeName;
    private LeaveType leaveType;
    private int leaveAvailed;
    private int year;
    private int carryForward;
    private int leaveLapsed;
    private int leaveCredit;
    private int leaveDebit;
    private int leaveBalance;
    private Unit unit;
    private String buCountry;
    private Reason reason;


    public LeaveRequest(int localEmployeeId, String employeeName, LeaveType leaveType, int leaveAvailed, int year, int carryForward, int leaveLapsed, int leaveCredit, int leaveDebit, int leaveBalance, Unit unit, String buCountry, Reason reason) {
        this.localEmployeeId = localEmployeeId;
        this.employeeName = employeeName;
        this.leaveType = leaveType;
        this.leaveAvailed = leaveAvailed;
        this.year = year;
        this.carryForward = carryForward;
        this.leaveLapsed = leaveLapsed;
        this.leaveCredit = leaveCredit;
        this.leaveDebit = leaveDebit;
        this.leaveBalance = leaveBalance;
        this.unit = unit;
        this.buCountry = buCountry;
        this.reason = reason;
    }

    public int getLocalEmployeeId() {
        return localEmployeeId;
    }

    public void setLocalEmployeeId(int localEmployeeId) {
        this.localEmployeeId = localEmployeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public LeaveType getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(LeaveType leaveType) {
        this.leaveType = leaveType;
    }

    public int getLeaveAvailed() {
        return leaveAvailed;
    }

    public void setLeaveAvailed(int leaveAvailed) {
        this.leaveAvailed = leaveAvailed;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCarryForward() {
        return carryForward;
    }

    public void setCarryForward(int carryForward) {
        this.carryForward = carryForward;
    }

    public int getLeaveLapsed() {
        return leaveLapsed;
    }

    public void setLeaveLapsed(int leaveLapsed) {
        this.leaveLapsed = leaveLapsed;
    }

    public int getLeaveCredit() {
        return leaveCredit;
    }

    public void setLeaveCredit(int leaveCredit) {
        this.leaveCredit = leaveCredit;
    }

    public int getLeaveDebit() {
        return leaveDebit;
    }

    public void setLeaveDebit(int leaveDebit) {
        this.leaveDebit = leaveDebit;
    }

    public int getLeaveBalance() {
        return leaveBalance;
    }

    public void setLeaveBalance(int leaveBalance) {
        this.leaveBalance = leaveBalance;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public String getBuCountry() {
        return buCountry;
    }

    public void setBuCountry(String buCountry) {
        this.buCountry = buCountry;
    }

    public Reason getReason() {
        return reason;
    }

    public void setReason(Reason reason) {
        this.reason = reason;
    }
}
