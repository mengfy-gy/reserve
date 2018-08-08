package com.ahav.reserve.serviceimpl;

import com.ahav.reserve.mapper.RoomMapper;
import com.ahav.reserve.pojo.Room;
import com.ahav.reserve.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements IRoomService {
    @Autowired
    private RoomMapper roomMapperImpl;
    //查詢所有會議室
    @Override
    public List<Room> fendRoomAll() {
        return roomMapperImpl.selectRoomAll();
    }
}
