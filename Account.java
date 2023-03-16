package com.pojo;

public class Account {
    private  int id;
    private  String jname;// 和表名一一对应

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJname() {
        return jname;
    }

    public void setJname(String jname) {
        this.jname = jname;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", jname='" + jname + '\'' +
                '}';
    }
}
