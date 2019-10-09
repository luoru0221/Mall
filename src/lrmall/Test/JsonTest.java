package lrmall.Test;

import com.alibaba.fastjson.JSONObject;
import lrmall.bean.User;

import java.util.ArrayList;

public class JsonTest {

    public static void main(String[] args) {
        ArrayList<ArrayList<User>> arrayLists = new ArrayList<>();
        ArrayList<User> users1 = new ArrayList<>();
        ArrayList<User> users2 = new ArrayList<>();
        ArrayList<User> users3 = new ArrayList<>();
        User user1 = new User();
        User user2 = new User();
        User user3 = new User();
        user1.setId("123");
        user2.setId("234");
        user3.setId("345");
        user1.setName("luoru");
        user2.setName("ldkshfkj");
        user3.setName("slkdjhf");
        users1.add(user1);
        users1.add(user2);
        users2.add(user1);
        users2.add(user3);
        users3.add(user2);
        users3.add(user3);
        arrayLists.add(users1);
        arrayLists.add(users2);
        arrayLists.add(users3);
        String jsonString = JSONObject.toJSONString(arrayLists);
        System.out.println(jsonString);
        ArrayList array = JSONObject.parseObject(jsonString,arrayLists.getClass());
        System.out.println(array);
        System.out.println("解析：");
        for (Object item : array) {
            String str = item.toString();
            ArrayList users = JSONObject.parseObject(str, users1.getClass());
            for (Object user : users) {
                System.out.println(user);
            }
        }
    }
}
