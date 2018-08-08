package com.ahav.reserve.mapper;

import com.ahav.reserve.pojo.MeetingDetails;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface MeetingDetailsMapper {
    int deleteByPrimaryKey(Integer deDetailsId);

    int insert(MeetingDetails record);

    int insertSelective(MeetingDetails record);

    MeetingDetails selectByPrimaryKey(Integer deDetailsId);

    int updateByPrimaryKeySelective(MeetingDetails record);

    int updateByPrimaryKey(MeetingDetails record);

    //查询下一次会议时间
    MeetingDetails selectNextTime(Date startTime);
    //查询上一次会议时间
    MeetingDetails selectLastTime(Date endTime);
    //查询所有会议详情
    List<MeetingDetails> selectMeetingDetailsAll();
    //按条件查询会议详情
    List<MeetingDetails> selectMeetingDetails(MeetingDetails meetingDetails);
    //根据会议室id查询会议详情
    List<MeetingDetails> selectRoomIdMeetingDetails(Integer deRoomId);


}