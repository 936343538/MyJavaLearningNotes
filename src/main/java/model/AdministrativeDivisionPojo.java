package model;

/**
 * @author hongzf
 * @date 2020/6/7
 */
public class AdministrativeDivisionPojo {
    /**
     * 行政区划
     */
    private String name;
    /**
     * 名称
     */
    private String coder;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoder() {
        return coder;
    }

    public void setCoder(String coder) {
        this.coder = coder;
    }

    @Override
    public String toString() {
        return "AdministrativeDivisionPojo{" +
                "name='" + name + '\'' +
                ", coder='" + coder + '\'' +
                '}';
    }
}
