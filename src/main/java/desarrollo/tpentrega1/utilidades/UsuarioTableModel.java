
package desarrollo.tpentrega1.utilidades;

import desarrollo.tpentrega1.entidades.Cliente;
import javax.swing.table.AbstractTableModel;
import java.lang.reflect.Field;
import java.util.List;

public class UsuarioTableModel<T> extends AbstractTableModel {
    private List<T> data; 
    private String[] columnNames; 
    private Field[] fields; 
    
    public UsuarioTableModel(List<T> data, String[] columnNames) {
        this.data = data;
        this.columnNames = columnNames;
        
        
        if (!data.isEmpty()) {
            fields = data.get(0).getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true); 
            }
        }
    }

    @Override
    public int getRowCount() {
        return data.size(); 
    }

    @Override
    public int getColumnCount() {
        return columnNames.length; 
    }

        @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        T rowObject = data.get(rowIndex);

        try {
            if (rowObject instanceof Cliente) {
                
                Cliente cliente = (Cliente) rowObject;
                switch (columnIndex) {
                    case 0 -> {
                        return cliente.getId();
                    }
                    case 1 -> {
                        return cliente.getNombre();
                    }
                    case 2 -> {
                        return cliente.getCuit();
                    }
                    case 3 -> {
                        return cliente.getEmail();
                    }
                    case 4 -> {
                        return cliente.getDireccion();
                    }
                    case 5 -> {
                        return cliente.getCoordenada().getLat();
                    }
                    case 6 -> {
                        return cliente.getCoordenada().getLng();
                    }
                    case 7 -> {
                        return "Editar";
                    }
                    case 8 -> {
                        return "Borrar";
                    }
                }
            } else {
                rowObject = data.get(rowIndex); 
                return fields[columnIndex].get(rowObject);
            }
        } catch (IllegalAccessException e) {
        }
        return null;
    }
    

    @Override
    public String getColumnName(int column) {
        return columnNames[column]; 
    }


    @Override
    public boolean isCellEditable(int row,int col){
       return false; 
    }
    
}
