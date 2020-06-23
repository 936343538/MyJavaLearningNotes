package webmagic;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;
import model.Address;
import utils.PinyinUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 爬取类
 * 框架介绍链接 http://webmagic.io/docs/zh/
 *
 * @author hongzf
 * @date 2020/6/7
 */
public class MyProcessor implements PageProcessor {

    public static void main(String[] args) {
        Spider.create(new MyProcessor())
                //添加抓取页面网址
                .addUrl("http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2019/50.html")
                //开启5个线程抓取
//                .thread(5)
                //使用json格式保存数据
//                .addPipeline(new JsonFilePipeline("D:\\demo.txt"))
                //自定义类实现 Pipeline 接口
                .addPipeline(new MyPipeline())
                //启动，会阻塞当前线程执行
                .run();
    }

    /**
     * process是定制爬虫逻辑的核心接口，在这里编写抽取逻辑
     * @param page
     */
    @Override
    public void process(Page page) {


        // 部分二：定义如何抽取页面信息，并保存下来

//        System.out.println(page.getHtml().xpath("/html/body/table[1]/tbody/tr/td").css("img","src"));

        //当通过浏览器拷贝的 xpath 输出为'null'时,可以先不 .xpath ,直接打印 page.getHtml() ,复制打印出来的数据在idea中新建一个
        //html文件,然后通过idea右上角的窗口打开浏览器,再用浏览器拷贝 xpath 即可
        //<tr class="towntr"><td><a href="03/350203001.html">350203001000</a></td><td><a href="03/350203001.html">厦港街道</a></td></tr>
        //1:<tr class="citytr"><td><a href="35/3501.html">350100000000</a></td><td><a href="35/3501.html">福州市</a></td></tr>
        //2.<tr class="countytr"><td><a href="02/350203.html">350203000000</a></td><td><a href="02/350203.html">思明区</a></td></tr>
        //3.<tr class="towntr"><td><a href="03/350203003.html">350203003000</a></td><td><a href="03/350203003.html">中华街道</a></td></tr>
        //4.<tr class="villagetr"><td>350203003001</td><td>111</td><td>仁安社区居委会</td></tr>
        //villagetr 8
        //towntr    9
        //countytr  10
        //citytr    11
        int i = page.getUrl().get().split("/").length;
        String className;
        switch (i) {
            case 11:
                className = "villagetr";
                break;
            case 10:
                className = "towntr";
                break;
            case 9:
                className = "countytr";
                break;
            case 8:
                className = "citytr";
                break;
            default:
                className = "";
        }
        List<Selectable> nodes = page.getHtml().xpath("//tr[@class='" + className + "']").nodes();
        String s = "a/";
        int index = 2;
        if (i == 11) {
            index = 3;
            s = "";
        }
        List<Address> addressList = new ArrayList<Address>();
        for (Selectable node : nodes) {
            String code = node.xpath("//td[1]/" + s + "text()|//td[1]/text()").get();
            String name = node.xpath("//td[" + index + "]/" + s + "text()|//td[" + index + "]/text()").get();
            if (code == null || name == null) {
                page.setSkip(true);
                System.err.println(node);
                continue;
            }
            Address address = this.getAddress(code, name);
            addressList.add(address);
            page.putField("addressList", addressList);
//            System.out.println(code + " : " + name);
        }

        //部分三：从页面发现后续的url地址来抓取
        List<String> urlList = page.getHtml().links().regex("http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2019/.*\\.html").all();
        page.addTargetRequests(urlList);
    }

    /**
     * 数据处理
     *
     * @param code
     * @param name
     * @return
     */
    private Address getAddress(String code, String name) {
        Address address = new Address();
        address.setBfRegionId(code);
        address.setLocalName(name);
        address.setAreaNum(code);
        address.setDataState("1");
        addressBuild(address);
        return address;
    }

    private void addressBuild(Address address) {
        String code = address.getBfRegionId();
        String ex = "1";
        String pid = "";
        String pids = ",";
        long integer = Long.parseLong(code);
        long n = 1000;
        long i = integer % (n);
        long i2 = integer / n * n;
        for (int j = 4; j > 0; j--) {
            if (i > 0) {
                ex = "" + (j + 1);
                pid = i2 + "";
                pids = getPid(pid, ex);
                break;
            } else {
                if (j == 4) {
                    n = 1000000;
                } else if (j == 3) {
                    n = 100000000;
                } else if (j == 2) {
                    n = 1000000000;
                }
                i = integer % n;
                i2 = integer / n * n;
            }
        }

        address.setPRegionId(pid);
        address.setRegionGrade(ex);
        address.setRegionPath(pids+address.getBfRegionId()+",");
        String name = PinyinUtils.getFirstCharacterInitials(address.getLocalName());
        address.setSortName(name);
    }

    private static String getPid(String pid, String ex) {
        if ("2".equals(ex)) {
            return "," + pid + ",";
        } else if ("3".equals(ex)) {
            return "," + pid.substring(0, 3) + "00000000" + "," + pid + ",";
        } else if ("4".equals(ex)) {
            return "," + pid.substring(0, 3) + "00000000," + pid.substring(0, 4) + "00000000" + "," + pid + ",";
        } else {
            return "," + pid.substring(0, 3) + "00000000," + pid.substring(0, 4) + "00000000," + pid.substring(0, 6)+"000000," + pid + ",";
        }
    }



    /**
     * setCharset(String)	    设置编码	site.setCharset("utf-8")
     * setUserAgent(String)	    设置UserAgent	site.setUserAgent("Spider")
     * setTimeOut(int)	        设置超时时间，单位是毫秒	site.setTimeOut(3000)
     * setRetryTimes(int)	    设置重试次数	site.setRetryTimes(3)
     * setCycleRetryTimes(int)	设置循环重试次数	site.setCycleRetryTimes(3)
     * addCookie(String,String)	添加一条cookie	site.addCookie("dotcomt_user","code4craft")
     * setDomain(String)	    设置域名，需设置域名后，addCookie才可生效	site.setDomain("github.com")
     * addHeader(String,String)	添加一条addHeader	site.addHeader("Referer","https://github.com")
     * setHttpProxy(HttpHost)	设置Http代理	site.setHttpProxy(new HttpHost("127.0.0.1",8080))
     * 其中循环重试 cycleRetry 是 0.3.0 版本加入的机制。
     * 该机制会将下载失败的url重新放入队列尾部重试，直到达到重试次数，以保证不因为某些网络原因漏抓页面。
     *
     * @return
     */
    @Override
    public Site getSite() {
        //gb2312  只能表示简体中文。如果将 gb2312 的字体串转化为 UTF-8 的字符串，繁体中文是会乱码的。解决方案是先将 gb2312 转化为 GBK 编码，再转化为 UTF-8 编码。
        //GBK 是 gb2312 的超集，它兼容 gb2312 编码，同时还包括繁体中文编码。因为idea设置的字符编码是utf-8,所以idea输出gb2312的中文会出现乱乱码
        return Site.me()
                //设置休眠时间单位毫秒
                .setSleepTime(2000)
                //设置重试次数
                .setRetryTimes(3)
                //将下载失败的url重新放入队列尾部重试次数
                .setCycleRetryTimes(3)
                //设置编码,如果出现乱码,可以用浏览器打开开发者模式查看网页编码,然后通过setCharset设置,
                //例如 : <META content="text/html; charset=gb2312" http-equiv=Content-Type>
                .setCharset("GBK");
    }
}
