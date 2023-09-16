import Tools.Book;
import Tools.TableLinker;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class dataBooksPage extends JFrame{
    private JPanel rootPanel;
    private JLabel titleLabel;
    private JTable Table;
    private JComboBox comboBox1;
    private JButton backButton;
    private JButton exitButton;
    private JProgressBar progressBar1;
    private JLabel readJLabel;
    private JLabel nonreadJLabel;

    public dataBooksPage(String title, ArrayList<Book> BookList, DefaultTableModel dtm){
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
        int recount = 0;
        int nocount = 0;
        for(int i = 0; i<BookList.size();i++){
            if(BookList.get(i).getRead().toLowerCase(Locale.ROOT).equals("yes")){
                recount++;
            }
            if(BookList.get(i).getRead().toLowerCase(Locale.ROOT).equals("no")){
                nocount++;
            }
        }
        readJLabel.setText("Read: "+recount);
        nonreadJLabel.setText("Nonread: "+nocount);
        //set table and call method
        //dtm = new DefaultTableModel(header,0);
        Table.setModel(dtm);
        //Links Table to with ArrayList
        TableLinker.TableLink(BookList,dtm);
        progressBar1.setValue(0);
        progressBar1.setStringPainted(true);
        fill(recount);
        exitButton.addActionListener(e -> {
            //exit
            System.exit(0);
        });
        backButton.addActionListener(e -> {
            setVisible(false);
            new menuPage("MENU").setVisible(true);
        });
        comboBox1.addActionListener(e -> {
            //get selected index from comboBox
            int GTDB = comboBox1.getSelectedIndex();
            //sort Book
            TableRowSorter<TableModel> sorter = new TableRowSorter<>(Table.getModel());
            Table.setRowSorter(sorter);
            List<RowSorter.SortKey> sortKeys = new ArrayList<>(25);
            sortKeys.add(new RowSorter.SortKey(GTDB-1, SortOrder.ASCENDING));
            sorter.setSortKeys(sortKeys);
        });
    }

    public void fill(int count){
        progressBar1.setMaximum(267);
        progressBar1.setValue(count);
    }
}
