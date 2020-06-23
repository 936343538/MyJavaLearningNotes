package model;

/**
 * @author hongzf
 * @date 2020/6/15
 */

public class Address {
    /**
     * ID 与地区编码一致
     */
    private String bfRegionId;
    /**
     * 父ID
     */
    private String pRegionId;
    /**
     * 路径
     */
    private String regionPath;
    /**
     * 级别
     */
    private String regionGrade;
    /**
     * 地名
     */
    private String localName;
    /**
     * 首字母
     */
    private String sortName;
    /**
     * 地区编码
     */
    private String areaNum;
    /**
     * 数据状态
     */
    private String dataState = "1";

    //BF_REGION_ID
    //P_REGION_ID
    //REGION_PATH
    //REGION_GRADE
    //LOCAL_NAME
    //SORT_NAME
    //AREA_NUM
    //DATA_STATE

    public String getBfRegionId() {
        return bfRegionId;
    }

    public void setBfRegionId(String bfRegionId) {
        this.bfRegionId = bfRegionId;
    }

    public String getpRegionId() {
        return pRegionId;
    }

    public void setpRegionId(String pRegionId) {
        this.pRegionId = pRegionId;
    }

    public String getRegionPath() {
        return regionPath;
    }

    public void setRegionPath(String regionPath) {
        this.regionPath = regionPath;
    }

    public String getRegionGrade() {
        return regionGrade;
    }

    public void setRegionGrade(String regionGrade) {
        this.regionGrade = regionGrade;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public String getAreaNum() {
        return areaNum;
    }

    public void setAreaNum(String areaNum) {
        this.areaNum = areaNum;
    }

    public String getDataState() {
        return dataState;
    }

    public void setDataState(String dataState) {
        this.dataState = dataState;
    }

    @Override
    public String toString() {
        return "Address{" +
                "bfRegionId='" + bfRegionId + '\'' +
                ", pRegionId='" + pRegionId + '\'' +
                ", regionPath='" + regionPath + '\'' +
                ", regionGrade='" + regionGrade + '\'' +
                ", localName='" + localName + '\'' +
                ", sortName='" + sortName + '\'' +
                ", areaNum='" + areaNum + '\'' +
                ", dataState='" + dataState + '\'' +
                '}';
    }
}
