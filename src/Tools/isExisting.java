package Tools;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Locale;

public class isExisting {
    public static boolean existInTable(String barcode, DefaultTableModel dtm){
        boolean result = false;
        for(int i = 0; i<dtm.getRowCount();i++){
            if(barcode.toLowerCase(Locale.ROOT).equals(dtm.getValueAt(i,5))){
                result = true;
                break;
            }
        }
        return result;
    }
    public static boolean fieldsAreFilled(JTextField bn, JTextField au, JTextField ge, JTextField re,
                                          JTextField ra, JTextField ba){
        boolean result = true;
        if(bn.getText().isEmpty() || au.getText().isEmpty() || ge.getText().isEmpty() || re.getText().isEmpty()
                || ra.getText().isEmpty() || ba.getText().isEmpty()){
            result = false;
        }
        return result;
    }
}
