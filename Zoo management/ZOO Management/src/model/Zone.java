package model;

/*
 *********************************************************************************************************
 *  @Java Class Name :   Zone
 *  @Author          :   <Saurabh Rai>(saurabh.rai@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   04-07-2024
 *  @Description     :   This class is used to create a Zone.
 *********************************************************************************************************
 */

public class Zone {

    private String zoneCategory;
    private boolean hasPark;
    private boolean hasCanteen;


    public Zone(String zoneCategory, boolean hasPark, boolean hasCanteen) {
        this.zoneCategory = zoneCategory;
        this.hasPark = hasPark;
        this.hasCanteen = hasCanteen;
    }

    // GETTER
    public String getZoneCategory() {
        return zoneCategory;
    }
    public boolean isHasPark() {
        return hasPark;
    }
    public boolean isHasCanteen() {
        return hasCanteen;
    }

    // SETTER
    public void setHasCanteen(boolean hasCanteen) {
        this.hasCanteen = hasCanteen;
    }
    public void setHasPark(boolean hasPark) {
        this.hasPark = hasPark;
    }
    public void setZoneCategory(String zoneCategory) {
        this.zoneCategory = zoneCategory;
    }

}
