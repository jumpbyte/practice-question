package com.github.jumpbyte.practice.uml;

/**
 * 学生
 * @className: Student
 * @author: yuanjinan
 * @create: 2018/11/08
 **/
public class Student {

    private IdCard idCard;

    /**
     * 上学
     */
    public void  gotoSchool(Bike bike){
        bike.run();
    }

    public IdCard getIdCard() {
        return idCard;
    }

    public void setIdCard(IdCard idCard) {
        this.idCard = idCard;
    }
}
