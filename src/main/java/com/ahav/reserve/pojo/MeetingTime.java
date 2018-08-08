package com.ahav.reserve.pojo;

import java.util.Date;

public class MeetingTime {
    private Date nextMeetingTime;  //下次会议时间
    private Date lastMeetingTime;  //上次会议时间

    public Date getNextMeetingTime() {
        return nextMeetingTime;
    }

    public void setNextMeetingTime(Date nextMeetingTime) {
        this.nextMeetingTime = nextMeetingTime;
    }

    public Date getLastMeetingTime() {
        return lastMeetingTime;
    }

    public void setLastMeetingTime(Date lastMeetingTime) {
        this.lastMeetingTime = lastMeetingTime;
    }

    @Override
    public String toString() {
        return "MeetingTime{" +
                "nextMeetingTime=" + nextMeetingTime +
                ", lastMeetingTime=" + lastMeetingTime +
                '}';
    }
}
