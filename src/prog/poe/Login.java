/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.poe;


/**
 *
 * @author RC_Student_lab
 */
public class Login {
    private String username;
    private String password;
    private String cellPhoneNumber;
    private String firstname;
    private String lastname;
    
    public Login(String username,String password,String cellPhoneNumber,String firstname,String lastname){
        this.username = username;
        this.password = password;
        this.cellPhoneNumber = cellPhoneNumber;
        this.firstname = firstname;
        this.lastname = lastname;
    }
    
    public boolean checkUsername(){
        return username.contains("_")&& username.length() <=5;
     }
    public boolean checkPasswordComplexity(){
        return password.length() >= 8 &&
                password.matches(".*[A-Z].*")&&
                password.matches(".*[0-9].*")&&
                password.matches(".*[!@#$%^&*(),.?\":{}|<>].*");
    }
    
    public boolean checkcellPhoneNumber(){
        return cellPhoneNumber.matches("^\\+\\d{1,3}\\d{7,10}$");
    }
   public String registerUser(){
       if(!checkUsername()){
           System.out.print( "username is not the correctly formatted, please ensure that  your username contains an underscore and no more than five characterstics in length.");
       } 
       if(!checkPasswordComplexity()){        
           System.out.print ("Password is not correctly formatted, please ensure that your password contains at least eight characters, a  letter,a number and a special character.");

       }
       if(!checkcellPhoneNumber()){
           System.out.print( "cellPhoneNumber incorrectly formatted,or does not contain international code.");
           
        
       }
       return "User successfully registered.";
       
    }
   public boolean loginUser(String username,String password){
       return this.username.equals(username)&& this.password.equals(password);
   }
    public String returnLoginstatus(String username, String password){
        if(loginUser(username,password)){
            return"Welcome" + firstname+""+lastname+",it is greet to see you again.";
        } else{
         return"username or password incorrect, please try again.";        
                          
      
        }
    }
            
    
}
