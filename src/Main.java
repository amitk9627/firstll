class Node{
    int data;
    Node next;
    public Node(int data){
        this.data=data;
        this.next=null;
    }
}
class Linkedlist{
    Node head;
    Node tail;
    int size;
    public void print(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"-->");
            temp=temp.next;
        }
        System.out.println(temp);
    }

    void addfirst(int val){
        Node temp=new Node(val);
        temp.next=head;
        head=temp;
        if(size==0){
            tail=temp;
        }
        size++;
    }
    int removefirst(){
        int val=0;
        if(size==0){
            val=-1;
            System.out.println("List is empty");
        }else if(size==1){
            val=head.data;
            head=tail=null;
            size=0;
        }else{
            val=head.data;
            head=head.next;
            size--;
        }
        return val;
    }

    void addAt(int idx,int val){
        if(idx < 0 || idx > size){
            System.out.println("Invalid arguments");
        }else if(idx==0){
            addfirst(val);
        }else if(idx==size){
            addlast(val);
        }else{
            Node newNode=new Node(val);
            Node temp=head;
            for(int i=0;i<idx-1;i++){
                temp=temp.next;
            }
            newNode.next=temp.next;
            temp.next=newNode;
            size++;
        }
    }
    int removeAt(int idx){
        int val=-1;
        if(idx<0 || idx>=size){
            System.out.println("Invalid arguments");
        }else if(idx==0){
            val=removefirst();
        }else if(idx==size-1){
           val=removelast();
        }else{
            Node temp=head;
            for(int i=0;i<idx-1;i++){
                temp=temp.next;
            }
            val=temp.next.data;
            temp.next=temp.next.next;
            size--;
        }
        return val;
    }
    void addlast(int val){
        Node temp = new Node(val);
        temp.data=val;
        temp.next=null;
        if(size==0) {
            head=tail=temp;
        }
        else{
            tail.next=temp;
            tail=temp;
        }
        size++;
    }
    int removelast(){
        int val=-1;
        if(size==0){
            System.out.println("List is empty");
        } else if (size==1) {
            val=tail.data;
            head=tail=null;
            size=0;
        }else{
            Node temp=head;
            for(int i=0;i<size-2;i++){
                temp=temp.next;
            }
            tail=temp;
            val=temp.next.data;   //something is missing
            temp.next=null;
            size--;
        }
        return val;
    }

    public int getfirst(){
        if(size==0){
            System.out.println("List is empty");
            return -1;
        }
        return head.data;
    }
    int getlast(){
        if(size==0){
            System.out.println("List is empty");
            return -1;
        }
        return tail.data;
    }
    int getAt(int idx){
        if(size==0){
            System.out.println("List is empty");
            return -1;
        }else if(idx<0 || idx>=size){
            System.out.println("Invalid Arguments");
            return -1;
        }
        Node temp=head;
        for(int i=0;i<idx;i++){
            temp=temp.next;
        }
        return temp.data;
    }
    // find node
    private Node getNodeAt(int idx){
        Node temp=head;
        for(int i=0;i<idx;i++){
            temp=temp.next;
        }
        return temp;
    }
    public void reverseOI(){
        int li=0;
        int ri=size-1;
        while(li<ri){
            Node left=getNodeAt(li);
            Node right=getNodeAt(ri);
            int temp=left.data;
            left.data= right.data;
            right.data=temp;
            li++;ri--;
        }
    }
    public void reversePI(){
        Node prev=null;
        Node curr=head;
        while(curr!=null){
            Node org=curr.next;
            curr.next=prev;
            prev=curr;
            curr=org;
        }
        Node temp=head;
        head=tail;
        tail=temp;
    }
//    kth element from the end in LL
    public int kthfromLast(int k){
        Node s=head;
        Node f=head;
        for(int i=0;i<k;i++){
            f=f.next;
        }
        while(f!=null){
            s=s.next;
            f=f.next;
        }
        return s.data;
    }
    public int mid(){
        Node s=head;
        Node f=head;
        while(f.next!=null && f.next.next!=null){
            s=s.next;
            f=f.next.next;
        }
        return s.data;
    }

}
public class Main {
    public static void main(String[] args){
        Linkedlist list=new Linkedlist();
        list.addlast(25);
        list.addlast(34);

       // System.out.println(list.removefirst());
        list.addfirst(5);
        list.addfirst(1);
        list.addAt(2,3);
        list.print();
       //  System.out.println(list.removelast());
//        list.reversePI();
        //System.out.println(list.kthfromLast(3));
        System.out.println(list.mid());
        list.print();
//        System.out.println(list.removeAt(3));
//        list.print();
//        System.out.println(list.size);
//        System.out.println(list.getAt(-1));
    }
}
