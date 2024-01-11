import java.util.Random;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.Add(3);
        bst.Add(-2);
        bst.Add(5);
        bst.Add(12);
        bst.Add(-2);
        bst.Add(-20);
        bst.Add(200);
        bst.Add(8);
        bst.Add(4);
        bst.Add(16);
        bst.print();

        System.out.println("Beginning of remove method\n");

        bst.remove(16);
        bst.print();
        bst.remove(-2);
        bst.print();
        bst.remove(5);
        bst.print();
        bst.remove(3);
        bst.print();

    }
}