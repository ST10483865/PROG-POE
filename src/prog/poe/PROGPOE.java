
package prog.poe;

import javax.swing.JOptionPane;

/**
 *
 * @author RC_Student_lab
 */
public class PROGPOE {

    private static Login login = new Login();
    private static Message message = new Message();
    
    public static void main(String[] args) {        
       //==registration header===
       String Username = JOptionPane.showInputDialog("Enter username:max 5 chars & must include'_':");
       String Password = JOptionPane.showInputDialog("Enter password:\n(8+ chars, 1 captital, 1 number, 1 special char)");   
       String Cell= JOptionPane.showInputDialog("Enter cellphoneNumber(e.g. +27856908724):");
       String Firstname= JOptionPane.showInputDialog("Enter firstname:");
       String Lastname= JOptionPane.showInputDialog("Enter lastname:");
        
       login.setUsername(Username);
       login.setPassword(Password);
       login.setCellNumber(Cell);
       login.setfirstname(Firstname);
       login.setLastname(Lastname);
       
       JOptionPane.showConfirmDialog(null, login.registerUser());
       
       //=====Login=====
       String loginUsername= JOptionPane.showInputDialog("Login - Enter username:");
       String loginPassword= JOptionPane.showInputDialog("Login - Enter password:");
       
       login.setLoginUsername(loginUsername);
       login.setLoginpassword(loginPassword);
       
       if (login.loginUser()){
           JOptionPane.showMessageDialog(null,login.returnLoginstatus());
           
           //====Messagin System====
           JOptionPane.showMessageDialog(null,"Welcome to Quickchat");
           String numMessagesStr = JOptionPane.showInputDialog("How many messages would you like to send.");
           int numMessages;
           try{
               numMessages = Integer.parseInt(numMessagesStr);
           }catch(NumberFormatException e){
               JOptionPane.showMessageDialog(null, "Invaild number.Defaulting to 1 message.");
               numMessages =1; 
           }
           
           //main application loop
           boolean running = true;
           int messagesSent = 0;
           
           while (running){
               String[]options ={"Send Messages","Show recently sent messages","Display Reports","Quit"};
               int choice = JOptionPane.showOptionDialog(null,
                       "Select an Option:",
                       "QuickChat Menu",
                       JOptionPane.DEFAULT_OPTION,
                       JOptionPane.INFORMATION_MESSAGE ,
                       null,
                       options,
                       options[0]);               
                                  
               switch (choice){
                   case 0: //Send Messages
                       if (messagesSent < numMessages){
                           sendMessage();
                           messagesSent++;
                                   if (messagesSent >= numMessages){
                           JOptionPane.showMessageDialog(null,
                                   "You have sent" + Message.returnTotalMessages() + "messages.");
                       }
                       }else{
                           JOptionPane.showMessageDialog(null,
                                   "You have reached your message limit of" + numMessages +"messages.");
                       }
                       break;
                       
                   case 1:// show recently sent messages
                       showRecentMessages();
                       break;
                       
                   case 2: //Display Reports
                       displayReportsMenu();
                       break;
                       
                   case 3://Quit
                   case -1: //Window Closed
                       running = false;
                       break;
                       
           }         
        } 
         JOptionPane.showMessageDialog(null, "Thank you for using QuickChat.");
       }else{
           JOptionPane.showMessageDialog(null,login.returnLoginstatus());
       }
    }
    private static void sendMessage(){
        String recipient = JOptionPane.showInputDialog("Enter recipient's cell phone number(e.g +27678766452):");
        if (recipient == null || recipient.trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Message cannot be empty");
            return;
        }
        String messageText = JOptionPane.showInputDialog("Enter your message(max 250 characters):");
        if (messageText == null || messageText.trim().isEmpty()){
            JOptionPane.showMessageDialog(null,"Message cannot be empty.");
            return;
        }
        
        String result = message.sendMessage(recipient,messageText);
        JOptionPane.showMessageDialog(null,result);                       
    }
    private static void showRecentMessages(){
        String recentMessages = message.displaySentMessages();
        JOptionPane.showMessageDialog(null,recentMessages,"Recently Sent Messages" , JOptionPane.INFORMATION_MESSAGE);
    }
        private static void displayReportsMenu(){                       
            String[] reportOptions = {
                "View All Messages Report",
                "Find Longest Message",
                "Search Message by ID",
                "Search Messages by Recipient",
                "Delete Message by Hash",
                "Back to Main Menu"
        };
            int choice = JOptionPane.showOptionDialog(null,
                    "Select Report Option:",
                    "Report Menu",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    reportOptions,
                    reportOptions[0]);
            
            
            switch (choice){
                case 0://View All Messages Report
                    String report = message.displayReport();
                    JOptionPane.showMessageDialog(null,report,"Full Report",JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 1: //find Longest Message
                    String longest = message.findLongestMessage();
                    JOptionPane.showMessageDialog(null, "Longest message:" +  longest, "Longest Message",JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 2://Search Message by ID
                    String searchID = JOptionPane.showInputDialog("Enter Message ID to search:");
                    if (searchID !=null && !searchID.trim().isEmpty()){
                        String result = message.searchMessageByID(searchID);
                        JOptionPane.showMessageDialog(null, result,"Search Result",JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;
                case 3:// Search Messages by Recipient
                    String searchRecipient = JOptionPane.showInputDialog("Enter recipient to search:");
                    if (searchRecipient != null&& !searchRecipient.trim().isEmpty()){
                        String result = message.searchMessagesByRecipient(searchRecipient);
                        JOptionPane.showMessageDialog(null, result,"Message for" + searchRecipient,JOptionPane.INFORMATION_MESSAGE);                        
                    }
                    break;
                case 4: //Delete Message by Hash
                    String hash = JOptionPane.showInputDialog("Enter Message Hash to delete:");
                    if (hash != null && !hash.trim().isEmpty()){
                        String result = message.deleteMessageByHash(hash);
                        JOptionPane.showMessageDialog(null, result,"Delete Result",JOptionPane.INFORMATION_MESSAGE);                        
                    }
                    break;
                case 5: //Back to Main Menu
                case -1://Window Closed
                    break;
                         
                    
            
        }
    }
}
       
               
       
         
  
           

           
         