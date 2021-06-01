package com.evan.meituan.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name="goodslist")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Goodslist {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;
  private String name;
  private double price;
  private int store;
  private int sid;
  private int cid;
  private String goodimg;

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

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public int getStore() {
    return store;
  }

  public void setStore(int store) {
    this.store = store;
  }

  public int getSid() {
    return sid;
  }

  public void setSid(int sid) {
    this.sid = sid;
  }

  public int getCid() {
    return cid;
  }

  public void setCid(int cid) {
    this.cid = cid;
  }

  public String getGoodimg() {
    return goodimg;
  }

  public void setGoodimg(String goodimg) {
    this.goodimg = goodimg;
  }

  public int getScid() {
    return scid;
  }

  public void setScid(int scid) {
    this.scid = scid;
  }

  private int scid;


}
