import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private ArrayList<String> tasks = new ArrayList<>();
    
    public static void menu() {
        System.out.print(   "Options:\n" +
                            "1 - Show tasks\n" +
                            "2 - Delete task\n" +
                            "3 - Add new task\n");
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int temp_option = -1;

        loop: while(true) {
                menu();
                try {
                    temp_option = Integer.parseInt(in.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Use numbers from 0 to ? to select your option.");

                }
                switch (temp_option) {
                    case 0:
                        break loop;
                        
                }
            
        }



        in.close();
        

    }
}

