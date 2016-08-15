package com.itgary.pro3.spring.mybatis.entity;

public class TradeInfo {
    private String pid;

    private String orderno;

    private String ordertime;

    private String cardno;

    private String userid;

    private String tradeno;

    private String tradetype;

    private String actionno;

    private String instcode;

    private String channleno;

    private String brhid;

    private String merid;

    private Integer tradeamt;

    private String accoinfo;

    private String tradesta;

    private String tradedate;

    private String orgtradeno;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno == null ? null : orderno.trim();
    }

    public String getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime == null ? null : ordertime.trim();
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno == null ? null : cardno.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getTradeno() {
        return tradeno;
    }

    public void setTradeno(String tradeno) {
        this.tradeno = tradeno == null ? null : tradeno.trim();
    }

    public String getTradetype() {
        return tradetype;
    }

    public void setTradetype(String tradetype) {
        this.tradetype = tradetype == null ? null : tradetype.trim();
    }

    public String getActionno() {
        return actionno;
    }

    public void setActionno(String actionno) {
        this.actionno = actionno == null ? null : actionno.trim();
    }

    public String getInstcode() {
        return instcode;
    }

    public void setInstcode(String instcode) {
        this.instcode = instcode == null ? null : instcode.trim();
    }

    public String getChannleno() {
        return channleno;
    }

    public void setChannleno(String channleno) {
        this.channleno = channleno == null ? null : channleno.trim();
    }

    public String getBrhid() {
        return brhid;
    }

    public void setBrhid(String brhid) {
        this.brhid = brhid == null ? null : brhid.trim();
    }

    public String getMerid() {
        return merid;
    }

    public void setMerid(String merid) {
        this.merid = merid == null ? null : merid.trim();
    }

    public Integer getTradeamt() {
        return tradeamt;
    }

    public void setTradeamt(Integer tradeamt) {
        this.tradeamt = tradeamt;
    }

    public String getAccoinfo() {
        return accoinfo;
    }

    public void setAccoinfo(String accoinfo) {
        this.accoinfo = accoinfo == null ? null : accoinfo.trim();
    }

    public String getTradesta() {
        return tradesta;
    }

    public void setTradesta(String tradesta) {
        this.tradesta = tradesta == null ? null : tradesta.trim();
    }

    public String getTradedate() {
        return tradedate;
    }

    public void setTradedate(String tradedate) {
        this.tradedate = tradedate == null ? null : tradedate.trim();
    }

    public String getOrgtradeno() {
        return orgtradeno;
    }

    public void setOrgtradeno(String orgtradeno) {
        this.orgtradeno = orgtradeno == null ? null : orgtradeno.trim();
    }
}