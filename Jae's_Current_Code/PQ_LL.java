import java.io.*;

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
            while((currentLine = reader.readLine()) != null){

                if(count == 0 ){
                    count++;
                }
                else {
                    String[] currentLineArr = currentLine.split(" ");
                    Request newRe = new Request((currentLineArr[0]), Long.parseLong(currentLineArr[1]), Double.valueOf(currentLineArr[2]));

                    sortedInsert(newRe);


                }

            }
        }
        catch (Exception e){
            System.out.println(e);
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

    /**
     * This method add newR at the last position of the linked list.
     * @param newR takes a Request object
     */
    public void addLast(Request newR){
        if(head == null){
            addFirst(newR);
        }else{
            tVrsr = head;
            while(tVrsr.next != null){
                tVrsr = tVrsr.next;
            }
            newR.next = tVrsr.next;
            tVrsr.next = newR;

        }
    }


    Request sortedInsert(Request temp){
        if(head == null || temp.getPriority() >head.getPriority() ) {
            addFirst(temp);
            return head;
        }

        Request current  = head;
        int count = 0 ;

        // better to have where while loop ends and the current is what you want


        //accounts for when t.p < c.p or when t.p> c.p
        // when it exits either temp.Prio is greater than curr.Prio or temp.P == curr.P
        while(current.next != null && temp.getPriority() != current.getPriority() && temp.getPriority()< current.getPriority()) {
            current = current.next;
            count++;
        }
            //if temp prio bigger than curr prio then insert temp before curr
            if( temp.getPriority() != current.getPriority() &&temp.getPriority()> current.getPriority()){
                temp.next = current;
                getNode(count-1).next = temp;
                return head;
            }
            //insert after
            else if (temp.getPriority() != current.getPriority() &&temp.getPriority()< current.getPriority() ){
                 temp.next = current.next;
                 current.next = temp;
                 return head;
            }

            //this gets triggered when t.p == c.p
        if(temp.getPriority() == current.getPriority() )    {
                //exits when t.a <c.a
               while(current.next != null && temp.getPriority()== current.getPriority() && temp.getArrivalTime()>current.getArrivalTime()){
                  current = current.next;
                  count++;
               }
               //insert before curr
               if(temp.getPriority() != current.getPriority() ){
                   getNode(count-1).next = temp;
                   temp.next = current;
               }
               //insert before curr
               else if(temp.getPriority()== current.getPriority() && temp.getArrivalTime()<current.getArrivalTime() ){
                   getNode(count-1).next = temp;
                   temp.next = current;
               }
               //insert after curr
               else if(temp.getPriority()== current.getPriority() && temp.getArrivalTime()>current.getArrivalTime() ){
                   temp.next = current.next;
                   current.next = temp;
               }
            }

return head;

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



    int length() {
        int count = 0;
        Request walker ;
        for(walker = head; walker != null; walker = walker.next) {
            count++;
        }
        return count;
    }




}
