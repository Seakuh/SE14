package ctr;

public class Ausgabe implements VerzeichnisVisitor {
	
	String ausgabe = "Ausgabe";
	public static String tab = "\t";

	@Override
	public Object visit(Datei e) {
		return "----" + e.name;
	}

	@Override
	public Object visit(Ordner e) {
		System.out.println("[-]" + e.name);
		for (VerzeichnisEintrag d : e.UnterEintaege) {			
			System.out.println(d.visit(this));
		}
		return "";
	}

}
