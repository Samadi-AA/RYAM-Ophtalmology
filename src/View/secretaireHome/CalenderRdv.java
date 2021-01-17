package secretaireHome;

import java.util.Properties;

import javax.swing.JPanel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class CalenderRdv{
	JPanel cal;
	static JDatePickerImpl datePicker;
	public CalenderRdv() {
	}
	
	public JPanel getView() {
		cal = new JPanel();
		UtilDateModel model = new UtilDateModel();
		//model.setDate(20,04,2014);
		// Need this...
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		// Don't know about the formatter, but there it is...
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		cal.add(datePicker);
		
		return cal;
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
