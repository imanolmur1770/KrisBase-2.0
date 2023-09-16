package Tools;
import javax.swing.*;
import java.net.URL;

public class MessageDialog {
    public static void searchMSG(){
        try {
            ImageIcon icon = new ImageIcon(new URL("https://icons.iconarchive.com/icons/gakuseisean/ivista-2/72/Start-Menu-Search-icon.png"));
            JOptionPane.showMessageDialog(null, "Searching...", "Search", JOptionPane.PLAIN_MESSAGE,icon);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error: Unable to Retrieve image URL.", "Error",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    public static void noBookFoundMSG(){
        try{
            ImageIcon icon = new ImageIcon(new URL("https://icons.iconarchive.com/icons/gakuseisean/ivista-2/72/Misc-Delete-Database-icon.png"));
            JOptionPane.showMessageDialog(null, "Error: No Books found! Please Try Again.", "Error", JOptionPane.PLAIN_MESSAGE,icon);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error: Unable to Retrieve image URL.", "Error",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    public static void listNotSaveMSG(){
        try{
            ImageIcon icon = new ImageIcon(new URL("https://icons.iconarchive.com/icons/papirus-team/papirus-status/72/dialog-warning-icon.png"));
            JOptionPane.showMessageDialog(null, "Warning: Could not save because there are no books in the Table! Please Try Again.", "Warning", JOptionPane.PLAIN_MESSAGE,icon);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error: Unable to Retrieve image URL.", "Error",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    public static void bookFoundMSG(){
        try{
            ImageIcon icon = new ImageIcon(new URL("https://icons.iconarchive.com/icons/custom-icon-design/flatastic-9/72/Accept-icon.png"));
            JOptionPane.showMessageDialog(null, "Success! Found book(s).", "Found", JOptionPane.PLAIN_MESSAGE,icon);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error: Unable to Retrieve image URL.", "Error",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    public static void listSaveMSG(){
        try{
            ImageIcon icon = new ImageIcon(new URL("https://icons.iconarchive.com/icons/custom-icon-design/flatastic-9/72/Accept-icon.png"));
            JOptionPane.showMessageDialog(null, "Success! Saved book(s).", "Saved", JOptionPane.PLAIN_MESSAGE,icon);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error: Unable to Retrieve image URL.", "Error",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    public static void newFileMSG(){
        try{
            ImageIcon icon = new ImageIcon(new URL("https://icons.iconarchive.com/icons/hopstarter/mac-folders/72/Documents-icon.png"));
            JOptionPane.showMessageDialog(null, "We had to make a new file. It is saved under BookList.txt.", "New File", JOptionPane.PLAIN_MESSAGE,icon);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error: Unable to Retrieve image URL.", "Error",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    public static void bookDeleteMSG(){
        try{
            ImageIcon icon = new ImageIcon(new URL("https://icons.iconarchive.com/icons/custom-icon-design/flatastic-9/72/Accept-icon.png"));
            JOptionPane.showMessageDialog(null, "Success! Book has been deleted.", "Delete", JOptionPane.PLAIN_MESSAGE,icon);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error: Unable to Retrieve image URL.", "Error",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    public static void bookNotDeleteMSG(){
        try{
            ImageIcon icon = new ImageIcon(new URL("https://icons.iconarchive.com/icons/oxygen-icons.org/oxygen/72/Status-dialog-error-icon.png"));
            JOptionPane.showMessageDialog(null, "Error: Could not delete book! Please Try Again.", "Delete Error", JOptionPane.PLAIN_MESSAGE,icon);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error: Unable to Retrieve image URL.", "Error",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    public static void bookExist(){
        try{
            ImageIcon icon = new ImageIcon(new URL("https://icons.iconarchive.com/icons/oxygen-icons.org/oxygen/72/Status-dialog-error-icon.png"));
            JOptionPane.showMessageDialog(null, "Error: Could not add book! Book exist already. Please Try Again.", "Add Error", JOptionPane.PLAIN_MESSAGE,icon);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error: Unable to Retrieve image URL.", "Error",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    public static void bookSave(){
        try{
            ImageIcon icon = new ImageIcon(new URL("https://icons.iconarchive.com/icons/custom-icon-design/flatastic-9/72/Accept-icon.png"));
            JOptionPane.showMessageDialog(null, "Success! Added book(s).", "Added", JOptionPane.PLAIN_MESSAGE,icon);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error: Unable to Retrieve image URL.", "Error",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    public static void emptyField(){
        try{
            ImageIcon icon = new ImageIcon(new URL("https://icons.iconarchive.com/icons/oxygen-icons.org/oxygen/72/Status-dialog-error-icon.png"));
            JOptionPane.showMessageDialog(null, "Error: Could not add book! Book fields are empty. Please Try Again.", "Empty Field(s)", JOptionPane.PLAIN_MESSAGE,icon);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error: Unable to Retrieve image URL.", "Error",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    public static void failedLogin(){
        try{
            ImageIcon icon = new ImageIcon(new URL("https://icons.iconarchive.com/icons/oxygen-icons.org/oxygen/72/Status-dialog-error-icon.png"));
            JOptionPane.showMessageDialog(null, "Error: Could not login! Incorrect login. Please Try Again.", "Login Failure", JOptionPane.PLAIN_MESSAGE,icon);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error: Unable to Retrieve image URL.", "Error",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    public static int confirmMessage(){
        return JOptionPane.showConfirmDialog(null, "Are you sure");
    }

    public static void failedListGet(){
        try{
            ImageIcon icon = new ImageIcon(new URL("https://icons.iconarchive.com/icons/oxygen-icons.org/oxygen/72/Status-dialog-error-icon.png"));
            JOptionPane.showMessageDialog(null, "Error: Could not find BookList. Please Try Again.", "File finder Failure", JOptionPane.PLAIN_MESSAGE,icon);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error: Unable to Retrieve image URL.", "Error",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

}
