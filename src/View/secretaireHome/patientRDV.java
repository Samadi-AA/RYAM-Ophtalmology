package view.secretaireHome;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class patientRDV {
	
	public patientRDV() {
		
	}
	
	public JScrollPane getView() {
		 JTable table;
	        
	        //JPanel panebutton=new JPanel();
	        
	        Object[][]list= {{"JC203050","Ayman","Alkazdir","19/07/2021",""},{"JC203050","Ayman","Alkazdir","19/07/2021",""}
	        ,{"JC203050","Ayman","Alkazdir","19/07/2021",""},{"JC203050","Ayman","Alkazdir","19/07/2021",""}
	        ,{"JC203050","Ayman","Alkazdir","19/07/2021",""},{"JC203050","Ayman","Alkazdir","19/07/2021",""}
	        ,{"JC203050","Ayman","Alkazdir","19/07/2021",""},{"JC203050","Ayman","Alkazdir","19/07/2021",""}
	        ,{"JC203050","Ayman","Alkazdir","19/07/2021", ""},{"JC203050","Ayman","Alkazdir","19/07/2021",""}
	        ,{"JC203050","Ayman","Alkazdir","19/07/2021",""},{"JC203050","Ayman","Alkazdir","19/07/2021",""}};
	        
	        String []head= {"CIN","NOM","PRENOM","DATE DE RDV","AUTRE"};
	        
	        
	        table=new JTable(list,head);
	           table.setBackground(Color.lightGray);
	        
	        
	    
	        
	           table.getColumnModel().getColumn(4).setCellRenderer(new MyRenderer());
	   		table.setRowHeight(45);
	   	    TableColumn col4=table.getColumnModel().getColumn(4);
	   	     col4.setPreferredWidth(350);     
	        
	   JScrollPane scrollPane = new JScrollPane(table);
	  
	    return scrollPane;

	}
	
	class MyRenderer implements TableCellRenderer {

	    JButton button1,button2,button3;
	    JPanel pane;
	    public MyRenderer() {
	        pane=new JPanel(new FlowLayout());
	        
	        
	        button1 = new JButton();
	        button1.setSize(new Dimension(26,26));
			button1.setIcon(new ImageIcon("icons/delete.png"));
			
	     
			 // propereite de button2
	     
	        button2 = new JButton();
			button2.setSize(new Dimension(26,26));
			button2.setIcon(new ImageIcon("icons/edit.png"));
			
	     
			 // propereite de button2
	  
	        button3 = new JButton();
			button3.setSize(new Dimension(26,26));
			button3.setIcon(new ImageIcon("icons/valide.png"));
	     
	     
	     
	     pane.add(button3);
	     pane.add(button2);
	     pane.add(button1);
	     pane.setSize(200, 50);
	     
	     
	     
	     
	    }
	    public Component getTableCellRendererComponent(JTable table,
	            Object obj,
	            boolean isSelected,
	            boolean Focus,
	            int row, int column) {
	         
	        
	        return pane;
	    }
	    
	    }

	}  


