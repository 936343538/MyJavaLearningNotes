package webmagic;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.List;
import java.util.Map;

public class MyPipeline implements Pipeline {

    @Override
    public void process(ResultItems resultItems, Task task) {
        Map<String, Object> all = resultItems.getAll();
        List<AdministrativeDivisionPojo> pojoList = (List<AdministrativeDivisionPojo>) all.get("pojoList");
        for (AdministrativeDivisionPojo pojo : pojoList) {
            System.out.println(pojo.getCoder() + ":" + pojo.getName());
        }
//        for (Map.Entry<String, Object> entry : resultItems.getAll().entrySet()) {
//            System.out.println(entry.getKey() + ":\t" + entry.getValue());
//            List<AdministrativeDivisionPojo> pojoList = (List<AdministrativeDivisionPojo>) entry.getValue();
//        }
    }
}