
package prog.poe;

import java.util.Scanner;

/**
 *
 * @author RC_Student_lab
 */
public class PROGPOE {

    
    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       
       System.out.println("=== User Registration ===");
       System.out.print("Enter username: ");
       String username = input.nextLine();
       
       System.out.print("Enter password:");
       String password = input.nextLine();
       
       System.out.print("Enter cellphoneNumber(e.g., +27856908724):");
       String cellphoneNumber = input.nextLine();
       
       System.out.print("Enter firstname:");
       String firstname = input.nextLine();
       
       System.out.print("Enter lastname:");
       String lastname = input.nextLine();
       
       Login User = new Login(username,password,cellphoneNumber,firstname,lastname);
       String registrationMessage = User.registerUser();
       
       if(registrationMessage.equals("User successfully registered.")){
           System.out.println("\n=== User Login ===");
           System.out.print("Enter username:");
           String loginUsername = input.nextLine();
           
           System.out.print("Enter password:");
           String loginPassword = input.nextLine();
           
           String loginMessage = User.returnLoginstatus(loginUsername,loginPassword);
           System.out.println(loginMessage);
       }
    }
    
}
