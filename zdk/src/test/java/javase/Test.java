package javase;

/**
 * Created by z_dk on 2018/10/2.
 */
class Base{
    int num = 1;
    public Base(){
        this.print();
        num = 2;
    }
    public void print(){
        System.out.println("Base.num = "+num);
    }
}
class Sub extends Base{
    int num = 3;
    public Sub(){
        this.print();
        num = 4;
    }
    public void print(){
        System.out.println("Sub.num = "+num);
    }
}

public class Test {
    class Dog {
        private String name;
        private int age;
        private int step;
        Dog(String s,int a){
            name=s;
            age=a;
            step=0;
        }
        public void run(Dog fast){
            fast.step++;
        }
    }
    public static void main(String[] args) {
       /* Base b = new Sub();
        System.out.println(b.num);*/
       Test test = new Test();
       Dog d = test.new Dog("Tom",3);
       d.step = 25;
       d.run(d);
       System.out.println(d.step);
    }
}
