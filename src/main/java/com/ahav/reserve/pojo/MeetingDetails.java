package com.ahav.reserve.pojo;

import java.util.Date;

public class MeetingDetails {
    private Integer deDetailsId;

    private String deGrade;

    private Integer deRoomId;

    private String deMeetingName;

    private String deReserveDepartment;

    private String deReserve;

    private String deReservePhone;

    private Integer deReserveNumber;

    private String deMain;

    private Date deMeetingOver;

    private Date deMeetingStart;

    private String deDepartmentReservePerson;

    private String deMeetingStatus;

    private Integer deMeetingCount;

    private Date deDateCount;

    private Integer deGradeId;

    private Integer deReserveId;

    private Integer deDepartmentReservePersonId;

    private Integer deShow;

    public Integer getDeDetailsId() {
        return deDetailsId;
    }

    public void setDeDetailsId(Integer deDetailsId) {
        this.deDetailsId = deDetailsId;
    }

    public String getDeGrade() {
        return deGrade;
    }

    public void setDeGrade(String deGrade) {
        this.deGrade = deGrade == null ? null : deGrade.trim();
    }

    public Integer getDeRoomId() {
        return deRoomId;
    }

    public void setDeRoomId(Integer deRoomId) {
        this.deRoomId = deRoomId;
    }

    public String getDeMeetingName() {
        return deMeetingName;
    }

    public void setDeMeetingName(String deMeetingName) {
        this.deMeetingName = deMeetingName == null ? null : deMeetingName.trim();
    }

    public String getDeReserveDepartment() {
        return deReserveDepartment;
    }

    public void setDeReserveDepartment(String deReserveDepartment) {
        this.deReserveDepartment = deReserveDepartment == null ? null : deReserveDepartment.trim();
    }

    public String getDeReserve() {
        return deReserve;
    }

    public void setDeReserve(String deReserve) {
        this.deReserve = deReserve == null ? null : deReserve.trim();
    }

    public String getDeReservePhone() {
        return deReservePhone;
    }

    public void setDeReservePhone(String deReservePhone) {
        this.deReservePhone = deReservePhone == null ? null : deReservePhone.trim();
    }

    public Integer getDeReserveNumber() {
        return deReserveNumber;
    }

    public void setDeReserveNumber(Integer deReserveNumber) {
        this.deReserveNumber = deReserveNumber;
    }

    public String getDeMain() {
        return deMain;
    }

    public void setDeMain(String deMain) {
        this.deMain = deMain == null ? null : deMain.trim();
    }

    public Date getDeMeetingOver() {
        return deMeetingOver;
    }

    public void setDeMeetingOver(Date deMeetingOver) {
        this.deMeetingOver = deMeetingOver;
    }

    public Date getDeMeetingStart() {
        return deMeetingStart;
    }

    public void setDeMeetingStart(Date deMeetingStart) {
        this.deMeetingStart = deMeetingStart;
    }

    public String getDeDepartmentReservePerson() {
        return deDepartmentReservePerson;
    }

    public void setDeDepartmentReservePerson(String deDepartmentReservePerson) {
        this.deDepartmentReservePerson = deDepartmentReservePerson == null ? null : deDepartmentReservePerson.trim();
    }

    public String getDeMeetingStatus() {
        return deMeetingStatus;
    }

    public void setDeMeetingStatus(String deMeetingStatus) {
        this.deMeetingStatus = deMeetingStatus == null ? null : deMeetingStatus.trim();
    }

    public Integer getDeMeetingCount() {
        return deMeetingCount;
    }

    public void setDeMeetingCount(Integer deMeetingCount) {
        this.deMeetingCount = deMeetingCount;
    }

    public Date getDeDateCount() {
        return deDateCount;
    }

    public void setDeDateCount(Date deDateCount) {
        this.deDateCount = deDateCount;
    }

    public Integer getDeGradeId() {
        return deGradeId;
    }

    public void setDeGradeId(Integer deGradeId) {
        this.deGradeId = deGradeId;
    }

    public Integer getDeReserveId() {
        return deReserveId;
    }

    public void setDeReserveId(Integer deReserveId) {
        this.deReserveId = deReserveId;
    }

    public Integer getDeDepartmentReservePersonId() {
        return deDepartmentReservePersonId;
    }

    public void setDeDepartmentReservePersonId(Integer deDepartmentReservePersonId) {
        this.deDepartmentReservePersonId = deDepartmentReservePersonId;
    }

    public Integer getDeShow() {
        return deShow;
    }

    public void setDeShow(Integer deShow) {
        this.deShow = deShow;
    }

    @Override
    public String toString() {
        return "MeetingDetails{" +
                "deDetailsId=" + deDetailsId +
                ", deGrade='" + deGrade + '\'' +
                ", deRoomId=" + deRoomId +
                ", deMeetingName='" + deMeetingName + '\'' +
                ", deReserveDepartment='" + deReserveDepartment + '\'' +
                ", deReserve='" + deReserve + '\'' +
                ", deReservePhone='" + deReservePhone + '\'' +
                ", deReserveNumber=" + deReserveNumber +
                ", deMain='" + deMain + '\'' +
                ", deMeetingOver=" + deMeetingOver +
                ", deMeetingStart=" + deMeetingStart +
                ", deDepartmentReservePerson='" + deDepartmentReservePerson + '\'' +
                ", deMeetingStatus='" + deMeetingStatus + '\'' +
                ", deMeetingCount=" + deMeetingCount +
                ", deDateCount=" + deDateCount +
                ", deGradeId=" + deGradeId +
                ", deReserveId=" + deReserveId +
                ", deDepartmentReservePersonId=" + deDepartmentReservePersonId +
                ", deShow=" + deShow +
                '}';
    }
}