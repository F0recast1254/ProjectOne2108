import java.util.*;
import java.io.*;
// issues:
// sortedInsert inserts at the first instance after or before an arrivaltime is less or greater than
// problem with this is if there are more than 2 same priority
//fix:
// have sort linkedlist at the end, sort linkedlist should account for multiple arrival times
public class main {

    public static void main(String[]args){
        PQ_LL ll = new PQ_LL();
        ll.readFile();
        //System.out.println("before");
        //ll.display();

        //ll.sortLinkedList();

        //System.out.println("after");
        //ll.display();



        Scanner s =  new Scanner(System.in);
        int Menunumber = 0;
        String menu = "Displaying menu\n1: Display current Requests\n2: Create new Request\n3: Search\n4: Delete a Request\n5: Serve a Request\n6: Change Request Priority\n7: Save\n8: Exit";


        while (Menunumber!=8) {
            System.out.println(menu);
            Menunumber = s.nextInt();
            s.nextLine();
            switch (Menunumber) {
                case 1:
                    //it displays but not in order
                    ll.display();
                    break;

                case 2:
                    System.out.println("Enter the unique ID: ");
                    String id = s.nextLine();
                    System.out.println("Enter the arrival time: ");
                    long arriveTime = s.nextLong();
                    s.nextLine();
                    System.out.println("Enter the priority: ");
                    double priority = s.nextDouble();
                    s.nextLine();

                    Request newRequest = new Request(id, arriveTime, priority);
                    ll.sortedInsert(newRequest);
                    //sortlinkedlist doesnt work right now
                    //could sort insert and run sortedlinkedlist
                    //ll.sortLinkedList();
                    break;

                case 3:
                    System.out.println("1) by ID\n2) by Priority");
                    int input = s.nextInt();
                    s.nextLine();
                    switch (input)  {
                        case(1):
                            System.out.println("Enter the ID: ");
                            String idInput = s.nextLine();
                            ll.searchId(idInput).displayNode();
                            break;
                        case (2):
                            System.out.println("Enter the priority: ");
                            double priorityInput = s.nextDouble();
                            s.nextLine();
                            ll.searchPriority(priorityInput).displayNode();
                            break;
                    }
                    break;

                case 4:
                    System.out.println("Enter the ID: ");
                    String inputID = s.nextLine();
                    ll.delete(ll.getIndexOfNode(ll.searchId(inputID).getPriority(),ll.searchId(inputID).getArrivalTime()));

                    break;

                case 5:
                    //this only works with sorted linkedlist
                    System.out.print("Serving: ");
                    ll.getHead().displayNode();
                    ll.delete(ll.getIndexOfNode(ll.getHead().getPriority(),ll.getHead().getArrivalTime()));
                    break;

                case 6:
                    System.out.println("Enter the ID: ");
                    String newID = s.nextLine();
                    System.out.println("Enter the new priority: ");
                    double p = s.nextDouble();
                    s.nextLine();
                    //use sort insert and delete old

                    Request temp = new Request(newID,ll.searchId(newID).getArrivalTime(),p);
                            //deletes the old request
                    ll.delete(ll.getIndexOfNode(ll.searchId(newID).getPriority(),ll.searchId(newID).getArrivalTime()));
                    ll.sortedInsert(temp);

                    break;

                case 7:
                    //you want to sort again just in case it's not sorted
                    //write latest linkedlist to txt file
                    // when i save the last node isnt written ....
                    String lengthOfLinkedList = Integer.toString(ll.length());
                    try {
                        FileWriter fileWriter = new FileWriter("src/data.txt");
                        //writes the num of requests then goes to next line
                        fileWriter.write(lengthOfLinkedList + "\n");
                        //writes each requests and goes to next line after
                        fileWriter.write(ll.outputAllLinkedList());
                        fileWriter.close();
                        System.out.println("File has been saved");
                    }
                    catch (IOException e ){
                    }

                    break;
            }
            }


        }


    }
