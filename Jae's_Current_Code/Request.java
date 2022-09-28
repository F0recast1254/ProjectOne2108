public class Request {
    //Request is the node class

    //data is below
    String ID;
    long arrivalTime;
    double priority;

    //link
    Request next;

    Request(String ID, long arrivalTime, double priority){
        this.ID = ID;
        this.arrivalTime = arrivalTime;
        this.priority = priority;
    }

    //setPriority
    void setPriority(int x ){
       priority = x;
    }

    //get id
    String getID(){
        return ID;
    }

    //get arrival time
    long getArrivalTime(){
        return arrivalTime;
    }

    //get priority
    double getPriority(){
        return priority;
    }

    //display
    void displayNode(){
        System.out.println("ID: "+ ID + ", Arrival Time: "+ arrivalTime+ ", Priority: " + priority);
    }
    @Override
    public String toString(){
        return ( ID + " "+ arrivalTime+ " " + priority+"\n");
    }

}
