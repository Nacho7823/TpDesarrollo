package desarrollo.tpentrega1.utilidades;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class GestionCeldas extends DefaultTableCellRenderer{
	
	private String tipo="text";

	private Font normal = new Font("Verdana",Font.PLAIN,12);
	private Font bold = new Font("Verdana",Font.BOLD,12);
	private JLabel label = new JLabel();
        
	private ImageIcon iconoEditar = new ImageIcon("icons8-editar-fila-40.png");
        private ImageIcon iconoBorrar = new ImageIcon("icons8-borrar-fila-40.png");
	
	public GestionCeldas(){
		
	}
        
	public GestionCeldas(String tipo){
            this.tipo=tipo;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
	
        Color colorFondo = null;
        Color colorFondoPorDefecto=new Color(192, 192, 192);
        Color colorFondoSeleccion=new Color(140, 140, 140);
        
        if (selected) this.setBackground(colorFondoPorDefecto);
        else this.setBackground(Color.white);
        
        if( tipo.equals("texto")){
            if (focused) colorFondo=colorFondoSeleccion;
            else colorFondo= colorFondoPorDefecto;
            this.setHorizontalAlignment(JLabel.LEFT);
            this.setText((String) value);
            this.setBackground( (selected)? colorFondo :Color.WHITE);	
            this.setFont(normal);
            return this;
        }
        if( tipo.equals("icono")){
            if(String.valueOf(value).equals("Borrar")) label.setIcon(iconoBorrar);
            else if(String.valueOf(value).equals("Editar")) label.setIcon(iconoEditar);
            label.setHorizontalAlignment(JLabel.LEFT);
            label.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
            return label;
        }
        if(tipo.equals("numerico")){           
            if (focused) colorFondo=colorFondoSeleccion;
            else colorFondo=colorFondoPorDefecto;
            this.setHorizontalAlignment( JLabel.CENTER );
            this.setValue(value);
            this.setForeground((selected)? new Color(255,255,255) :new Color(32,117,32));    
            this.setBackground((selected)? colorFondo :Color.WHITE);
            this.setFont(bold);            
            return this;   
        }
        return this;
    }
}