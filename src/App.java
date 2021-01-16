import model.Patient;

public class App {

	public static void main(String[] args) {
		
		Patient p = new Patient(0, "rami", "romerro", "JC123456", "man", "taroudant", 612345678);
		p.ajouterPatient();
		
		System.out.println("hello world");
	}
	
}
