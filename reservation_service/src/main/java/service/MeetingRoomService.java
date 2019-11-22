package service;

import bean.Meetingroom;
import dao.MeetingroomDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MeetingRoomService {
    @Autowired
    private MeetingroomDao meetingroomDao;
    public List<Meetingroom> findall(){
      return  meetingroomDao.findall();
    }
    public void update(Meetingroom meetingroom){
        meetingroomDao.update(meetingroom);
    }
    public  Meetingroom findById( int id){
        return  meetingroomDao.findById(id);
    }

}
