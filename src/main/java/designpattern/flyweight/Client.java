package designpattern.flyweight;

public class Client {

    public static void main(String[] args) {
        WebSiteFactory webSiteFactory = new WebSiteFactory();

        WebSite webSite = webSiteFactory.getWebSiteCategory("新闻");
        webSite.use(new User("tom"));

        WebSite webSite1 = webSiteFactory.getWebSiteCategory("博客");
        webSite1.use(new User("sms"));

        WebSite webSite2 = webSiteFactory.getWebSiteCategory("博客");
        webSite2.use(new User("jess"));

        System.out.println("网站的分类共" + webSiteFactory.getWebSiteCount() + "个");
    }

}
