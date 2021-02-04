package view;

import java.sql.Date;
import java.util.Properties;

import javax.swing.JPanel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class Calender {
	JPanel cal;
	static JDatePickerImpl datePicker;
	static UtilDateModel model;
	
	public Calender() {
	}
	
	public JPanel getView() {
		model = new UtilDateModel();
		//model.setDate(20,04,2014);
		// Need this...
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		// Don't know about the formatter, but there it is...
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
				
		return datePicker;
	}
	
	public static Date getDate() {
		Date birth = null;
		if(model.isSelected()) birth = new Date(model.getValue().getTime());
		return birth;
	}
	
	public void disableDate() {
		datePicker.getComponent(1).setEnabled(false);
	}
	public void enableDate() {
		datePicker.getComponent(1).setEnabled(true);
	}
	
	public void resetdate() {
		datePicker.getModel().setValue(null);
	}
}
