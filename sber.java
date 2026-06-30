package project;
import java.util.ArrayList;
import java.util.Scanner;

class user{
    String username;
    String email;
    String mobile_no;
    String location;
    int pincode;
    private String password;
    void setpassword(String password){
        this.password=password;
    }
    String getpassword(){
        return password;
    }
    void display(){
        System.out.println("USERNAME :" + username);
        System.out.println("E-MAIL :" +email);
        System.out.println("MOBILE NO :"+mobile_no);
        System.out.println("LOCATION :"+location);
        System.out.println("PINCODE :"+pincode);
        System.out.println("PASSWORD :"+"*".repeat(getpassword().length()));
    }
}
class driver{
    String dusername;
    String demail;
    String dmobile_no;
    private String dpassword;
    void setpassword(String password){
        this.dpassword=password;
    }
    String getdpassword(){
        return dpassword;
    }
    void show(){
        System.out.println("USERNAME :" + dusername);
        System.out.println("E-MAIL :" +demail);
        System.out.println("MOBILE NO :"+dmobile_no);
        System.out.println("PASSWORD :"+"*".repeat(getdpassword().length()));
    }
}

class booking extends user{
    Scanner sc=new Scanner(System.in);
    String source;
    String destination;
    int total_km;
    int choice;
    void choice(){
       
        System.out.println("1. RICKSHAW");
        System.out.println("2. SWIFT DEZIRE");
        System.out.println("3. WAGNOR");
        System.out.println("4. PREMIUM");
        System.out.println("5. EXIT");
        System.out.println("ENTER THE CHOICE MODEL YOU WANT");
        choice = sc.nextInt();

        if (choice==1){
            System.out.println("YOU CHOOSED RICKSHAW");
            
        }
        if(choice==2){
            System.out.println("YOU CHOOSED SWIFT DEZIRE");
            
        }
        if(choice==3){
            System.out.println("YOU CHOOSED WAGNOR");
            
        }
        if(choice==4){
            System.out.println("YOU CHOOSED PREMIUM");
            
        }
        else{
            System.out.println("invalid option");
        }
  
    }
    void show1(){
        System.out.println("SOURCE :"+source);
        System.out.println("DESTINATION :"+destination);
        System.out.println("TOTAL KM"+total_km);
    }

}

class acceptbooking extends booking{
    int fair;


    void acceptbooking(){
        System.out.println("1. DO YOU WANT TO ACCEPT THE RIDE");
        System.out.println("2. DO YOU WANT TO REJECT THE RIDE");
        System.out.println("ENTER THE OPTION AS PER YOU");
        int selected=sc.nextInt();
        if(selected==1){
            if (choice == 1) {
                System.out.println("YOUR FAIR IS :" + total_km * 10);
                fair = total_km * 10;
            } 
            else if (choice == 2) {
                System.out.println("YOUR FAIR IS :" + total_km * 12);
                fair = total_km * 12;
            } 
            else if (choice == 3) {
                System.out.println("YOUR FAIR IS :" + total_km * 10);
                fair = total_km * 15;
            } 
            else if (choice == 4) {
                System.out.println("YOUR FAIR IS :" + total_km * 10);
                fair = total_km * 20;
            } 
            else if (choice == 5) {
                System.out.println("Exiting...");
            } 
            else {
                System.out.println("Invalid choice! Please try again.");
            }
        }
        
        else{
            System.out.println("YOU DECLINED THE RIDE");
        }
    }
}
class fair extends acceptbooking{
    acceptbooking ab= new acceptbooking();

    void fair(){
        System.out.println("FAIR "+ab.fair);
    }

}


