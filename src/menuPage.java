import Data.getData;
import Tools.Book;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class menuPage extends JFrame{
    private JPanel rootPanel;
    private JLabel titleLabel;
    private JButton logoutButton;
    private JButton exitButton;
    private JButton newBooksButton;
    private JButton viewBooksButton;
    private JButton dataBooksButton;
    //Default table model
    ArrayList<Book> BookList;
    //delete button when editing
    String[] header = new String[]{"Name","Author","Genre","Read","Rating","Barcode"};
    //JTable
    JTable Table = new JTable();
    //header of the JTable
    DefaultTableModel dtm;

    //runs on the main
    public menuPage(String title) {
        //set frame
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(rootPanel);
        this.setSize(840, 720);
        this.setLocationRelativeTo(null);
        //The frame is in the middle of screen
        dtm = new DefaultTableModel(header, 0);
        BookList = getData.gettingBooks();

        //Make object and send it across buttons
        logoutButton.addActionListener(e -> {
            //logout
            setVisible(false);
            new loginPage("LOGIN").setVisible(true);
        });
        exitButton.addActionListener(e -> {
            //exit
            System.exit(0);
        });
        viewBooksButton.addActionListener(e -> {
            //Checkout
            setVisible(false);
            new viewBooksPage("VIEW-BOOKS", BookList, dtm).setVisible(true);
        });
        newBooksButton.addActionListener(e -> {
            //new books
            setVisible(false);
            new newBooksPage("NEW-BOOKS", BookList, dtm).setVisible(true);
        });
        dataBooksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //new books
                setVisible(false);
                new dataBooksPage("DATA-BOOKS", BookList, dtm).setVisible(true);
            }
        });
    }
}
