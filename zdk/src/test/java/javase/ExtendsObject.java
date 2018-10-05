package javase;

/**
 * Created by z_dk on 2018/10/2.
 */
class User{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
public class ExtendsObject {
    public static void main(String[] args) {
        /*BigEndian object = new BigEndian();
        System.out.println(object.testpro);*/
        User user = new User();
        user.setAge(23);
        System.out.println(user);
    }
}
