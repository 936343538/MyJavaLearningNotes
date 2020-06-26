package design.mode.abstractfactory;

/**
 * 小米品牌小米手机具体实现
 */
class MiPhone extends AbstractPhone {
    /**
     * 描述
     */
    @Override
    public void describe() {
        System.out.println("小米手机");
    }
}

/**
 * 小米品牌小米笔记本具体实现
 */
class MiLaptop extends AbstractLaptop {
    /**
     * 描述
     */
    @Override
    public void describe() {
        System.out.println("小米笔记本");
    }
}

/**
 * 小米品牌小米耳机具体实现
 */
class MiEarPhone extends AbstractEarPhone {
    /**
     * 描述
     */
    @Override
    public void describe() {
        System.out.println("小米耳机");
    }
}

/**
 * 小米公司工厂具体实现
 */
class MiTechCompany extends AbstractTechFactory {
    /**
     * 卖手机
     *
     * @return 手机
     */
    @Override
    public AbstractPhone sellPhone() {
        return new MiPhone();
    }

    /**
     * 卖笔记本
     *
     * @return 笔记本
     */
    @Override
    public AbstractLaptop sellLaptop() {
        return new MiLaptop();
    }

    /**
     * 卖耳机
     *
     * @return 耳机
     */
    @Override
    public AbstractEarPhone sellEarPhone() {
        return new MiEarPhone();
    }
}

/**
 * 华为品牌华为手机具体实现
 */
class HuaweiPhone extends AbstractPhone {
    /**
     * 描述
     */
    @Override
    public void describe() {
        System.out.println("华为手机");
    }
}

/**
 * 华为品牌华为笔记本具体实现
 */
class HuaweiLaptop extends AbstractLaptop {
    /**
     * 描述
     */
    @Override
    public void describe() {
        System.out.println("华为笔记本");
    }
}

/**
 * 华为品牌华为耳机具体实现
 */
class HuaweiEarPhone extends AbstractEarPhone {
    /**
     * 描述
     */
    @Override
    public void describe() {
        System.out.println("华为耳机");
    }
}

/**
 * 华为公司工厂具体实现
 */
class HuaweiTechCompany extends AbstractTechFactory {
    /**
     * 卖手机
     *
     * @return 手机
     */
    @Override
    public AbstractPhone sellPhone() {
        return new HuaweiPhone();
    }

    /**
     * 卖笔记本
     *
     * @return 笔记本
     */
    @Override
    public AbstractLaptop sellLaptop() {
        return new HuaweiLaptop();
    }

    /**
     * 卖耳机
     *
     * @return 耳机
     */
    @Override
    public AbstractEarPhone sellEarPhone() {
        return new HuaweiEarPhone();
    }
}

/**
 * 苹果品牌苹果手机具体实现
 */
class IPhone extends AbstractPhone {
    /**
     * 描述
     */
    @Override
    public void describe() {
        System.out.println("IPhone");
    }
}

/**
 * 苹果品牌苹果笔记本具体实现
 */
class MacBookPro extends AbstractLaptop {
    /**
     * 描述
     */
    @Override
    public void describe() {
        System.out.println("MacBookPro");
    }
}

/**
 * 苹果品牌苹果耳机具体实现
 */
class AirPod extends AbstractEarPhone {
    /**
     * 描述
     */
    @Override
    public void describe() {
        System.out.println("AirPod");
    }
}

/**
 * 苹果公司工厂具体实现
 */
class AppleTechCompany extends AbstractTechFactory {
    /**
     * 卖手机
     *
     * @return 手机
     */
    @Override
    public AbstractPhone sellPhone() {
        return new IPhone();
    }

    /**
     * 卖笔记本
     *
     * @return 笔记本
     */
    @Override
    public AbstractLaptop sellLaptop() {
        return new MacBookPro();
    }

    /**
     * 卖耳机
     *
     * @return 耳机
     */
    @Override
    public AbstractEarPhone sellEarPhone() {
        return new AirPod();
    }
}