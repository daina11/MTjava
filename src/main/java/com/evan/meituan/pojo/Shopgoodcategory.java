package com.evan.meituan.pojo;

import javax.persistence.*;

@Entity
@Table(name="shopgoodcategory")
public class Shopgoodcategory {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;
  private String name;
  private int sid;


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public int getSid() {
    return sid;
  }

  public void setSid(int sid) {
    this.sid = sid;
  }

}
