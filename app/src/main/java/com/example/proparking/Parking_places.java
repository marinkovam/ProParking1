package com.example.proparking;

public class Parking_places {
    private int id;
    private String parking_name;
    private String city_name;
    private String free;
    private String taken;
    private String latitude;
    private String longitude;
    public Parking_places(int id, String parking_name, String city_name,String free, String taken,String latitude,String longitude){
        this.id=id;
        this.parking_name=parking_name;
        this.city_name=city_name;
        this.free=free;
        this.taken=taken;
        this.latitude=latitude;
        this.longitude=longitude;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getParkingName() {
        return parking_name;
    }
    public void setParkingName(String parking_name) {
        this.parking_name = parking_name;
    }
    public String getCityName() {
        return city_name;
    }
    public void setCityName(String city_name) {
        this.city_name = city_name;
    }
    public String getFree() {
        return free;
    }
    public void setFree(String free) {
        this.free = free;
    }
    public String getTaken() {
        return taken;
    }
    public void setTaken(String taken) {
        this.taken = taken;
    }
    public String getLatitude() {
        return latitude;
    }
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
    public String getLongitude() {
        return longitude;
    }
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

}
