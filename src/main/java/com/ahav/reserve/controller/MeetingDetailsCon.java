package com.ahav.reserve.controller;

import com.ahav.reserve.pojo.*;
import com.ahav.reserve.service.IMeetingDetailsService;
import com.ahav.reserve.service.IRoomService;
import com.ahav.reserve.utils.meetingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MeetingDetailsCon {
    @Autowired
    private IMeetingDetailsService meetingDetailsServiceImpl;
    @Autowired
    private IRoomService roomServiceImpl;

    //查询所有会议(初始化预约管理页面/添加预约界面)
    @RequestMapping(value = {"/initReserveManage","/initAddReserve"},method = RequestMethod.GET)
    @ResponseBody
    public Map findMeetingDetailsAll(){
        Result result = new Result();

        Boolean flag = false;
        int deReserveId = 3;  //预定人id

        Map initPageMap = new HashMap();
        MeetingTime meetingTime = new MeetingTime();

        //调用接口参数当前操作需要的权限，得到true或false
            /*flag = 调用是否有权限的接口*/
        //调用接口token获得当前用户的id
            /* deReserveId = 调用token；*/

        //查询出当天所有的会议
        MeetingDetails mDetails =  new MeetingDetails();
        Date startTime = meetingUtils.getStartTime(new Date());
        Date endTime = meetingUtils.getEndTime(new Date());
        mDetails.setDeMeetingStart(startTime);
        mDetails.setDeMeetingOver(endTime);
        List<MeetingDetails> meetingDetailsAll = meetingDetailsServiceImpl.findMeetingDetails(mDetails);


        //获得上次会议时间
        MeetingDetails lastTime = meetingDetailsServiceImpl.findLastTime(startTime);
        meetingTime.setLastMeetingTime(lastTime.getDeMeetingStart());
        //获得下次会议时间
        MeetingDetails nextTime = meetingDetailsServiceImpl.findNextTime(endTime);
        if(nextTime != null){
            //只有下次会议不为空，才取会议时间
            meetingTime.setNextMeetingTime(nextTime.getDeMeetingStart());
        }

        List<Room> roomAll = roomServiceImpl.fendRoomAll();
        initPageMap.put("roomAll",roomAll);
        initPageMap.put("meetingTime",meetingTime);

        /*调用接口查询会议室设备列表
        * initPageMap.put("会议室设备列表",会议室设备列表);*/


        if(flag){
            //可以查看所有会议详情
            for(MeetingDetails meetingDetails:meetingDetailsAll){
                meetingDetails.setDeShow(1);
            }

            initPageMap.put("meetingDetailsAll",meetingDetailsAll);
            //查询出所有会议室詳情
           /* for (MeetingDetails mee:meetingDetailsAll){
                System.out.println(mee);
            }*/
            result.setStatus(200);
            initPageMap.put("result",result);
            return initPageMap;
        }else{
            //不可查看所有会议详情
            for(MeetingDetails meetingDetails:meetingDetailsAll){
                if(meetingDetails.getDeReserveId()==deReserveId){
                    meetingDetails.setDeShow(1);
                }
            }
            initPageMap.put("meetingDetailsAll",meetingDetailsAll);
            //查询出所有会议室詳情
           /* for (MeetingDetails mee:meetingDetailsAll){
                System.out.println(mee);
            }*/
            result.setStatus(200);
            initPageMap.put("result",result);
            return initPageMap;
        }

    }



    //查询会议详情列表
    public Map selectMeetingDetails(MeetingDetails meetingDetails){
        Result result = new Result();
        Boolean flag = false; //默认没有权限
        int deReserveId = 3;  //预定人id
        Map meetingListMap = new HashMap<String,Object>();
        MeetingTime meetingTime = new MeetingTime(); //会议时间

        //根据条件查询出某一天的会议详情
        Date meetingStart = meetingDetails.getDeMeetingStart();
        Date startTime = meetingUtils.getStartTime(meetingStart);  //获得某一天的开始时间
        Date endTime = meetingUtils.getEndTime(meetingStart);  //获得某一天的结束时间
        meetingDetails.setDeMeetingStart(startTime);
        meetingDetails.setDeMeetingOver(endTime);
        List<MeetingDetails> meetingDetailsList = meetingDetailsServiceImpl.findMeetingDetails(meetingDetails);

        //调用接口参数当前操作需要的权限，得到true或false
            /*flag = 调用是否有权限的接口*/
        //调用接口token获得当前用户的id
            /* deReserveId = 调用token；*/

        //获得上次会议时间
        MeetingDetails lastTime = meetingDetailsServiceImpl.findLastTime(startTime);
        meetingTime.setLastMeetingTime(lastTime.getDeMeetingStart());
        //获得下次会议时间
        MeetingDetails nextTime = meetingDetailsServiceImpl.findNextTime(endTime);
        meetingTime.setNextMeetingTime(nextTime.getDeMeetingStart());

        meetingListMap.put("meetingTime ",meetingTime);  //将会议时间对象添加到map中

        if(flag){
            for(MeetingDetails md:meetingDetailsList){
                md.setDeShow(1);
            }

            meetingListMap.put("meetingDetailsList",meetingDetailsList);
            result.setStatus(200);
            meetingListMap.put("result",result);
            return meetingListMap;
        }else{
            for(MeetingDetails md:meetingDetailsList){
                if(md.getDeReserveId() == deReserveId){
                    md.setDeShow(1);
                }
            }
            meetingListMap.put("meetingDetailsList",meetingDetailsList);
            result.setStatus(200);
            meetingListMap.put("result",result);
            return meetingListMap;
        }


    }



    //修改会议室详情
    @RequestMapping (value = "/alterMeetingDetails",method = RequestMethod.PUT)
    //@PutMapping("MeetingDetails")
    @ResponseBody
    public Map updateMeetingDetails(MeetingDetails meetingDetails){

        Map map = new HashMap<String,Object>();
        Date stratTime = meetingDetails.getDeMeetingStart(); //修改为的会议开始时间
        Date overTime = meetingDetails.getDeMeetingOver();  //修改为的会议结束时间
        boolean flag = false;
        int deRoomId = meetingDetails.getDeRoomId();
        Result result = new Result();

        List<MeetingDetails> roomIdMeetingDetails = meetingDetailsServiceImpl.findRoomIdMeetingDetails(deRoomId);
        //判断修改的会议时间跟以有的会议时间有没有冲突
        for (MeetingDetails md:roomIdMeetingDetails){
            if(md.getDeMeetingStart().compareTo(stratTime) == -1){
                if(md.getDeMeetingOver().compareTo(stratTime) == -1){
                    flag=true;
                }else {
                    flag=false;
                }
            }else {
                if(md.getDeMeetingStart().compareTo(overTime) == 1){
                    flag = true;
                }else {
                    flag = false;
                }
            }
        }

        if(flag){
            //时间没有冲突可以修改
            int i = meetingDetailsServiceImpl.alterMeetingDetails(meetingDetails);
            if(i>0){
                result.setStatus(200);
                MeetingDetails meetingDetails1 = meetingDetailsServiceImpl.findMeetingDetails(meetingDetails.getDeDetailsId());
                map.put("result",result);
                map.put("meetingDetails1",meetingDetails1);
                return map;
            }else{
                result.setStatus(400);
                map.put("result",result);
                return map;
            }

        }else {
            //时间冲突
            result.setStatus(400);
            map.put("result",result);
            return map;
        }


    }

    //删除会议详情
    @RequestMapping(value = "/deleteMeetingDetails",method = RequestMethod.DELETE)
    @ResponseBody
    public Result deleteMeetingDetails(int deDetailsId){
        int i = meetingDetailsServiceImpl.deleteMeetingDetails(deDetailsId);
        Result result = new Result();
        if(i>0){
            result.setStatus(200);
        }else{
            result.setStatus(400);
        }
        return result;
    }

    //根据会议详情id查询详情
    @RequestMapping(value = "MeetingDetails/{deDetailsId}",method = RequestMethod.GET)
    @ResponseBody
    public Map selectMeetingDetails(@PathVariable int deDetailsId){
        Map detailsMap = new HashMap<String,Object>();
        Result result = new Result();
        if(deDetailsId > 0){
            //当传递
            MeetingDetails meetingDetails = meetingDetailsServiceImpl.findMeetingDetails(deDetailsId);
            if(meetingDetails != null){
                result.setStatus(200);
                detailsMap.put("meetingDetails",meetingDetails);
            }else {
                result.setStatus(400);
                detailsMap.put("meetingDetails",meetingDetails);
            }
            return detailsMap;
        }else {
            result.setStatus(400);
            detailsMap.put("result",result);
            return detailsMap;
        }
    }

    //添加会议详情
    @RequestMapping(value = "/insertMeetingDetails",method = RequestMethod.POST)
    @ResponseBody
    public Result insertMeetingDetails(MeetingDetails meetingDetails){
        Result result = new Result();
        MeetingDetails mDetails =  new MeetingDetails();
        int roomId = meetingDetails.getDeRoomId();
        boolean flag = false;
        Date meetingStart = meetingDetails.getDeMeetingOver(); //添加新会议的开始时间
        Date meetingOver = meetingDetails.getDeMeetingStart();  //添加新会议的结束时间

        //查询出指定日期指定会议室的会议详情
        Date startTime = meetingUtils.getStartTime(meetingStart); //获得指定日期的开始时间
        Date endTime = meetingUtils.getEndTime(meetingOver);  //获得指定日期的结束时间
        mDetails.setDeMeetingStart(startTime);
        mDetails.setDeMeetingOver(endTime);
        mDetails.setDeRoomId(roomId);
        List<MeetingDetails> meetingDetailsAll = meetingDetailsServiceImpl.findMeetingDetails(mDetails);
        //判断指定日期指定的会议室已有会议有没有跟新添加会议的时间冲突
        for (MeetingDetails md:meetingDetailsAll){
            if(md.getDeMeetingStart().compareTo(meetingStart) == -1){
                if(md.getDeMeetingOver().compareTo(meetingStart) == -1){
                    flag=true;
                }else {
                    flag=false;
                }
            }else {
                if(md.getDeMeetingStart().compareTo(meetingOver) == 1){
                    flag = true;
                }else {
                    flag = false;
                }
            }
        }

        if(flag){
            //没有冲突,添加会议
            int update = meetingDetailsServiceImpl.addMeetingDetails(meetingDetails);
            if(update == 1){
                result.setStatus(200);
                return result;
            }else {
                result.setStatus(400);
                return result;
            }
        }else{
            result.setStatus(400);
            return result;
        }
    }


}
