import java.util.ArrayList;
import java.util.Collection;

public class PQ_LL {

    Request head;
    Request tVrsr;

    //Collection<? extends Request>NewList;

    public PQ_LL(){
        head = new Request();
    }

    public PQ_LL(Collection<? extends Request> L){
        head = getIndex(0);
    }

    /**
     * Method to traverse through linked list uses tVrsr field to track position.
     */
    public void traverse(){
        tVrsr = head;
        while(tVrsr.next != null){
            tVrsr.print();
            tVrsr = tVrsr.next;
        }
    }

    public int size(){
        int x = 0;
        tVrsr = head;
        while(tVrsr.next != null) {
            x++;
            tVrsr = tVrsr.next;
        }
        return x;
    }

    /**
     * This method adds newR as the first position of the linked list.
     * @param newR takes a Request object
     */
    public void addFirst(Request newR){
        newR.next = head;
        head = newR;
    }

    /**
     * This method add newR at the last position of the linked list.
     * @param newR takes a Request object
     */
    public void addLast(Request newR){
        if(head.next == null){
            addFirst(newR);
        }else{
            traverse();
            tVrsr.next = newR;
        }
    }

    /**
     * This version of this method appends newR to the linked list using the addLast method.
     * @param newR Takes a Request object
     */
    public void add(Request newR){
        addLast(newR);
    }

    /**
     * This version of this method adds newR at the index param
     * @param index takes an int
     * @param newR takes a Request object
     */
    public void add(int index, Request newR){
        Request pre = getIndex(index-1);
        newR.next = pre.next;
        pre.next = newR;

    }

    /**
     * This method gets the Request object at the specified location using the tVrsr field.
     * @param x takes an int
     * @return tVrsr
     */
    public Request getIndex(int x){
        int i;
        tVrsr = head;
        for(i=0; i<x; i++){
            if(tVrsr.next == null) {
                return tVrsr;
            }else tVrsr = tVrsr.next;
        }
        return tVrsr;
    }

    /**
     * This method removes a Request object from the linked list at the specified position.
     * @param x takes an int
     * @return the removed object via the getIndex
     */
    public Request Delete(int x){
        Request pre;
        pre = getIndex(x-1);
        Request removedR = getIndex(x);
        if(getIndex(x).next == null){
            pre.next = null;
        }else{
            Request post = getIndex(x+1);
            pre.next = post;
        }
        return removedR;
    }
}
/*
 */