package com.hddx.pojo;

public class TableDemo {
    private int id;
    private  String proName;
    private  String comName;
    private  int order;
    private  String proDesc;
    private  boolean status;

    //有参构造器


    public TableDemo(int id, String proName, String comName, int order, String proDesc, boolean status) {
        this.id = id;
        this.proName = proName;
        this.comName = comName;
        this.order = order;
        this.proDesc = proDesc;
        this.status = status;
    }
    //无参构造器


    @Override
    public String toString() {
        return "TableDemo{" +
                "id=" + id +
                ", proName='" + proName + '\'' +
                ", comName='" + comName + '\'' +
                ", order=" + order +
                ", proDesc='" + proDesc + '\'' +
                ", status=" + status +
                '}';
    }

    public TableDemo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getProDesc() {
        return proDesc;
    }

    public void setProDesc(String proDesc) {
        this.proDesc = proDesc;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
