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

    private Node predecessor(Node node){
        if(node.left != null){
            return maximum(node.left);
        }
        else{
            Node p = node.parent;
            while(p != null){
                if(p.right == node){
                    return p;
                }
                node = p;
                p = p.parent;
            }
            return null;
        }
    }

    public T predecessor(T value){
        Node n = search(value, root);
        if(n == null){
            return null;
        }

        Node pre = predecessor(n);
            return pre != null ? pre.value : null;
    }

    private Node successor(Node node){
        if(node.right != null){
            return minimum(node.right);
        }
        else{
            Node p = node.parent;

            while(p != null){
                if(p.left == node){
                    return p;
                }
                node = p;
                p = p.parent;
            }
            return null;
        }
    }

    public T successor(T value){
        Node n = search(value, root);
        if(n == null){
            return null;
        }

        Node pos = successor(n);
            return pos != null ? pos.value : null;
    }

    private void remove(Node node){
        if(node.left == null && node.right == null){
            if(root == null){
                root = null;
            }
            else{
                if(node.parent.left == node){
                    node.parent.left = null;
                }
                else {
                    node.parent.right = null;
                }
                size--;
            }
        }
        else if(node.left == null && node.right != null){
            if(node == root){
                root = node.right;
                node.right.parent = null;
            }
            else{
                if(node.parent.left == node){
                    node.parent.left = node.right;
                    node.right.parent = node.parent;
                }
                else{
                    node.parent.right = node.right;
                    node.right.parent = node.parent;
                }
            }
            size--;
        }
        else if(node.left != null && node.right == null){
            if(node == root){
                root = node.left;
                node.left.parent = null;
            }
            else{
                if(node.parent.left == node){
                    node.parent.left = node.left;
                    node.left.parent = node.parent;
                }
                else{
                    node.parent.right = node.left;
                    node.left.parent = node.parent;
                }
            }
            size--;

        } else {
            Node suc = successor(node);
            node.value = suc.value;
            remove(suc);
        }
    }

    public boolean remove (T value){
        Node n = search(value, root);
        if(n == null){
            return false;
        }
        remove(n);
            return true;
    }




}
