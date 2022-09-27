import java.util.LinkedList;
import java.util.Scanner;
import java.util.LinkedList;
//I'm not sure where to put file reading and writing, so I'm leaving room above the main function
public class main {






    public static void main(String[]args){
        PQ_LL pq = new PQ_LL();
        Scanner input =  new Scanner(System.in);
        int Menunumber = 0;
        String menu = "Displaying menu\n1: Display current Requests\n2: Create new Request\n3: Search\n4: Delete a Request\n5: Serve a Request\n6: Change Request Priority\n7: Save\n8: Exit";
        while (Menunumber!=8){
            System.out.println(menu);
            Menunumber= input.nextInt();
        }
        switch (Menunumber){
            case 1:for(int i=0; i<pq.size();i++){
                System.out.println(pq.getIndex(i));}
                break;

            case 2:
                Request newRequest = new Request();
                System.out.println("What is the Request's ID?");
                newRequest.ID= input.next();
                System.out.println("What is "+newRequest.ID+"'s arrival time?");
                newRequest.arrivalTime = input.nextLong();
                System.out.println("What is "+newRequest.ID+"'s priority?");
                newRequest.priority = input.nextDouble();
                break;

            case 3:
                System.out.println("Please enter whether you are searching by ID or Priority\n1: ID\n2: Priority");
                if(input.nextInt()== 1){
                    System.out.println("Please enter the ID you are searching for:");
                }
                else if (input.nextInt()==2){
                    System.out.println("Please enter the Priority you are searching for");
                }
                break;

            case 4:
                System.out.println("Please enter the ID of the request you wish to delete: ");
                for(int i=0; i<pq.size; i++)
                    if(pq.getIndex(i).ID == input.next()){
                        pq.Delete(i);
                    }
                break;

            case 5:
                break;

            case 6:
                System.out.println("Please enter the ID of the Request you wish to change");
                for(int i=0; i<pq.size; i++)
                    if(pq.getIndex(i).ID == input.next()){
                        System.out.println("What do you wish to change the priority to?");
                        pq.getIndex(i).priority=input.nextDouble();
                    }
                break;

            case 7:
                break;
        }
    }
}
