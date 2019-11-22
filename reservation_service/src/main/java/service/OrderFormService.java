package service;

import bean.Orderform;
import bean.Page;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.OrderformDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class OrderFormService {
    @Autowired
    private JedisPool jedisPool;
    @Autowired
    private OrderformDao orderformDao;

    public List<Orderform> find() {
        return orderformDao.findall();
    }

    public List<Orderform> findByMidsql(Integer mid) {
        List<Orderform> mid1 = orderformDao.findByMid(mid);
        return mid1;

    }

    public void add(Orderform orderform) {
        orderformDao.add(orderform);
    }

    public void addredis(Orderform orderform) {
        Jedis jedis = jedisPool.getResource();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String value = objectMapper.writeValueAsString(orderform);
            String uuid = UUID.randomUUID().toString();
            jedis.setex(uuid + orderform.getMid(), 50, value);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public List<Page> findNonPayment() {
        List<Page> list = new ArrayList<>();
        Jedis jedis = jedisPool.getResource();
        ObjectMapper objectMapper = new ObjectMapper();
        Set<String> keys = jedis.keys("*");
        for (String k : keys
        ) {
            String s = jedis.get(k);
            try {
                Orderform orderform = objectMapper.readValue(s, Orderform.class);
                Page page = new Page();
                page.setOrderform(orderform);
                page.setUuid(k);
                list.add(page);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return list;

    }

    public Orderform findbyuuid(String uuid) {
        Jedis jedis = jedisPool.getResource();
        ObjectMapper objectMapper = new ObjectMapper();
        String s = jedis.get(uuid);
        Orderform orderform = null;
        try {
            orderform = objectMapper.readValue(s, Orderform.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return orderform;
    }

    public void delete(String uuid) {
        Jedis jedis = jedisPool.getResource();
        if(uuid!=null){
            jedis.del(uuid);
        }

    }

    public List<Orderform> findByMid(Integer mid) {
        List<Orderform> orderforms = orderformDao.findByMid(mid);
        ObjectMapper objectMapper = new ObjectMapper();
        Jedis jedis = jedisPool.getResource();
        Set<String> keys = jedis.keys("*");
        if (keys.size()!=0){
        for (String k : keys) {
            String s = k.substring(k.length() - mid.toString().length());
            if (Integer.parseInt(s) == mid) {
                System.out.println(s);
                String s1 = jedis.get(k);
                try {
                    Orderform orderform = objectMapper.readValue(s1, Orderform.class);
                    orderforms.add(orderform);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }}

        return orderforms;
    }
    public Boolean isdate(Orderform orderform){
        Boolean b=true;

        List<Orderform> orderforms = findByMid(orderform.getMid());
        for (Orderform o:orderforms
             ) {
          if(orderform.getStarttime().after(o.getEndtime())||orderform.getEndtime().before(o.getStarttime())){
              b= true;

           }else {
               b= false;
            }
        }
       return b;
    }
}
