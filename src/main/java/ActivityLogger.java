import java.sql.Date;
import java.util.HashMap;
import java.util.Scanner;

public class ActivityLogger {

    HashMap<Date, Integer> logs = new HashMap<Date, Integer>();

    public void logActivity(Date date, int hours){
        logs.put(date, hours);
    }

    public void displayLogs(){
        for(Date date : logs.keySet()){
            System.out.println(date + " - " + logs.get(date) + " hours");
        }
    }

    public void countLast7(){
        int total = 0;
        for(Date date : logs.keySet()){
            if(date.after(new Date(System.currentTimeMillis() - 7 * 24 * 60 * 60 * 1000))){
                total += logs.get(date);
            }
        }
        System.out.println("Total hours in the last 7 days: " + total);
    }


    public static void main(String[] args) {
        ActivityLogger logger = new ActivityLogger();
        Scanner scanner = new Scanner(System.in);


        while(true){
            System.out.println("--------------------");
            System.out.println("1. Log activity\n2. Display logs\n3. Count last 7 days\n4. Exit");
            System.out.println("--------------------");

            int choice = 0;
            do {
                System.out.println("Enter choice: ");
                try {
                    if (scanner.hasNextInt()) {
                        choice = scanner.nextInt();
                    }else {
                        System.out.println("Invalid choice");
                        System.exit(0);
                    }
                } catch (Exception e){
                    System.out.println("Invalid choice");

                    scanner.next();
                }


            } while (choice < 1 || choice > 4);

            switch(choice){
                case 1:
                    System.out.println("--------------------\nLog Activity");
                    System.out.println("Enter date (yyyy-mm-dd): ");
                    String date = scanner.next();
                    System.out.println("Enter hours: ");
                    int hours = scanner.nextInt();

                    try{
                        logger.logActivity(Date.valueOf(date), hours);
                    } catch (Exception e){
                        System.out.println("Invalid date format");
                    }

                    break;
                case 2:
                    System.out.println("--------------------\nDisplay Logs");
                    logger.displayLogs();
                    break;
                case 3:
                    System.out.println("--------------------\nCount Last 7 Days");
                    logger.countLast7();
                    break;
                case 4:
                    System.out.println("--------------------\nExiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
            }
        }

    }
}
