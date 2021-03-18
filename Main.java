import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //Tareas a realizar:
    // Mostrar Tareas
    // Aniadir Tareas
    // Borrar Tareas
    // Marcar como completada

    
    private static ArrayList<String> tasks = new ArrayList<>();
    private static Scanner in = new Scanner(System.in);

    
    public static void menu() {
        System.out.print(   "Options:\n" +
                            "1 - Show tasks\n" +
                            "2 - Delete task\n" +
                            "3 - Add new task\n" +
                            "4 - Mark as completed\n" +
                            "0 - Exit\n" );
    }

    private static void showTasks() {
        if (!tasks.isEmpty()) {
            System.out.println("\nYour tasks:");
            for (String task : tasks) {
                int index = tasks.indexOf(task);
                System.out.println(index + " - " + task);
            }
            System.out.println();
            return;
        }
        System.out.println("\nThere are no tasks left!\n");
    }

    private static void addTask(String newTask) {
        tasks.add(newTask);
    }

    private static void deleteTask(int index) {
        try {
            tasks.remove(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Not a valid task index.");
        }
    }

    private static int validateNumber(String num) {
        // System.out.println("Task number: ");
       try{
           return Integer.parseInt(num);
       } catch (NumberFormatException e) {
           System.out.println("Only numbers are allowed.");
        }
        return validateNumber(in.nextLine());
        
    }

    private static void completeTask(String taskNumber) {
        int validNumber = validateNumber(taskNumber);
        if (tasks.get(validNumber).contains("(Completed)")) {
            System.out.println("Task has already been marked as completed!");
            return ;
        }

        String completed = tasks.get(validNumber) + " (Completed)";
        tasks.set(validNumber, completed);
    }
    
    public static void main(String[] args) {
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

                case 1:
                    showTasks();
                    break;
                
                case 2:
                    if (tasks.isEmpty()) {
                        System.out.println("There are no tasks to delete!");
                        break;
                    } 
                    System.out.print("Enter task number: ");
                    deleteTask(validateNumber(in.nextLine()));
                    break;
                
                case 3:
                    System.out.print("Enter new task: ");
                    addTask(in.nextLine());
                    break;
                
                case 4:
                    System.out.print("Enter task number: ");
                    completeTask(in.nextLine());
                    break;
                
                default :
                    break;
            }
            
        }

        in.close();
        
    }
}

