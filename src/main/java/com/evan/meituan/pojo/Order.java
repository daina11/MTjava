package com.evan.meituan.pojo;

import javax.persistence.*;

@Entity
@Table(name="order")
public class Order {
  @Id
  @Column(name = "id")
  private long id;
  private long uid;
  private String time;
  private long status;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getUid() {
    return uid;
  }

  public void setUid(long uid) {
    this.uid = uid;
  }


  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }


  public long getStatus() {
    return status;
  }

  public void setStatus(long status) {
    this.status = status;
  }

}
