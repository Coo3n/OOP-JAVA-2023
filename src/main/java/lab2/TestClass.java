package lab2;


import java.util.List;

public class TestClass {
    public void firstPublicMethod(int number) {
        System.out.println(--number);
    }

    public void secondPublicMethod(int number) {
        System.out.println(++number);
    }

    @MyAnnotation(cntIterations = 1)
    protected void firstProtectedMethod(Boolean flag) {
        System.out.println(flag);
    }

    protected void secondProtectedMethod(Boolean flag) {
        if (flag) {
            System.out.println("wau wau YOPI YEE YOPI");
        } else {
            System.out.println("bad bad");
        }
    }

    @MyAnnotation(cntIterations = 3)
    private void firstPrivateMethod(String str) {
        System.out.println(str.toUpperCase());
    }

    @MyAnnotation(cntIterations = 2)
    private void secondPrivateMethod(String str) {
        System.out.println(str.length());
    }
}
