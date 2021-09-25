package designpattern.proxy.dynamic;

public class Client {

    public static void main(String[] args) {
        TeacherDao target = new TeacherDao();
        ITeacherDao proxyInstance = (ITeacherDao) new ProxyFactory(target).getProxyInstance();
        System.out.println(proxyInstance.getClass());
        proxyInstance.teach();
    }

}
