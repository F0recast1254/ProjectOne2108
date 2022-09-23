public class Request {
    String ID;
    long arrivalTime;
    double priority;
    Request next;
    Request(){}
    Request(String ID, long arrivalTime, double priority){
        this.ID = ID;
        this.arrivalTime = arrivalTime;
        this.priority = priority; 
    }
}
