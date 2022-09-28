import java.io.BufferedReader;
import java.io.FileReader;
import  java.util.*;

public class PQ_LL {

    Request head;
    Request tVrsr;

    public PQ_LL(){
        head = null;
    }

    Request getHead (){
        return head;
    }

    Request searchId (String id) {
        Request walker = head;
        Request ans = null ;
        while (walker != null) {
            if (walker.getID().equals(id)) {
                ans =  walker;
            }
            walker = walker.next;
        }
        return ans;
    }

    Request searchPriority(double priority){
        Request walker = head;
        Request ans = null;
        while (walker != null) {
            if (walker.getPriority() == priority)
            {
                ans = walker;
            }
            walker = walker.next;

        }
        return ans;
    }

    void readFile(){

        //read line by line
        //use split(" ") , which creates an array index 0 will be the id etc

        BufferedReader reader = null;
        try {
            String currentLine;
            reader = new BufferedReader(new FileReader("src/data.txt"));
            int count = 0 ;
            int nOfNodes =0 ;
            Request node;
            System.out.println();
            while((currentLine = reader.readLine()) != null){
                if(count == 0 ){
                    count++;
                    continue;
                }
                else {
                    String[] currentLineArr = currentLine.split(" ");
                    Request newRe = new Request((currentLineArr[0]), Long.parseLong(currentLineArr[1]), Double.valueOf(currentLineArr[2]));
                    addLast(newRe);
                }

            }
        }
        catch (Exception e){
        }
    }

// doesnt work
    Request sortLinkedList(){
        //string unique id ,long arrival time,double priority
        //if two nodes have same priority then look at arrival time
        //sorting to ascending order
        Request curr = head;
        Request currNext = null;
        Request temp = null ;

        if( head == null){
            return head;
        }
        else {

            while (curr != null) {
                currNext = curr.next;

                while (currNext != null) {

                    //if node before is bigger than next
                    if (curr.getPriority() < currNext.getPriority()) {

                        //swap the nodes
                        swap(getIndexOfNode(curr.getPriority(),curr.getArrivalTime()),getIndexOfNode(currNext.getPriority(),currNext.getArrivalTime()));
                        System.out.println("swapping pt one ");


                    }

                    //accounts for if there are two nodes with same priority
                    else if (curr.getPriority() == currNext.getPriority()) {

                        //look at arrival time
                        if (curr.getArrivalTime() < currNext.getArrivalTime()) {


                            //swap the nodes
                            swap(getIndexOfNode(curr.getPriority(),curr.getArrivalTime()),getIndexOfNode(currNext.getPriority(),currNext.getArrivalTime()));
                            System.out.println("swapping pt two");

                        }
                    }
                    //iterates next by one
                    currNext = currNext.next;
                }
                //iterates curr by one
                curr = curr.next;
            }

        }
        return head;

    }

    //issue 100 102 101 , 102 is inserted

    Request sortedInsert(Request temp){
        //if head is the end then addFirst or if temp priority is greater than head priority addFirst
       if(head == null || temp.getPriority()>head.getPriority()  ){
           addFirst(temp);
           return head;
       }

       Request current = head;
       int count =0 ;
       //constantly checks only if temp priority is less than curr priority
       while(current != null && temp.getPriority() < current.getPriority() ){
           current = current.next;
           count++;
       }

       //when while loop ends current is less than temp.getPrority()
       // also when the two priorities are equal the loop ends
       if(temp.getPriority() == current.getPriority() && temp.getArrivalTime()<current.getArrivalTime()){
               temp.next = current;
               getNode(count-1).next = temp;

               return head;
       }
       else if(temp.getPriority() == current.getPriority() && temp.getArrivalTime()>current.getArrivalTime()){
           //inserting after curr
           //temp pointer points to node after curr
           temp.next = getNode(count+1);
           //curr pointer points to temp
           current.next = temp ;
           return head;
       }

           temp.next = current;
           getNode(count - 1).next = temp;

       return head;
    }

    Request insert(int insertIndex, Request n){
        if (insertIndex >= 1 ){
            //before becomes the node before
            Request before = getNode(insertIndex-1);
            Request curr = getNode(insertIndex);
            n.next = curr;
            before.next = n;

            return head;

        }
        else{
            addFirst(n);
            return head;

        }
    }
    /**
     * This method adds newR as the first position of the linked list.
     * @param newR takes a Request object
     */
    //??
    public void addFirst(Request newR){
        newR.next = head;
        head = newR;
    }

    //display ll
    void display(){
        //access linkedlist by accessing head and iterating down
        for(Request walk = head; walk  != null;walk  = walk.next){
            walk.displayNode();
        }
    }



    int getIndexOfNode(double priority, long arrivalTime){
        int count =0 ;
        Request walker = head;
        while(walker.next != null){
            if(walker.getPriority() == priority && walker.getArrivalTime() == arrivalTime){
               break;
            }
            count++;
            walker = walker.next;
        }
        return count;
    }
    /**
     * This method removes a Request object from the linked list at the specified position.
     * @param x takes an int
     * @return the removed object via the getIndex
     */
    public void delete(int x) {
        if (x == 0) {
            head = head.next;
        } else {
            Request pre = getNode(x - 1);
            Request post = getNode(x + 1);

            pre.next = post;
        }
    }




    void swap(int x, int y ){
        //x =y ,y = x
        //call node from index
        Request tempX = getNode(x);
        Request tempY = getNode(y);

        add(y,tempX);
        delete(y+1);

        add(x,tempY);
        delete((x+1));

    }
    /**
     * This version of this method adds newR at the index param
     * @param index takes an int
     * @param newR takes a Request object
     */
    public void add(int index, Request newR) {
        Request pre = getNode(index - 1);
        newR.next = pre.next;
        pre.next = newR;
    }

    /**
     * This method gets the Request object at the specified location using the tVrsr field.
     * @param x takes an int
     * @return tVrsr
     */
    // I think it should be called getNode, name is misleading. It doesn't return an index
    //was called getIndex
    public Request getNode(int x){
        Request walker = head;
        for(int i =0 ; i<x ; i++){
            walker = walker.next;
        }
        return walker;
    }

    /**
         * Method to traverse through linked list uses tVrsr field to track position.
         */
    //in class it was used as to display the entire linkedlist
    //this makes tVrsr to equal last node
    //more like getLastNode()


    public String outputAllLinkedList(){
        String linkedlist = "";

        Request temp = head;
        //cant get last node
        //want to stop before tVrsr becomes null
        while(temp != null){
            linkedlist += temp.toString();
            temp = temp.next;

        }
        return linkedlist;
    }
    void traverse(){
        tVrsr = head;
        while(tVrsr.next != null){
            tVrsr = tVrsr.next;
        }
    }


    /**
     * This method add newR at the last position of the linked list.
     * @param newR takes a Request object
     */
    public void addLast(Request newR){
        if(head == null){
            addFirst(newR);
        }else{
            traverse();
            tVrsr.next = newR;
        }
    }

    int length() {
        int count = 0;
        Request walker ;
        for(walker = head; walker != null; walker = walker.next) {
            count++;
        }
        return count;
    }

    /**
     * This version of this method appends newR to the linked list using the addLast method.
     * @param newR Takes a Request object
     */
    public void add(Request newR){
        addLast(newR);
    }



    //serving request
    //display curr request to serve and delete node
    void serveRequest(int x){
        getNode(x).displayNode();
        delete(x);
    }




}
