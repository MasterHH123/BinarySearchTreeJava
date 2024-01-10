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

    public boolean Add(T toAdd){
        Node n = new Node(toAdd);

        if(root == null){
            root = n;
            size++;
            return true;
        }

        Node aux = root;
        Node aux2 = null;
        int cmp = 0;

        while(aux != null){
            cmp = aux.value.compareTo(toAdd);
            aux2 = aux;

            if(cmp == 0)
                return false;
            aux = cmp > 0 ? aux.left : aux.right;
        }
        if(cmp > 0){
            aux2.left = n;
        }else{
            aux2.right = n;
        }

        n.parent = aux2;
        size++;

        return true;
    }

    private Node search( T toSearch, Node current) {
        while(current != null){
            int cmp = current.value.compareTo(toSearch);
            if(cmp == 0)
                return current;
            current = cmp > 0 ? current.left : current.right;
        }
        return null;
    }

    public boolean cotains(T value) {
        if(value == null)
            return false;

            return search(value, root) != null;
    }

    private Node maximum(Node node){
        if(node == null){
            return null;
        }
        while(node.right != null){
            node = node.right;
        }
        return node;
    }

    public T maximum(){
        Node max = maximum(root);
            return max != null ? max.value : null;
    }

    private Node minimum(Node node){
        if(node == null){
            return null;
        }
        while(node.left != null){
            node = node.left;
        }
        return node;
    }

    public T minimum(){
        Node min = minimum(root);
            return min != null ? min.value : null;
    }

    //TODO add a predecessor, successor and a remove method


}
