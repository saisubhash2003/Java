import java.util.*;
//class Node{
//    int data;
//    Node left;
//    Node right;
//    Node(int data){
//        this.data=data;
//        this.left=null;
//        this.right=null;
//    }
//}
//public class Main {
//    public static void leveloreder(Node root){
//        //levelordertraversal
//        Queue<Node> q=new LinkedList<>();
//        q.add(root);
//        while(!q.isEmpty()){
//            Node temp=q.poll();
//            System.out.print(temp.data+" ");
//            if(temp.left!=null){
//                q.add(temp.left);
//            }
//            if(temp.right!=null){
//                q.add(temp.right);
//            }
//        }
//    }
//    static int sumofleafnodes(Node root){
//        if(root==null){
//            return 0;
//        }
//        if(root.left==null&&root.right==null){
//            return root.data;
//        }
//        else{
//            return sumofleafnodes(root.left)+sumofleafnodes(root.right);
//        }
//    }
//    static int height(Node root){
//        //height of the tree
//        if(root==null){
//            return 0;
//        }
//        else{
//            int lh=height(root.left);
//            int rh=height(root.right);
//            return Math.max(lh,rh)+1;
//        }
//    }
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        Queue<Node> q=new LinkedList<>();
//        Node head=new Node(sc.nextInt());
//        q.add(head);
//        int val;
//        int count=0;
//        while(!q.isEmpty()&&count!=3){
//            Node temp=q.poll();
//            val=sc.nextInt();
//            if(val!=-1) {
//                temp.left=new Node(val);
//                q.add(temp.left);
//            }
//            val=sc.nextInt();
//            if(val!=-1){
//                temp.right=new Node(val);
//                q.add(temp.right);
//            }
//            count++;
//        }
//        System.out.println("height is:"+height(head));
//        System.out.println("sum is:"+sumofleafnodes(head));
//        leveloreder(head);
//    }
//}
import java.util.*;
//converting BST to linked list in sorted order
class Lnode {
    int data;
    Lnode next;
    Lnode right;
    Lnode left;

    Lnode(int data) {
        this.data = data;
        this.next = null;
        this.right=null;
        this.left=null;
    }
}

class Main {
    public void print(int k1,int k2){
        root=print(root,k1,k2);
    }
    private Lnode print(Lnode root,int k1,int k2){
        if(root==null){
            return null;
        }
        if(root.data>k1) {
            print(root.left, k1, k2);
        }
        if(root.data>=k1&&root.data<=k2){
            System.out.print(root.data+" ");
        }
        if(root.data<k2){
            print(root.right,k1,k2);
        }
        return root;
    }
    static boolean checkbst(Lnode root,int min,int max){
        if(root==null){
            return true;
        }
        if(root.data<=min&&root.data>=max)
            return false;
        return checkbst(root.left,min,root.data)&&checkbst(root.right,root.data,max);
    }
    public static Lnode insertatend(Lnode head, int data) {
        Lnode newnode = new Lnode(data);
        if (head == null) {
            head = newnode;
        } else {
            Lnode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newnode;
        }
        return head;
    }

    public static Lnode inorder(Lnode head, Lnode root) {
        if (root == null) return head;
        head = inorder(head, root.left);
        head = insertatend(head, root.data);
        head = inorder(head, root.right);
        return head;
    }

    public static void display(Lnode head) {
        Lnode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Name : Vasamsetti Sai Subhash \nRollno : 21BF1A3759");
        Lnode root = new Lnode(4);
        root.left = new Lnode(2);
        root.right = new Lnode(6);
        root.left.left = new Lnode(1);
        root.left.right = new Lnode(3);
        root.right.left = new Lnode(5);
        root.right.right = new Lnode(7);

        Lnode head = null;
        head = inorder(head, root);
        display(head);
        int min=Integer.MIN_VALUE;
        int max=Integer.MAX_VALUE;
        System.out.print(checkbst(root,min,max));
    }
}

//Diameter of BST
public int diameter(Node n){
    if(n==null){
        return 0;
    }
    int lh=height(n.l);
    int rh=height(n.r);
    int dt=lh+rh+1   //+1 indicates adding root node
    int ld=diameter(n.l);
    int rd=diamter(n.r);
    return Math.max(dt,Math.max(ld,rd));
}

//height of the tree
public int height(Node n) {
    if (n == null) {
        return 0;
    }
    else {
        int lh = height(n.l);
        int rh = height(n.r);
        return Math.max(lh, rh) + 1;
    }
}