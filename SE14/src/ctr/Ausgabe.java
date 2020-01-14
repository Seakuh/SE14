package ctr;

public class Ausgabe implements VerzeichnisVisitor {
	
	String ausgabe = "Ausgabe";
	public static String space = "";

	@Override
	public Object visit(Datei e) {
		System.out.println(space + " |--" + e.name);
		return "";
	}

	@Override
	public Object visit(Ordner e) {
		System.out.println(space + "[-]" + e.name);
		space = space + "    ";
		for (VerzeichnisEintrag d : e.UnterEintaege) {			
			d.visit(this);
		}
		
		space = "    ";
		return "";
	}

}
