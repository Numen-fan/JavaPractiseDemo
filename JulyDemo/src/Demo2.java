import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.omg.CORBA.StringHolder;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Demo2 {
    public static void main(String[] args) {
        String[] strArr = new String[]{"hello","world","你好世界！"};
//        strArr[0] = "hello";
//        strArr[1] = "world";
//        strArr[2] = "你好，世界！";

        System.out.println(String.join(",", strArr));

        JSONObject data = new JSONObject();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("rep_params", null);
        jsonObject.put("rep_id", "9999");
        data.put("data", jsonObject);
        System.out.println(data.toJSONString());

        System.out.println(null + "");

        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());

        System.out.println(format.format(1621837525237L));

        testString();

        List<String> list = new ArrayList<String>() ;

        list.add("1");
        list.add("6");
        list.add("3");
        list.add("4");
        String josnStr = JSON.toJSONString(list);
        System.out.println(josnStr);

        System.out.println(JSON.parseArray(josnStr, String.class));

    }

    private static void testString() {
        String s1 = "AB";
        String s2 = new String("AB");
        String s3 = "A";
        String s4 = "B";
        String s5 = "A" + "B";
        String s6 = s3 + s4;

        System.out.println(s2.intern() == s1);
    }

    @Test
    public void testJSONObject() {

        Object obj1 = JSON.parse("");

        JSONObject data = new JSONObject();

        JSONObject obj = new JSONObject();
        obj.put("rep_id", 100);
        obj.put("rep_params", "{}");
        obj.put("rep_type", "click");

        data.put("data", obj);

        System.out.println(data.toJSONString());

        JSONObject jsonObject = JSON.parseObject(data.toJSONString());

        System.out.println(jsonObject);


    }
}
