package webmagic;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;
import model.Address;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class MyPipeline implements Pipeline {

    @Override
    public void process(ResultItems resultItems, Task task) {
        Map<String, Object> all = resultItems.getAll();
        List<Address> pojoList = (List<Address>) all.get("addressList");
        FileOutputStream fop = null;
        File file;
        String l = "\r\n";

        try {

            //将文件输出到 D:\db.txt
            file = new File("D:\\db.txt");
            //[append=true]表示将追加写入
            fop = new FileOutputStream(file,true);
            //如果文件不存在就创建文件
            if (!file.exists()) {
                file.createNewFile();
            }

            // get the content in bytes
            for (Address address : pojoList) {
                String co = "insert into bf_region (BF_REGION_ID, P_REGION_ID, REGION_PATH,REGION_GRADE, LOCAL_NAME, SORT_NAME, AREA_NUM,  DATA_STATE) values ('"+address.getBfRegionId()+"', '"+address.getpRegionId()+"', '"+address.getRegionPath()+"', '"+address.getRegionGrade()+"', '"+address.getLocalName()+"', '"+address.getSortName()+"', '"+address.getAreaNum()+"', '"+address.getDataState()+"');";
                fop.write(co.getBytes());
                fop.write(l.getBytes());
            }
            fop.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fop != null) {
                    fop.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}