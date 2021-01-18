import model.Patient;

public class App {

	public static void main(String[] args) {
		
		Patient p = new Patient("tst1", "tst1", "JC122475", "man", "taroudant", "0612345678");
		p.ajouterPatient();
		Patient p2 = new Patient("tst2", "tst2", "tst22475", "man", "taroudant", "0612345678");
		p2.ajouterPatient();
		Patient p3 = new Patient("tst3", "tst3", "JC124475", "man", "taroudant", "0612345678");
		p3.ajouterPatient();
		Patient p4 = new Patient("tst4", "romerro", "JD122475", "man", "taroudant", "0612345678");
		
		p3.supprimerPatient();
		
	}
	
}
