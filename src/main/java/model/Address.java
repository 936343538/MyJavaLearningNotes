package model;

import lombok.Data;

/**
 * @author hongzf
 * @date 2020/6/15
 */
@Data
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
}
