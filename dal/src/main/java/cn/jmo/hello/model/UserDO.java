package cn.jmo.hello.model;

import java.io.Serializable;
import java.util.Date;

public class UserDO implements Serializable{
    private static final long serialVersionUID = 2804036393950034754L;
    private Integer id;
    private String username;
    private String password;
    private String gender;
    private Integer age;
    private Date gmtRegist = new Date();

    public void setId(Integer id){
        this.id = id;
    }
    public Integer getId(){
        return this.id;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getUsername(){
        return this.username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return this.password;
    }
    public void setGender(String gender){
        this.gender = gender;
    }
    public String getGender(){
        return this.gender;
    }
    public void setAge(Integer age){
        this.age = age;
    }
    public Integer getAge(){
        return this.age;
    }
    public void setGmtRegist(Date gmtRegist){
        this.gmtRegist = gmtRegist;
    }
    public Date getGmtRegist(){
        return this.gmtRegist;
    }
    @Override
    public String toString(){
        return "UserDO{" +
                " id = " + id + "," +
                " username = " + username + "," +
                " password = " + password + "," +
                " gender = " + gender + "," +
                " age = " + age + "," +
                " gmtRegist = " + gmtRegist + "" +
                "}";
    }
}