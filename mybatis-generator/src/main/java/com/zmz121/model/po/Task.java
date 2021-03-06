package com.zmz121.model.po;

import java.math.BigDecimal;
import java.util.Date;

public class Task {
    private Long id;

    private Long publicUserId;

    private String school;

    private String title;

    private String content;

    private String tel;

    private String destination;

    private String productLocation;

    private String comment;

    private Byte isDaigou;

    private BigDecimal daigouPrice;

    private BigDecimal taskPrice;

    private Date publicDate;

    private Date modifDate;

    private Date expireDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPublicUserId() {
        return publicUserId;
    }

    public void setPublicUserId(Long publicUserId) {
        this.publicUserId = publicUserId;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination == null ? null : destination.trim();
    }

    public String getProductLocation() {
        return productLocation;
    }

    public void setProductLocation(String productLocation) {
        this.productLocation = productLocation == null ? null : productLocation.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public Byte getIsDaigou() {
        return isDaigou;
    }

    public void setIsDaigou(Byte isDaigou) {
        this.isDaigou = isDaigou;
    }

    public BigDecimal getDaigouPrice() {
        return daigouPrice;
    }

    public void setDaigouPrice(BigDecimal daigouPrice) {
        this.daigouPrice = daigouPrice;
    }

    public BigDecimal getTaskPrice() {
        return taskPrice;
    }

    public void setTaskPrice(BigDecimal taskPrice) {
        this.taskPrice = taskPrice;
    }

    public Date getPublicDate() {
        return publicDate;
    }

    public void setPublicDate(Date publicDate) {
        this.publicDate = publicDate;
    }

    public Date getModifDate() {
        return modifDate;
    }

    public void setModifDate(Date modifDate) {
        this.modifDate = modifDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }
}