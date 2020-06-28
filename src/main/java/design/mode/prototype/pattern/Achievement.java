package design.mode.prototype.pattern;

import java.io.Serializable;

/**
 * 成绩类
 */
class Achievement implements Cloneable, Serializable {
    private float Chinese;
    private float math;
    private float English;

    public Achievement(float chinese, float math, float english) {
        this.Chinese = chinese;
        this.math = math;
        this.English = english;
    }

    public void setChinese(float chinese) {
        Chinese = chinese;
    }

    public void setMath(float math) {
        this.math = math;
    }

    public void setEnglish(float english) {
        English = english;
    }

    @Override
    public String toString() {
        return "Achievement{" +
                "Chinese=" + Chinese +
                ", math=" + math +
                ", English=" + English +
                '}';
    }

    @Override
    protected Achievement clone() throws CloneNotSupportedException {
        return (Achievement) super.clone();
    }
}