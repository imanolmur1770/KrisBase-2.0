import Tools.MessageDialog;

import javax.swing.*;

public class loginPage extends JFrame{
    private JPanel rootPanel;
    private JPanel buttonPanel;
    private JPanel textfieldPanel;
    private JPanel labelPanel;
    private JPasswordField passwordField1;
    private JButton loginButton;
    private JButton exitButton;
    private JLabel titleLabel;
    private JLabel versionLabel;
    private JLabel passwordLabel;
    private JLabel outputLabel;
    private static String key = "Kriscake.7";

    //login page with all it functions
    public loginPage(String title) {
        //setting the frame for the gui
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(rootPanel);
        this.setSize(840, 720); // size of frame
        this.setLocationRelativeTo(null);

        passwordField1.addActionListener(e -> {
            String result = passwordField1.getText();
            if(result.equals(key)){
                setVisible(false);
                new menuPage("MENU").setVisible(true);
            }
            else{
                //display wrong to try again if key does not equal input
                outputLabel.setText("Wrong! Try Again");
                MessageDialog.failedLogin();
            }
        });
        loginButton.addActionListener(e -> {
            String result = passwordField1.getText();
            if(result.equals(key)){
                setVisible(false);
                new menuPage("MENU").setVisible(true);
            }
            else{
                //display wrong to try again if key does not equal input
                outputLabel.setText("Wrong! Try Again");
                MessageDialog.failedLogin();
            }
        });
        exitButton.addActionListener(e -> {
            //close frame
            System.exit(0);
        });
    }
    //main
    public static void main(String[] args) {
        //running the frame
        JFrame Frame = new loginPage("LOGIN");
        Frame.setVisible(true);
    }

}
