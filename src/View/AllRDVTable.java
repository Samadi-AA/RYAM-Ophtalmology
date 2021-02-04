package view;

import java.awt.Color;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import control.DatabaseConnection;

public class AllRDVTable {
	
	JTable tableRDV;
	long selectedRDV;
	String cin;
	Object[][]list;
	/*-- Design --*/
	private final Color mainDark = Color.decode("#1a252c");
	private final Color mainWhite = Color.decode("#eeeeee");
	private final Font mainFont = new Font("Monospaced", Font.BOLD, 16);
	
	
	public AllRDVTable() {
		
	}
	
	public JScrollPane getView() { 
        initData();
        
        String []head= {"Numero","CIN","Nom complete","Date de RDV"};
        
        tableRDV = new JTable(list, head) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean tableBool[]= {false,false,false,false};
			@Override
		    public boolean isCellEditable(int row, int column) {
				return tableBool[column];
		    }
		};

		tableRDV.setBounds(0, 0, 700, 700);
		tableRDV.setRowHeight(45);
	    tableRDV.setBackground(Color.decode("#eeeeee"));
	    tableRDV.setForeground(mainDark);
	    tableRDV.setFont(mainFont);
	    tableRDV.getTableHeader().setOpaque(false);
	    tableRDV.getTableHeader().setBackground(mainDark);
	    tableRDV.getTableHeader().setForeground(mainWhite);
	    tableRDV.getTableHeader().setFont(mainFont);	    
   		
	    JScrollPane scrollPane = new JScrollPane(tableRDV);
   		scrollPane.setBounds(0, 0, 700, 700);
	    
   		return scrollPane;
	}
	
	public void initData() {
		try {
			DatabaseConnection connect = new DatabaseConnection();
			
			String selectQuery = "SELECT * FROM rdv";
			
			PreparedStatement preparedStmt = connect.getConnection().prepareStatement(selectQuery);
						
			ResultSet res = preparedStmt.executeQuery(selectQuery);
			
			int count = 0, i = 0;
			
			while (res.next()) count++;
			
			String[] nums = new String[count], 
					 cins = new String[count],
					 noms = new String[count],
					 dates = new String[count];
			
			res = preparedStmt.executeQuery(selectQuery);
			 
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
	
}

