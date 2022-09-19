import java.util.Scanner;
//I'm not sure where to put file reading and writing, so I'm leaving room above the main function

public class main {









    public static void main(String[]args){
        Scanner input =  new Scanner(System.in);
        int Menunumber = 0;
        String menu = "Displaying menu\n1: Display current Requests\n2: Create new Request\n3: Search\n4: Delete a Request\n5: Serve a Request\n6: Change Request Priority\n7: Save\n8: Exit";
        while (Menunumber!=8){
            System.out.println(menu);
            Menunumber= input.nextInt();
        }
        switch (Menunumber){
            case 1:
                break;

            case 2:
                break;

            case 3:
                break;

            case 4:
                break;

            case 5:
                break;

            case 6:
                break;

            case 7:
                break;
        }
    }
}
