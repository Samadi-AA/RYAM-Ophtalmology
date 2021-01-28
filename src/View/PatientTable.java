package view;


import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import control.DatabaseConnection;
import model.RDV;
import view.LoginFrame;

public class PatientTable {
	
	JTable tablePatient;
	long selectedPatient;
	Object[][]listPatient;
	/*-- Design --*/
	private ImageIcon deleteImage = new ImageIcon(LoginFrame.class.getResource("/view/icons/delete.png"));
	private ImageIcon editIcon = new ImageIcon(LoginFrame.class.getResource("/view/icons/editIcon.png"));
	private final Color mainDark = Color.decode("#1a252c");
	private final Color mainWhite = Color.decode("#eeeeee");
	private final Font mainFont = new Font("Monospaced", Font.BOLD, 16);
	
	
	public PatientTable() {
		
	}
	
	public JScrollPane getView() { 
        initData();
        
        String []head= {"Numero","CIN","Nom","Prenom","Sexe","Date de naissance","Adresse","Telephone","Actions"};
        
        tablePatient = new JTable(listPatient, head) {
			boolean tableBool[]= {false,false,false,false,false,false,false,false,true};
			@Override
		    public boolean isCellEditable(int row, int column) {
				return tableBool[column];
		    }
		};

		tablePatient.setBounds(0, 0, 700, 700);
	    tablePatient.setBackground(Color.decode("#eeeeee"));
	    tablePatient.setForeground(mainDark);
	    tablePatient.setFont(mainFont);
	    tablePatient.getTableHeader().setOpaque(false);
	    tablePatient.getTableHeader().setBackground(mainDark);
	    tablePatient.getTableHeader().setForeground(mainWhite);
	    tablePatient.getTableHeader().setFont(mainFont);
	    //tableRDV.setBorder();
	    
	    tablePatient.getColumnModel().getColumn(8).setCellRenderer(new MyRenderer());
   		tablePatient.getColumnModel().getColumn(8).setCellEditor(new ButtonEditor(new JTextField()));
   		TableColumn actionColoumn = tablePatient.getColumnModel().getColumn(8);
   		tablePatient.setRowHeight(45);
   		actionColoumn.setPreferredWidth(100);
   		tablePatient.getColumnModel().getColumn(0).setPreferredWidth(1);
   		
   		JScrollPane scrollPane = new JScrollPane(tablePatient);
   		scrollPane.setBounds(0, 0, 700, 700);
   		
	    return scrollPane;

	}
	
	public void initData() {
		try {
			DatabaseConnection connect = new DatabaseConnection();
			Date today = new Date(System.currentTimeMillis());
			Date tomorow = new Date(System.currentTimeMillis()+(24*60*60*1000));
			
			String selectQuery = "SELECT * FROM patient";
			
			PreparedStatement preparedStmt = connect.getConnection().prepareStatement(selectQuery);
						
			ResultSet res = preparedStmt.executeQuery(selectQuery);
			
			
			String[] nums = new String[1000], 
					 cins = new String[1000],
					 noms = new String[1000],
					 prenoms = new String[1000],
					 sexes = new String[1000],
					 dates = new String[1000],
					 adresses = new String[1000],
					 tels = new String[1000];
			
			int i = 0;
				
	        while (res.next()) {
	        	nums[i] = res.getString("num_patient");
	        	cins[i] = res.getString("CIN");
	        	noms[i] = res.getString("nom");
	        	prenoms[i] = res.getString("prenom");
	        	sexes[i] = res.getString("sexe");
	        	dates[i] = res.getString("date_naissance");
	        	adresses[i] = res.getString("adresse");
	        	tels[i] = res.getString("tel");
	        	i++;
			}
	        
	        listPatient= new Object[i][9];
	        
	        for (int j = 0; j < i; j++) {
	        	listPatient[j][0] = nums[j];
	        	listPatient[j][1] = cins[j];
	        	listPatient[j][2] = noms[j];
	        	listPatient[j][3] = prenoms[j];
	        	listPatient[j][4] = sexes[j];
	        	listPatient[j][5] = dates[j];
	        	listPatient[j][6] = adresses[j];
	        	listPatient[j][7] = tels[j];
	        	listPatient[j][8] = "";
			}
	     						
			connect.closeConnection();
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	class MyRenderer implements TableCellRenderer {
		JPanel btnsPanel;
		ButtonEditor btns = new ButtonEditor(new JTextField());
			    
		public MyRenderer() {
			btnsPanel = btns.btnsPanel;	 
		}
			    
		public Component getTableCellRendererComponent(JTable table, Object obj, boolean isSelected, boolean Focus, int row, int column) {
			if (isSelected) {
				selectedPatient = (long) Integer.parseInt(table.getModel().getValueAt(row, 0).toString());
			}
			return btnsPanel;
		}
	}

	class ButtonEditor extends DefaultCellEditor{
		protected JButton btnDelete,btnEdit;
		public JPanel btnsPanel;
		// constructeur prend par un text
		public ButtonEditor(JTextField txt) {
			super(txt);
			  
			btnsPanel = new JPanel(new FlowLayout());
				
			btnEdit = new JButton();
			btnEdit.setSize(new Dimension(26,26));
			btnEdit.setBackground(mainWhite);
			btnEdit.setBorder(new EmptyBorder(3, 20, 0, 20));
			btnEdit.setIcon(editIcon);
			btnEdit.setFocusPainted(false);
			btnEdit.setToolTipText("Modifer le rondez-vous");
				       
			btnDelete = new JButton();
			btnDelete.setSize(new Dimension(26,26));
			btnDelete.setBackground(mainWhite);
			btnDelete.setBorder(new EmptyBorder(2, 0, 0, 0));
			btnDelete.setIcon(deleteImage);
			btnDelete.setFocusPainted(false);
			btnDelete.setToolTipText("Annuler le rondez-vous");
			 


			btnEdit.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					super.mouseClicked(e);
				}
			});
			
			btnDelete.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					super.mouseClicked(e);
					RDV rdv = new RDV(selectedPatient);
					rdv.Supprimer();	
					getView();
				}
			});
			
		}
	   
	   
	   
	   //cette methoe return panel qui contient buttons
	    @Override
		public Component getTableCellEditorComponent(JTable table, Object obj, boolean selected, int row, int col) {
	    	return btnsPanel;
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
		   super.fireEditingStopped();
	    }
	}
		
}


