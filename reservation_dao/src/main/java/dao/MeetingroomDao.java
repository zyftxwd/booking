package dao;

import bean.Meetingroom;
import bean.Orderform;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeetingroomDao {
    @Select("select * from meetingroom")
    List<Meetingroom> findall();
    @Update("update meetingroom set reservationStatus=#{reservationStatus} where id=#{id} ")
    void update(Meetingroom meetingroom);
    @Select("select * from meetingroom where id=#{id}")
    Meetingroom findById(int id);


}

