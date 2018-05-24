package cn.smp.framework.utils.string.reflech;

import lombok.Data;

import java.lang.reflect.Field;
import java.util.stream.IntStream;

/**
 * Created by fxiao
 * on 2018/5/17
 */
public class refleshUtils {

    public static String getParamers(Object obj){
        StringBuffer nameValue = new StringBuffer();
        Class cls = obj.getClass();
        Field[] fields = cls.getDeclaredFields();
        for (int i=0; i < fields.length; i++) {
            try {
                Field field = fields[i];
                field.setAccessible(true);
                String name = field.getName();
                Object value = field.get(obj);
                if (value != null) {
                    nameValue.append(name).append("=").append(value).append("&");
                }
            } catch (IllegalAccessException  e) {
                e.printStackTrace();
            }
        }
        return nameValue.toString().substring(0, nameValue.toString().length() -1);
    }


    public static void main(String[] args) {
        /*Demo demo = new Demo();
        demo.setAge(11);
        demo.setName("阿里巴巴");
        demo.setTime(System.currentTimeMillis());

        String name = getParamers(demo);
        System.out.println(name);*/

        int[] num = {11, 56, 565, -132, 45};

        int min2 = IntStream.of(num).parallel().min().getAsInt();
        System.out.println(min2);
    }

}

@Data
class Demo{

    private Integer Age;

    private Long time;

    private String name;
}
