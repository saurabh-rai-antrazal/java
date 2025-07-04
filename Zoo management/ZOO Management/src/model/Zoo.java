package model;

/*
 *********************************************************************************************************
 *  @Java Class Name :   ZooRepo
 *  @Author          :   <Saurabh Rai>(saurabh.rai@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   04-07-2024
 *  @Description     :   This class performs CRUD operations on the Zoo table.
 *********************************************************************************************************
 */

public class Zoo {
    private int zoneCnt;
    private String name;
    private String location;
    private String ownerName;
    private String username;
    private String password;

    public Zoo (String name, String location, String ownerName, String username, String password, int zoneCnt) {
        this.name = name;
        this.location = location;
        this.ownerName = ownerName;
        this.username = username;
        this.password = password;
        this.zoneCnt = zoneCnt;
    }

    public int getZoneCnt() {
        return zoneCnt;
    }

    public void setZoneCnt(int zoneCnt) {
        this.zoneCnt = zoneCnt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}