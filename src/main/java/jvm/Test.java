package jvm;

public class Test {

    public static void get(String s){
        System.out.println("void get");
    }

    public static String get1(String s){
        System.out.println("string get");
        return null;
    }

    public final void isVip(User user){
        user.isVip();
    }

    public static void main(String[] args) {
        get("");
        get1("");
    }

}
