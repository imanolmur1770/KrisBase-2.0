package Tools;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class TableLinker {
    public static void TableLink(ArrayList<Book> BookList, DefaultTableModel dtm){
        //variables for the read/non/total
        try {
            for (Book book : BookList) {
                Object[] objs = {book.getBookName(), book.getAuthor(), book.getGenre(), book.getRead(), book.getRating(), book.getBarcode()};
                dtm.addRow(objs);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
