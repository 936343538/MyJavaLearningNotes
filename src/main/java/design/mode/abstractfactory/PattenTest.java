package design.mode.abstractfactory;

/**
 * @author hongzf
 * @date 2020/6/25
 */
public class PattenTest {
    public static void main(String[] args) {
        //苹果工厂
        AbstractTechFactory appleTechCompany = new AppleTechCompany();
        //AirPod
        AbstractEarPhone appEarPhone = appleTechCompany.sellEarPhone();
        appEarPhone.describe();
        //MacBookPro
        AbstractLaptop appLaptop = appleTechCompany.sellLaptop();
        appLaptop.describe();
        //IPhone
        AbstractPhone appPhone = appleTechCompany.sellPhone();
        appPhone.describe();

        //华为工厂
        AbstractTechFactory huaweiTechCompany = new HuaweiTechCompany();
        //华为耳机
        AbstractEarPhone earPhone = huaweiTechCompany.sellEarPhone();
        earPhone.describe();
        //华为笔记本
        AbstractLaptop laptop = huaweiTechCompany.sellLaptop();
        laptop.describe();
        //华为手机
        AbstractPhone phone = huaweiTechCompany.sellPhone();
        phone.describe();

        //小米工厂
        MiTechCompany miTechCompany = new MiTechCompany();
        //小米耳机
        AbstractEarPhone miEarPhone = miTechCompany.sellEarPhone();
        miEarPhone.describe();
        //小米笔记本
        AbstractLaptop miLatop = miTechCompany.sellLaptop();
        miLatop.describe();
        //小米手机
        AbstractPhone miPhone = miTechCompany.sellPhone();
        miPhone.describe();

    }
}
