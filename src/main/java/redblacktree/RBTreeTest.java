package redblacktree;

import java.util.Scanner;

public class RBTreeTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RBTree<Integer,Object> rbt = new RBTree<>();
        while (true){
            System.out.println("请输入key:");
            String key = scanner.next();
            if (key.equals("remove")){
                System.out.println("切换到删除模式");
                System.out.println("请输入key:");
                System.out.println();
                rbt.delete(Integer.parseInt(key));
                rbt.print();
            }
            System.out.println();
            rbt.insert(Integer.parseInt(key),null);
            rbt.print();
        }
    }

}
