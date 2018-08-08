package com.ahav.reserve.pojo;

public class Room {
    private Integer meetingRoomId;

    private Integer meetingRoomScale;

    private String meetingRoomName;

    private String meEquipmentList;

    private Integer meetingRoomStatus;

    public Integer getMeetingRoomId() {
        return meetingRoomId;
    }

    public void setMeetingRoomId(Integer meetingRoomId) {
        this.meetingRoomId = meetingRoomId;
    }

    public Integer getMeetingRoomScale() {
        return meetingRoomScale;
    }

    public void setMeetingRoomScale(Integer meetingRoomScale) {
        this.meetingRoomScale = meetingRoomScale;
    }

    public String getMeetingRoomName() {
        return meetingRoomName;
    }

    public void setMeetingRoomName(String meetingRoomName) {
        this.meetingRoomName = meetingRoomName == null ? null : meetingRoomName.trim();
    }

    public String getMeEquipmentList() {
        return meEquipmentList;
    }

    public void setMeEquipmentList(String meEquipmentList) {
        this.meEquipmentList = meEquipmentList == null ? null : meEquipmentList.trim();
    }

    public Integer getMeetingRoomStatus() {
        return meetingRoomStatus;
    }

    public void setMeetingRoomStatus(Integer meetingRoomStatus) {
        this.meetingRoomStatus = meetingRoomStatus;
    }

    @Override
    public String toString() {
        return "Room{" +
                "meetingRoomId=" + meetingRoomId +
                ", meetingRoomScale=" + meetingRoomScale +
                ", meetingRoomName='" + meetingRoomName + '\'' +
                ", meEquipmentList='" + meEquipmentList + '\'' +
                ", meetingRoomStatus=" + meetingRoomStatus +
                '}';
    }
}