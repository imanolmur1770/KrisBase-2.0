import Data.getData;
import Tools.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class newBooksPage extends JFrame{
    private JPanel rootPanel;
    private JLabel titleLabel;
    private JTable Table;
    private JTextField bookNameTextField;
    private JTextField authorTextField;
    private JTextField genreTextField;
    private JTextField readTextField;
    private JTextField ratingTextField;
    private JTextField barcodeTextField;
    private JLabel bookNameLabel;
    private JLabel authorLabel;
    private JLabel genreLabel;
    private JLabel readLabel;
    private JLabel ratingLabel;
    private JLabel barcodeLabel;
    private JButton exitButton;
    private JButton deleteButton;
    private JButton addButton;
    private JButton backButton;
    private int row;

    //runs on the main
    public newBooksPage(String title, ArrayList<Book> BookList, DefaultTableModel dtm) {
        //set frame
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(rootPanel);
        this.setSize(840, 720);
        this.setLocationRelativeTo(null);
        //The frame is in the middle of screen
        //set table and call method
        //dtm = new DefaultTableModel(header,0);
        Table.setModel(dtm);
        backButton.addActionListener(e -> {
            setVisible(false);
            new menuPage("MENU").setVisible(true);
        });
        exitButton.addActionListener(e -> {
            //exit
            System.exit(0);
        });
        deleteButton.addActionListener(e -> {
            int result = MessageDialog.confirmMessage();
            if(result == 0) {
                row = Table.getSelectedRow();
                String barText = (String) dtm.getValueAt(row, 5);
                try {
                    getData.deleteBooks(barText);
                    dtm.removeRow(row);
                    MessageDialog.bookDeleteMSG();
                } catch (Exception ex) {
                    MessageDialog.bookNotDeleteMSG();
                    ex.printStackTrace();
                }
            }
        });
        addButton.addActionListener(e -> addingBooks(dtm));

        //listeners to move to the correct text box upon key hits
        bookNameTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode()==40){
                    authorTextField.requestFocus();
                }
            }
        });
        authorTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode()==40){
                    genreTextField.requestFocus();
                }
                else if(e.getKeyCode()==38){
                    bookNameTextField.requestFocus();
                }
            }
        });
        genreTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode()==40){
                    readTextField.requestFocus();
                }
                else if(e.getKeyCode()==38){
                    authorTextField.requestFocus();
                }
            }
        });
        readTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode()==40){
                    ratingTextField.requestFocus();
                }
                else if(e.getKeyCode()==38){
                    genreTextField.requestFocus();
                }
            }
        });
        ratingTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode()==40){
                    barcodeTextField.requestFocus();
                }
                else if(e.getKeyCode()==38){
                    readTextField.requestFocus();
                }
            }
        });
        barcodeTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode()==38){
                    ratingTextField.requestFocus();
                }
            }
        });
        barcodeTextField.addActionListener(e -> addingBooks(dtm));
    }
    public void addingBooks(DefaultTableModel dtm){
        //check if fields are filled
        boolean result3 = isExisting.fieldsAreFilled(bookNameTextField,authorTextField,genreTextField,
                readTextField,ratingTextField,barcodeTextField);
        if(result3) {
            //make book object
            Book newBook = new Book(bookNameTextField.getText(), authorTextField.getText(),
                    genreTextField.getText(), readTextField.getText(), ratingTextField.getText(),
                    barcodeTextField.getText());
            //check if it exist in table and can be added to database
            if(dtm.getRowCount() > 0){
                if(!isExisting.existInTable(barcodeTextField.getText(),dtm) && getData.addingBooks(newBook)){
                    //if yes then add to table
                    String[] data = {bookNameTextField.getText(), authorTextField.getText(),
                            genreTextField.getText(), readTextField.getText(), ratingTextField.getText(),
                            barcodeTextField.getText()};
                    dtm.addRow(data);
                    //show it saved and clear fields
                    MessageDialog.bookSave();
                    Clear.clearTextField(bookNameTextField,authorTextField,genreTextField,
                            readTextField,ratingTextField,barcodeTextField);
                } else {
                    //if book exisrs in table and cannot go to database
                    MessageDialog.bookExist();
                }
            }
            else if(dtm.getRowCount() == 0){
                if(getData.addingBooks(newBook)){
                    //if yes then add to table
                    String[] data = {bookNameTextField.getText(), authorTextField.getText(),
                            genreTextField.getText(), readTextField.getText(), ratingTextField.getText(),
                            barcodeTextField.getText()};
                    dtm.addRow(data);
                    //show it saved and clear fields
                    MessageDialog.bookSave();
                    Clear.clearTextField(bookNameTextField,authorTextField,genreTextField,
                            readTextField,ratingTextField,barcodeTextField);
                } else {
                    //if book exisrs in table and cannot go to database
                    MessageDialog.bookExist();
                }
            }

        }
        else{
            //field is empty
            MessageDialog.emptyField();
        }
    }
}
