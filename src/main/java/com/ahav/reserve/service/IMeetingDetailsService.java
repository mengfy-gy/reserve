package com.ahav.reserve.service;

import com.ahav.reserve.pojo.MeetingDetails;

import java.util.Date;
import java.util.List;

public interface IMeetingDetailsService {
    //初始化预约管理页面
    public List<MeetingDetails> findMeetingDetailsAll();
    //修改会议详情
    public int alterMeetingDetails(MeetingDetails meetingDetails);
    //删除会议详情(取消会议预约)
    public int deleteMeetingDetails(Integer deDetailsId);
    //根据详情Id查询会议详情
    public MeetingDetails findMeetingDetails(Integer deDetailsId);
    //按条件查询会议详情
    public List<MeetingDetails> findMeetingDetails(MeetingDetails meetingDetails);
    //查询下一次会议的时间
    public MeetingDetails findNextTime(Date endTime);
    //查询上一次会议的时间
    public MeetingDetails findLastTime(Date startTime);
    //根据会议室id查询会议详情
    public List<MeetingDetails> findRoomIdMeetingDetails(Integer deRoomId);
    //添加会议详情
    public int addMeetingDetails(MeetingDetails meetingDetails);

}
