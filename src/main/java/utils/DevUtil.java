package utils;

import cn.hutool.core.collection.IterUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.swing.clipboard.ClipboardUtil;
import cn.hutool.core.util.ClassLoaderUtil;
import cn.hutool.core.util.StrUtil;

import java.lang.reflect.Field;
import java.util.*;

/**
 * 开发工具类
 *
 * @author zhifa.hong
 * @since 2022/1/5 15:51
 */
public class DevUtil {

    /**
     * 包前缀
     */
    private static final String packetPrefix = "model.";
    /**
     * entity包绝对路径
     */
    private static final String classPath = "/Users/zhifa/IdeaProjects/MyJavaLearningNotes/src/main/java/model";

    public static void main(String[] args) {
        String sql = "SERVICE_DISTANCE,\n" +
                "        APPT.ID,\n" +
                "        APPT.USER_ID,\n" +
                "        APPT.USER_NAME,\n" +
                "        APPT.SERVICE_WARE_ID,\n" +
                "        APPT.SERVICE_WARE_CODE,\n" +
                "        APPT.SERVICE_WARE_NAME,\n" +
                "        APPT.SERVICE_SUBSIDY_PRICE,\n" +
                "        APPT.APPLY_SERVICE_COUNT,\n" +
                "        APPT.SERVICE_WARE_PRICE,\n" +
                "        APPT.TOTAL_SERVICE_WARE_PRICE,\n" +
                "        APPT.APPLY_SERVICE_DATE,\n" +
                "        APPT.SERVICE_MODE,\n" +
                "        APPT.SERVICE_ADDRESS,\n" +
                "        APPT.SERVICE_TYPE_ID,\n" +
                "        APPT.SERVICE_TYPE_TITLE,\n" +
                "        APPT.ORDER_NO,\n" +
                "        APPT.LNG,\n" +
                "        APPT.LAT,\n" +
                "        APPT.UNIT_CN_NAME,\n" +
                "        APPT.TEL,\n" +
                "        APPT.ORDER_STATE,\n" +
                "        APPT.GMT_CREATE";

        sqlToJavaBean(sql);

    }

    /**
     * sql语句转javaBean并复制到剪切板
     *
     * @param sql sql中select 和 form 中间的查询字段
     */
    public static void sqlToJavaBean(String sql) {
        List<String> split = StrUtil.split(sql, ',', true, true);
        StringBuffer builder = new StringBuffer();
        split.forEach(s -> {
            List<String> a = StrUtil.split(s, ' ');
            List<String> b = StrUtil.split(a.get(a.size() - 1), '.', true, true);
            String c = StrUtil.toCamelCase(b.get(b.size() - 1).toLowerCase(Locale.ROOT));
            Set<String> strings = map.get(c);
            String d;
            if (IterUtil.isEmpty(strings)) {
                d = StrUtil.format("private String {};", c);
            } else {
                d = StrUtil.format("private {} {};", String.join(",", strings), c);
            }
            builder.append(d);
        });
        ClipboardUtil.setStr(builder.toString());
    }

    static Map<String, Set<String>> map = new HashMap<>();

    static {
        initMap();
    }


    public static void initMap() {
        List<String> list = FileUtil.listFileNames(classPath);
        list.forEach(s -> {
            String v = StrUtil.removeSuffix(packetPrefix + s, ".java");
            buildMap(map, v);
        });
    }

    private static void buildMap(Map<String, Set<String>> map, String className) {
        Class<?> aClass = ClassLoaderUtil.loadClass(className);
        for (Field declaredField : aClass.getDeclaredFields()) {
            String key = declaredField.getName();
            List<String> split = StrUtil.split(declaredField.getType().toString(), '.');
            String value = split.get(split.size() - 1);
            if (map.containsKey(key)) {
                map.get(key).add(value);
            } else {
                HashSet<String> set = new HashSet<>(1);
                set.add(value);
                map.put(key, set);
            }
        }
    }
}
