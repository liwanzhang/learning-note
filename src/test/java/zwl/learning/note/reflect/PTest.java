package zwl.learning.note.reflect;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhangwanli
 * @description
 * @date 2018-09-10 下午2:16
 */
public class PTest {

    public static void main(String[] args) {
        P p = new P();
        p.setId(1001);
        p.setName("William");
        p.setAge(20);
        p.setSex("male");

        System.out.println(JSON.toJSONString(p));

        try {
            Class<?> c = Class.forName("zwl.learning.note.reflect.P");
            Class<?>[] argsType = new Class[1];
            argsType[0] = String.class;
            Method m = c.getMethod("setSex", argsType);
            m.invoke(p, "female");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.println(JSON.toJSONString(p));
    }
}

class P {
    private int id;
    private String Name;
    private int age;
    private String sex;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
