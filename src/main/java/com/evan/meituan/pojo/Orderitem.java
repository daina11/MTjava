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
  private int goodsnumber;
  private int goodsid;
  private double goodsprice;
  private double goodsamout;
  private int uid;
  private  String goodname;
  private  int status;

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public String getGoodname() {
    return goodname;
  }

  public void setGoodname(String goodname) {
    this.goodname = goodname;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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