public class sber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        user currentUser=null;
        driver currentDriver = null;
        booking currentBooking = null;

        ArrayList<user>userlist=new ArrayList<>();
        ArrayList<driver>driverlist=new ArrayList<>();
        int option;

        do { 
            System.out.println("\n--------\nWELCOME TO OLA UBER\n--------");
            System.out.println("1. NEW USER");
            System.out.println("2. NEW DRIVER");
            System.out.println("3. EXISTING USER LOGIN");
            System.out.println("4. EXISTING DRIVER LOGIN");
            System.out.println("5. EXIT");
            System.out.print("ENTER YOUR OPTION: ");
            
            option = sc.nextInt();
            sc.nextLine(); // clear newline

            switch (option) {
                case 1:
                    user u = new user();
                    System.out.println("\n--- NEW USER REGISTRATION ---");
                    System.out.print("ENTER NAME: ");
                    u.username = sc.nextLine();
                    System.out.print("ENTER EMAIL: ");
                    u.email = sc.nextLine();
                    System.out.print("ENTER MOBILE NO: ");
                    u.mobile_no = sc.nextLine();
                    System.out.print("ENTER LOCATION: ");
                    u.location = sc.nextLine();
                    System.out.print("ENTER PINCODE: ");
                    u.pincode = sc.nextInt();
                    sc.nextLine();
                    System.out.print("ENTER PASSWORD: ");
                    u.setpassword(sc.nextLine());
                    userlist.add(u);
                    System.out.println("\nREGISTRATION SUCCESSFUL!\n");
                    u.display();
                    break;

                case 2:
                    driver d = new driver();
                    System.out.println("\n--- NEW DRIVER REGISTRATION ---");
                    System.out.print("ENTER NAME: ");
                    d.dusername = sc.nextLine();
                    System.out.print("ENTER EMAIL: ");
                    d.demail = sc.nextLine();
                    System.out.print("ENTER MOBILE NO: ");
                    d.dmobile_no = sc.nextLine();
                    System.out.print("ENTER PASSWORD: ");
                    d.setpassword(sc.nextLine());

                    driverlist.add(d);
                    System.out.println("\nDRIVER REGISTERED SUCCESSFULLY!\n");
                    d.show();
                    break;
                case 3:
                    booking b1 = new booking();

                    currentBooking = b1;
                    fair fair=new fair();
                    System.out.println("\n--- USER LOGIN ---");
                    System.out.print("ENTER USERNAME: ");
                    String uname = sc.nextLine();
                    System.out.print("ENTER PASSWORD: ");
                    String pass = sc.nextLine();
                    boolean found = false;
                    for (user u1 : userlist) {
                        if (u1.username.equals(uname) && u1.getpassword().equals(pass)) {
                            System.out.println("Login successful! Welcome " + u1.username);
                            found = true;

                            System.out.println("DO YOU WANT TO BOOK A RIDE");
                            System.out.println("1. YES");
                            System.out.println("2. NO");
                            System.out.println("SELECT THE OPTION");
                            int selection=sc.nextInt();
                            sc.nextLine();

                            if(selection==1){
                                if (currentDriver==null){
                                    System.out.println("NO DRIVER AVAILABLE");
                                }
                                else{
                                    System.out.println("YOU SELECTED TO BOOK A RIDE");
                                    System.out.println("ENTER THE STARTING POINT");
                                    b1.source=sc.nextLine();
                                    System.out.println("ENTER THE DESTINATION");
                                    b1.destination=sc.nextLine();
                                    System.out.println("ENTER THE DISTANCE IN KM");
                                    b1.total_km=sc.nextInt();

                                    b1.show1();
                                    b1.choice();
                                    fair.fair();

                                }    
                            }
                            else{
                                System.out.println("YOU EXITED");
                            }
                            
                            break; 
                        }
                    }
                    if (!found)
                        System.out.println("Invalid username or password!");

                    break;

                case 4:
                    acceptbooking ac = new acceptbooking();
                    
                    
                    System.out.println("\n--- DRIVER LOGIN ---");
                    System.out.print("ENTER USERNAME: ");
                    String dname = sc.nextLine();
                    System.out.print("ENTER PASSWORD: ");
                    String dpass = sc.nextLine();

                    boolean dfound = false;
                    for (driver d1 : driverlist) {
                        if (d1.dusername.equals(dname) && d1.getdpassword().equals(dpass)) {
                            System.out.println("Login successful! Welcome, Driver " + d1.dusername);
                            dfound = true;
                            if (currentBooking == null) {
                                System.out.println("No active booking found! Please wait for a user to book a ride.");
                            } else {
                                ac.choice = currentBooking.choice;
                                ac.total_km = currentBooking.total_km;
                                ac.source = currentBooking.source;
                                ac.destination = currentBooking.destination;

                                ac.acceptbooking();
                            }
                            break;
                        }
                    }
                    if (!dfound)
                        System.out.println("Invalid driver credentials!");
                    break;

                case 5:
                    System.out.println("\nThank you for using OLA UBER!");
                    break;

            }


        } while (option != 5);

        sc.close();
        System.out.println("code is running");
    }
} 
