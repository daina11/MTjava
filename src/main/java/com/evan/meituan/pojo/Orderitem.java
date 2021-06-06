package com.evan.meituan.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="orderitem")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Orderitem {
  @Id
  @Column(name = "id")
  private int id;
  private int orderid;
  private int goodsnumber;
  private int goodsid;
  private double goodsprice;
  private double goodsamout;
  private int uid;


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public int getOrderid() {
    return orderid;
  }

  public void setOrderid(int orderid) {
    this.orderid = orderid;
  }


  public int getGoodsnumber() {
    return goodsnumber;
  }

  public void setGoodsnumber(int goodsnumber) {
    this.goodsnumber = goodsnumber;
  }


  public int getGoodsid() {
    return goodsid;
  }

  public void setGoodsid(int goodsid) {
    this.goodsid = goodsid;
  }


  public double getGoodsprice() {
    return goodsprice;
  }

  public void setGoodsprice(double goodsprice) {
    this.goodsprice = goodsprice;
  }


  public double getGoodsamout() {
    return goodsamout;
  }

  public void setGoodsamout(double goodsamout) {
    this.goodsamout = goodsamout;
  }


  public int getUid() {
    return uid;
  }

  public void setUid(int uid) {
    this.uid = uid;
  }

}
