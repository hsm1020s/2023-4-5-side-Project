//package com.fastcampus.ch4.domain;
//
//import java.util.Date;
//import java.util.Objects;
//
//public class User1 {
//    private String cust_id;
//    private String pwd;
//    private String name;
//    private String mpno;
//    private String cust_tp;
//    private String grade;
//    private String stus;
//    private String rcmdr;
//    private Date birth;
//    private String email;
//    private Date reg_date;
//    private String acno;
//    private Date lgin_dttm;
//    private String gender;
//    private String regn;
//    private Date fst_reg;
//    private String fst_regr;
//    private Date last_upd;
//    private String last_updr;
//
//
//    public User1(){};
//
//    public User1(String cust_id, String pwd, String name, String mpno, String cust_tp, String grade, String stus, String rcmdr, Date birth, String email, Date reg_date, String acno, Date lgin_dttm, String gender, String regn, Date fst_reg, String fst_regr, Date last_upd, String last_updr) {
//        this.cust_id = cust_id;
//        this.pwd = pwd;
//        this.name = name;
//        this.mpno = mpno;
//        this.cust_tp = cust_tp;
//        this.grade = grade;
//        this.stus = stus;
//        this.rcmdr = rcmdr;
//        this.birth = birth;
//        this.email = email;
//        this.reg_date = reg_date;
//        this.acno = acno;
//        this.lgin_dttm = lgin_dttm;
//        this.gender = gender;
//        this.regn = regn;
//        this.fst_reg = fst_reg;
//        this.fst_regr = fst_regr;
//        this.last_upd = last_upd;
//        this.last_updr = last_updr;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        User1 user1 = (User1) o;
//        return Objects.equals(cust_id, user1.cust_id) && Objects.equals(pwd, user1.pwd) && Objects.equals(name, user1.name) && Objects.equals(mpno, user1.mpno) && Objects.equals(cust_tp, user1.cust_tp) && Objects.equals(grade, user1.grade) && Objects.equals(stus, user1.stus) && Objects.equals(rcmdr, user1.rcmdr) && Objects.equals(birth, user1.birth) && Objects.equals(email, user1.email) && Objects.equals(reg_date, user1.reg_date) && Objects.equals(acno, user1.acno) && Objects.equals(lgin_dttm, user1.lgin_dttm) && Objects.equals(gender, user1.gender) && Objects.equals(regn, user1.regn) && Objects.equals(fst_reg, user1.fst_reg) && Objects.equals(fst_regr, user1.fst_regr) && Objects.equals(last_upd, user1.last_upd) && Objects.equals(last_updr, user1.last_updr);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(cust_id, pwd, name, mpno, cust_tp, grade, stus, rcmdr, birth, email, reg_date, acno, lgin_dttm, gender, regn, fst_reg, fst_regr, last_upd, last_updr);
//    }
//
//    @Override
//    public String toString() {
//        return "User1{" +
//                "cust_id='" + cust_id + '\'' +
//                ", pwd='" + pwd + '\'' +
//                ", name='" + name + '\'' +
//                ", mpno='" + mpno + '\'' +
//                ", cust_tp='" + cust_tp + '\'' +
//                ", grade='" + grade + '\'' +
//                ", stus='" + stus + '\'' +
//                ", rcmdr='" + rcmdr + '\'' +
//                ", birth=" + birth +
//                ", email='" + email + '\'' +
//                ", reg_date=" + reg_date +
//                ", acno='" + acno + '\'' +
//                ", lgin_dttm=" + lgin_dttm +
//                ", gender='" + gender + '\'' +
//                ", regn='" + regn + '\'' +
//                ", fst_reg=" + fst_reg +
//                ", fst_regr='" + fst_regr + '\'' +
//                ", last_upd=" + last_upd +
//                ", last_updr='" + last_updr + '\'' +
//                '}';
//    }
//
//    public String getCust_id() {
//        return cust_id;
//    }
//
//    public void setCust_id(String cust_id) {
//        this.cust_id = cust_id;
//    }
//
//    public String getPwd() {
//        return pwd;
//    }
//
//    public void setPwd(String pwd) {
//        this.pwd = pwd;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getMpno() {
//        return mpno;
//    }
//
//    public void setMpno(String mpno) {
//        this.mpno = mpno;
//    }
//
//    public String getCust_tp() {
//        return cust_tp;
//    }
//
//    public void setCust_tp(String cust_tp) {
//        this.cust_tp = cust_tp;
//    }
//
//    public String getGrade() {
//        return grade;
//    }
//
//    public void setGrade(String grade) {
//        this.grade = grade;
//    }
//
//    public String getStus() {
//        return stus;
//    }
//
//    public void setStus(String stus) {
//        this.stus = stus;
//    }
//
//    public String getRcmdr() {
//        return rcmdr;
//    }
//
//    public void setRcmdr(String rcmdr) {
//        this.rcmdr = rcmdr;
//    }
//
//    public Date getBirth() {
//        return birth;
//    }
//
//    public void setBirth(Date birth) {
//        this.birth = birth;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public Date getReg_date() {
//        return reg_date;
//    }
//
//    public void setReg_date(Date reg_date) {
//        this.reg_date = reg_date;
//    }
//
//    public String getAcno() {
//        return acno;
//    }
//
//    public void setAcno(String acno) {
//        this.acno = acno;
//    }
//
//    public Date getLgin_dttm() {
//        return lgin_dttm;
//    }
//
//    public void setLgin_dttm(Date lgin_dttm) {
//        this.lgin_dttm = lgin_dttm;
//    }
//
//    public String getGender() {
//        return gender;
//    }
//
//    public void setGender(String gender) {
//        this.gender = gender;
//    }
//
//    public String getRegn() {
//        return regn;
//    }
//
//    public void setRegn(String regn) {
//        this.regn = regn;
//    }
//
//    public Date getFst_reg() {
//        return fst_reg;
//    }
//
//    public void setFst_reg(Date fst_reg) {
//        this.fst_reg = fst_reg;
//    }
//
//    public String getFst_regr() {
//        return fst_regr;
//    }
//
//    public void setFst_regr(String fst_regr) {
//        this.fst_regr = fst_regr;
//    }
//
//    public Date getLast_upd() {
//        return last_upd;
//    }
//
//    public void setLast_upd(Date last_upd) {
//        this.last_upd = last_upd;
//    }
//
//    public String getLast_updr() {
//        return last_updr;
//    }
//
//    public void setLast_updr(String last_updr) {
//        this.last_updr = last_updr;
//    }
//}
