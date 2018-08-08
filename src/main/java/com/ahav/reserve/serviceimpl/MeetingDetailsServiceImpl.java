package com.ahav.reserve.serviceimpl;

import com.ahav.reserve.mapper.MeetingDetailsMapper;
import com.ahav.reserve.pojo.MeetingDetails;
import com.ahav.reserve.service.IMeetingDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

@Service
public class MeetingDetailsServiceImpl implements IMeetingDetailsService {
    @Autowired
    private MeetingDetailsMapper meetingDetailsMapperImpl;
/*    @Autowired
    private RestTemplate RestTemplate;*/

    //查询所有会议详情
    @Override
    public List<MeetingDetails> findMeetingDetailsAll() {

        return meetingDetailsMapperImpl.selectMeetingDetailsAll();
    }

/*  //调用模板
    public void findTemplate(){
        RestTemplate.getForObject("http://192.168.18.112:80/aqi/presetmode/list",JSONObject.class);
    }*/

    //修改会议详情
    @Override
    public int alterMeetingDetails(MeetingDetails meetingDetails) {
        return meetingDetailsMapperImpl.updateByPrimaryKeySelective(meetingDetails);
    }

    //删除会议详情（取消预约）
    @Override
    public int deleteMeetingDetails(Integer deDetailsId) {
        return meetingDetailsMapperImpl.deleteByPrimaryKey(deDetailsId);
    }

    //根据详情id查询会议详情
    @Override
    public MeetingDetails findMeetingDetails(Integer deDetailsId) {
        return meetingDetailsMapperImpl.selectByPrimaryKey(deDetailsId);
    }

    //按条件查询会议详情
    @Override
    public List<MeetingDetails> findMeetingDetails(MeetingDetails meetingDetails) {
        return meetingDetailsMapperImpl.selectMeetingDetails(meetingDetails);
    }

    //查询上次会议的时间
    @Override
    public MeetingDetails findNextTime(Date startTime) {
        return meetingDetailsMapperImpl.selectNextTime(startTime);
    }
    //查询下次会议的时间
    @Override
    public MeetingDetails findLastTime(Date endTime) {
        return meetingDetailsMapperImpl.selectLastTime(endTime);
    }
    //根据会议室id查询会议详情
    @Override
    public List<MeetingDetails> findRoomIdMeetingDetails(Integer deRoomId) {
        return meetingDetailsMapperImpl.selectRoomIdMeetingDetails(deRoomId);
    }
    //添加会议详情
    @Override
    public int addMeetingDetails(MeetingDetails meetingDetails) {
        return  meetingDetailsMapperImpl.insert(meetingDetails);
    }
}
