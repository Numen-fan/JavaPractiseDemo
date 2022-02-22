import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class JSONParseDemo {

    /**
     * 测试Map与json的互转
     */
    @SuppressWarnings("unchecked")
    @Test
    public void testMapParse() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 10);
        map.put(3, 100);
        map.put(4, 1000);

        String jsonStr = JSON.toJSONString(map, SerializerFeature.WriteNonStringKeyAsString);
        System.out.println(jsonStr);

        Map<Integer, Integer> newMap = (Map<Integer, Integer>) JSON.parse(jsonStr);

        System.out.println(newMap);

    }

    @Test
    public void testList() {
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();

        b.add(1);
        b.add(2);
        b.add(3);

        a.addAll(b);

        b.remove(1);

        System.out.println(a);
        System.out.println(b);


    }

}
