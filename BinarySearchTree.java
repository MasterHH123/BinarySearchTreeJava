public class BinarySearchTree<T extends Comparable<? super T>>{
    private class Node {
        public T value;
        public Node left = null, right = null, parent = null;
        public Node(T value){
            this.value = value;
        }
        public String toString(){
            return this.value.toString();
        }
    }

    private Node root = null;
    private int size = 0;
    public int size(){
        return this.size;
    }

    private void print(Node node, int level){
        if(node != null){
            print(node.left, level + 1);
            for(int i = 0; i < level; i++){
                System.out.println(" ");
                System.out.println(node.value);
                print(node.right, level + 1);
            }
        }
    }

    public void print(){
        print(this.root, 0);
        System.out.println("-------");
    }


    //TODO add rest of methods



}
