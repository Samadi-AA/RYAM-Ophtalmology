package view.secretaireHome;

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

public class patientRDV {
	
	JTable tableRDV;
	long selectedRDV;
	Object[][]list;
	/*-- Design --*/
	private ImageIcon deleteImage = new ImageIcon(LoginFrame.class.getResource("/view/icons/delete.png"));
	private ImageIcon editIcon = new ImageIcon(LoginFrame.class.getResource("/view/icons/editIcon.png"));
	private ImageIcon confirmIcon = new ImageIcon(LoginFrame.class.getResource("/view/icons/confirmIcon.png"));
	private final Color mainDark = Color.decode("#1a252c");
	private final Color mainWhite = Color.decode("#eeeeee");
	private final Color mainGreen = Color.decode("#39b672");
	private final Font mainFont = new Font("Monospaced", Font.BOLD, 16);
	
	
	public patientRDV() {
		
	}
	
	public JScrollPane getView() { 
        initData();
        
        String []head= {"Numero","CIN","Nom complete","Date de RDV","Actions"};
        
        tableRDV = new JTable(list, head) {
			boolean tableBool[]= {false,false,false,false,true};
			@Override
		    public boolean isCellEditable(int row, int column) {
				return tableBool[column];
		    }
		};

		
	    tableRDV.setBackground(Color.decode("#eeeeee"));
	    tableRDV.setForeground(mainDark);
	    tableRDV.setFont(mainFont);
	    tableRDV.getTableHeader().setOpaque(false);
	    tableRDV.getTableHeader().setBackground(mainDark);
	    tableRDV.getTableHeader().setForeground(mainWhite);
	    tableRDV.getTableHeader().setFont(mainFont);
	    //tableRDV.setBorder();
	    
	    tableRDV.getColumnModel().getColumn(4).setCellRenderer(new MyRenderer());
   		tableRDV.getColumnModel().getColumn(4).setCellEditor(new ButtonEditor(new JTextField()));
   		TableColumn col4 = tableRDV.getColumnModel().getColumn(4);
   		tableRDV.setRowHeight(45);
   		col4.setPreferredWidth(100);
   		tableRDV.getColumnModel().getColumn(0).setPreferredWidth(1);
   		
   		JScrollPane scrollPane = new JScrollPane(tableRDV);
	  
	    return scrollPane;

	}
	
	public void initData() {
		try {
			DatabaseConnection connect = new DatabaseConnection();
			Date today = new Date(System.currentTimeMillis());
			Date tomorow = new Date(System.currentTimeMillis()+(24*60*60*1000));
			
			String selectQuery = "SELECT * FROM rdv"
					+ " WHERE datetime_rdv BETWEEN '" + today.toString()
					+ "' AND '"+ tomorow.toString() +"'";
			
			PreparedStatement preparedStmt = connect.getConnection().prepareStatement(selectQuery);
						
			ResultSet res = preparedStmt.executeQuery(selectQuery);
			
			
			String[] nums = new String[30], 
					 cins = new String[30],
					 noms = new String[30],
					 dates = new String[30];
			
			int i = 0;
				
	        while (res.next()) {
	        	nums[i] = res.getString("num_rdv");
	        	cins[i] = res.getString("CIN");
	        	noms[i] = res.getString("nom_pat");
	        	dates[i] = res.getString("datetime_rdv");
	        	i++;
			}
	        
	        list= new Object[i][5];
	        
	        for (int j = 0; j < i; j++) {
	        	list[j][0] = nums[j];
	        	list[j][1] = cins[j];
	        	list[j][2] = noms[j];
	        	list[j][3] = dates[j];
	        	list[j][4] = "";
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
				selectedRDV = (long) Integer.parseInt(table.getModel().getValueAt(row, 0).toString());
			}
			return btnsPanel;
		}
	}

	class ButtonEditor extends DefaultCellEditor{
		protected JButton btnDelete,btnEdit,btnConfirm;
		public JPanel btnsPanel;
		// constructeur prend par un text
		public ButtonEditor(JTextField txt) {
			super(txt);
			  
			btnsPanel = new JPanel(new FlowLayout());
			    
			btnConfirm = new JButton();
			btnConfirm.setSize(new Dimension(26,26));
			btnConfirm.setBackground(mainWhite);
			btnConfirm.setBorder(new EmptyBorder(2, 0, 0, 0));
			btnConfirm.setIcon(confirmIcon);
			btnConfirm.setFocusPainted(false);
			btnConfirm.setToolTipText("Confirmer la visite");
				
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
			 
			btnsPanel.add(btnConfirm);
			btnsPanel.add(btnEdit);
			btnsPanel.add(btnDelete);
			btnsPanel.setSize(200, 50);
			btnsPanel.setToolTipText("Double click pour accees au actions");
			
			btnConfirm.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					super.mouseClicked(e);
					RDV rdv = new RDV(selectedRDV);
					rdv.setNumPatient(1);
					rdv.confirmerVisite();
					rdv.Supprimer();
				}
			});
			
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
					RDV rdv = new RDV(selectedRDV);
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

