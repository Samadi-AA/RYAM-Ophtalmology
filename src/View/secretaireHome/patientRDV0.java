package view.secretaireHome;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import control.DatabaseConnection;

public class patientRDV0  {
	
	 Object[] RowElement;
	 JPanel panel;
	 JTable table;
	 Object [][]list = null; 
	 DefaultTableModel model;
	
	public  patientRDV0() {
		
	}
	
	
	 public JPanel getView() {
		 
	      panel =new JPanel();
		  
		  String []head= {"CIN","NOM","PRENOM","DATE DE RDV","AUTRE"};
	        
	        
		 try {
				RowElement = RemplierTable();
			 } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			 } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			 }
	      
	
	        // Cette methode pour non modife pas les informations de tableau
	        
	           model= new DefaultTableModel(list,head) {
	       		
	       		boolean tablebol[]= {false,false,false,false,true};
	       		
	       		
	       	    public boolean isCellEditable(int row,int col) {
	       			   return tablebol[col];
	       		   }
	       		
	       	};	
	      
	        
	    	// remplier les linges de tableau
	       	
			   	 model.addRow(RowElement);
			   	 model.addRow(RowElement);
			   	 model.addRow(RowElement);
			   	 model.addRow(RowElement);
			   	 model.addRow(RowElement);
			   	 model.addRow(RowElement);
			   	 model.addRow(RowElement);
			   	 model.addRow(RowElement);
			   	 model.addRow(RowElement);
			   	 model.addRow(RowElement);
	        
		         table=new JTable(model);
		         table.setBackground(Color.lightGray);
	       	
	          //  specifier la colonne qui va mettre la class MyRenderer 
	             table.getColumnModel().getColumn(4).setCellRenderer(new MyRenderer());
	   		     table.setRowHeight(45);
	   		 //   specifier la colonne qui va mettre la class ButtonEditor 
	   		     table.getColumnModel().getColumn(4).setCellEditor(new ButtonEditor(new JTextField()));
	   	         TableColumn col4=table.getColumnModel().getColumn(4);
	   	         col4.setPreferredWidth(350);     
	             JScrollPane scrollPane = new JScrollPane(table);
	       
	             panel.add(scrollPane);
	           
	           return panel;
	           } 
	            
	    //la methode de remplie les linges de tableau       
	 
	   public Object [] RemplierTable() throws ClassNotFoundException, SQLException {
	    	
	    	DatabaseConnection connect=new DatabaseConnection();
	    	
			String Cin=	"SELECT CIN FROM patient";
			String Nom="SELECT nom FROM patient";
			String Prenom="SELECT prenom FROM patient";
			String Date_rdv="SELECT date_rdv FROM RDV";
			Date daterdv=Date.valueOf(Date_rdv);
		    String autre="";
		    
		    PreparedStatement slectdataCin=connect.getConnection().prepareStatement(Cin);
		    PreparedStatement slectdataNom=connect.getConnection().prepareStatement(Nom);
		    PreparedStatement slectdataPrenom=connect.getConnection().prepareStatement(Prenom);
		    PreparedStatement slectdataDaterdv=connect.getConnection().prepareStatement(Date_rdv);
		    slectdataCin.execute();
		    slectdataNom.execute();
		    slectdataPrenom.execute();
		    slectdataDaterdv.execute();

		    Object [] RowElementt= {Cin,Nom,Prenom,daterdv,autre};

		    connect.closeConnection();
			
		  return RowElementt;
			}
	   }
	
	
	
	
	
	
	
            // Class de mettre les buttons

	class MyRenderer implements TableCellRenderer {

	    JButton button1,button2,button3;
	    JPanel pane;
	    public MyRenderer() {
	            pane=new JPanel(new FlowLayout());
	         // propereite de button2
		        button1 = new JButton();
		        button1.setSize(new Dimension(26,26));
				button1.setIcon(new ImageIcon(patientRDV0.class.getResource("/view/icons/delete.png")));
	
			 // propereite de button2
	     
		        button2 = new JButton();
				button2.setSize(new Dimension(26,26));
				button2.setIcon(new ImageIcon(patientRDV0.class.getResource("/view/icons/edit.png")));
				
			 // propereite de button2
	  
		        button3 = new JButton();
				button3.setSize(new Dimension(26,26));
				button3.setIcon(new ImageIcon(patientRDV0.class.getResource("/View/icons/valide.png")));
	     
		     // ajoute les buttons a panel
			    pane.add(button3);
			    pane.add(button2);
			    pane.add(button1);
			    pane.setSize(200, 50);
	    }
	        // cette methode tres important dans cette class elle mettre les bottons dans le colonne 4
	    
	    public Component getTableCellRendererComponent(JTable table,
	            Object obj,
	            boolean isSelected,
	            boolean Focus,
	            int row, int column) {
	 
	        return pane;
	    }
	    
	    }

 


	class ButtonEditor extends DefaultCellEditor implements ActionListener{
	      protected JButton button1,button2,button3;
	                JPanel panel;
	             // constructeur prend par un text
	   public ButtonEditor(JTextField txt) {
	      super(txt);
	
	      
			      panel=new JPanel();
			 
			    // propereite de button1
			      button1 = new JButton();
			      button1.setSize(new Dimension(26,26));
				  button1.setIcon(new ImageIcon(patientRDV0.class.getResource("/view/icons/delete.png")));
		
				 // propereite de button2
			   
			      button2 = new JButton();
			      button2.setSize(new Dimension(26,26));
				  button2.setIcon(new ImageIcon(patientRDV0.class.getResource("/view/icons/edit.png")));
			
				// propriete de button3
			
			      button3 = new JButton();
			 	  button3.setSize(new Dimension(26,26));
				  button3.setIcon(new ImageIcon(patientRDV0.class.getResource("/View/icons/valide.png")));
			  
			    // if click buttons
			      button1.addActionListener(this);
			      button2.addActionListener(this);
			      button3.addActionListener(this);
	      
			      
			      panel.add(button3);
			      panel.add(button2);
			      panel.add(button1);
	   }
	   
	   
	   
	   @Override
	   public void actionPerformed(ActionEvent e) {
		   
		   if(e.getSource()==button1) {
			   
			   System.out.println("clicked Delete");  
		     }
		   
	   	
		   else if(e.getSource()==button2) {
			   System.out.println("clicked Edit");  
		     }
		   
	      else if(e.getSource()==button3) {
	    	  System.out.println("clicked Valide");  
		     }
		   
	   }
	   
	   
	   //cette methoe return panel qui contient buttons
	   @Override
	  public Component getTableCellEditorComponent(JTable table, Object obj,
	      boolean selected, int row, int col) {
	    return panel;
	  }
	
	 
	   @Override
	  public Object getCellEditorValue() {
	
	    return false;
	  }
	
	   @Override
	  public boolean stopCellEditing() {
	
	    return super.stopCellEditing();
	  }
	
	   @Override
	  protected void fireEditingStopped() {
	    // TODO Auto-generated method stub
	    super.fireEditingStopped();
	  }
	
	   
	}


