package bean;

import java.util.Date;

public class Orderform {
    private  int id;
    private Date ordertime;
    private Integer mid;
    private  Date starttime;
    private Date endtime;
    private  String payment;

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    @Override
    public String toString() {
        return "Orderform{" +
                "id=" + id +
                ", ordertime=" + ordertime +
                ", mid='" + mid + '\'' +
                ", starttime=" + starttime +
                ", endtime=" + endtime +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }


    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }
}
