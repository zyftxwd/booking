package dao;

import bean.Orderform;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderformDao {
    @Select("select * from orderform")
    List<Orderform> findall();
    @Insert("insert into orderform values(null,#{ordertime},#{mid},#{starttime},#{endtime},#{payment})")
    void add(Orderform orderform);
    @Select("select * from orderform where mid=#{mid}")
    List<Orderform>findByMid(Integer mid);
}
