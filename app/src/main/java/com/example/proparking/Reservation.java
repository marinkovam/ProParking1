package com.example.proparking;

public class Reservation {
    private int id;
    private String user_name;
    private String city_name;
    private String date;
    private String time;
    private String parking_name;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUserName() {
        return user_name;
    }
    public void setUserName(String user_name) {
        this.user_name = user_name;
    }
    public String getCityName() {
        return city_name;
    }
    public void setCityName(String city_name) {
        this.city_name = city_name;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getParkingName() {
        return parking_name;
    }
    public void setParkingName(String parking_name) {
        this.parking_name = parking_name;
    }
}

