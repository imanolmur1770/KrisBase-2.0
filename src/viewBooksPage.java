import Data.getData;
import Tools.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.InputMethodListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Locale;

public class viewBooksPage extends JFrame{
    private JPanel rootPanel;
    private JTable Table;
    private JTextField searchTextField;
    private JComboBox choiceBox;
    private JLabel titleJLabel;
    private JButton backButton;
    private JButton saveButton;
    private JButton deleteButton;
    private JButton exitButton;
    private JLabel outputLabel;
    int row,col;

    public viewBooksPage(String title, ArrayList<Book> BookList, DefaultTableModel dtm){
        //set frame
        super(title);
        //puts title on top of frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //exit on close
        this.setContentPane(rootPanel);
        //root panel is content of frame
        this.setSize(840,720);
        //size of frame
        this.setLocationRelativeTo(null);
        //set table and call method
        //dtm = new DefaultTableModel(header,0);
        Table.setModel(dtm);
        //Links Table to with ArrayList
        Object[] obj = {"Count:", BookList.size(),"","","",""};
        dtm.addRow(obj);
        TableLinker.TableLink(BookList,dtm);
        final int[] chk = {0};

        backButton.addActionListener(e -> {
            setVisible(false);
            new menuPage("MENU").setVisible(true);
        });
        saveButton.addActionListener(e -> {
                for (int i = 0; i < dtm.getRowCount(); i++) {
                    String bn = (String) dtm.getValueAt(i, 0);
                    String au = (String) dtm.getValueAt(i, 1);
                    String ge = (String) dtm.getValueAt(i, 2);
                    String re = (String) dtm.getValueAt(i, 3);
                    String ra = (String) dtm.getValueAt(i, 4);
                    String ba = (String) dtm.getValueAt(i, 5);
                    try {
                        getData.updateBooks(bn, au, ge, re, ra, ba);
                    }catch (Exception ex){
                        MessageDialog.listNotSaveMSG();
                    }
                }
                MessageDialog.listSaveMSG();
                setVisible(false);
                new menuPage("MENU").setVisible(true);
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
        exitButton.addActionListener(e -> {
            //exit
            System.exit(0);
        });
        searchTextField.addActionListener(e -> {
            //get selected index
            String result1 = searchTextField.getText();
            int GTDB = choiceBox.getSelectedIndex();
            String result2 = "";
            //clear
            dtm.setRowCount(0);
            //search
            MessageDialog.searchMSG();
            for (Book book : BookList) {
                switch (GTDB) {
                    case 1 -> result2 = book.getBookName();
                    case 2 -> result2 = book.getAuthor();
                    case 3 -> result2 = book.getGenre();
                    case 4 -> result2 = book.getRead();
                    case 5 -> result2 = (book.getRating());
                    case 6 -> result2 = book.getBarcode();
                }
                if (result2.toLowerCase(Locale.ROOT).contains(result1.toLowerCase(Locale.ROOT))) {
                    String[] data = {book.getBookName(), book.getAuthor(),
                            book.getGenre(), book.getRead(), String.valueOf(book.getRating()),
                            book.getBarcode(),};
                    dtm.addRow(data);
                }
            }
            chk[0] = dtm.getRowCount();
            if(chk[0] ==0){
                MessageDialog.noBookFoundMSG();
            }
            else
                MessageDialog.bookFoundMSG();
        });
        choiceBox.addActionListener(e -> {
            //print label
            String result = (String) choiceBox.getSelectedItem();
            outputLabel.setText(result);
        });
        Table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                row = Table.getSelectedRow();
                col = Table.getSelectedColumn();
            }
        });
    }
}
