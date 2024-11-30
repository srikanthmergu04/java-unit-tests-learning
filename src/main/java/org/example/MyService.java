package org.example;

public class MyService {
    public static void main(String[] args) {
        MyService myService = new MyService();
        System.out.println(myService.a("test"));
        System.out.println(StringHelper.Hello());
    }

    public String a(String input) {
        return input + " " + StringHelper.Hello();
    }

    public String b(String input) {
        return "Processed in b: " + input;
    }

    public String c(String input) {
        return "Processed in c: " + input;
    }
}
