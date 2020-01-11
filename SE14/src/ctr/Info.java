package ctr;

public class Info implements VerzeichnisVisitor {

	static int tiefe = 0;
	static int blattKnoten = 0;
	static int blatt = 0;
	static double durchschnittlicherVerzweigungsGrad = 0;
	static int verzweigungen = 0;
//	static Info instance;
//	
//	public Info() {
//		instance = new Info();
//	}

	@Override
	public Object visit(Datei e) {
		blatt++;
		return e;
	}

	@Override
	public Object visit(Ordner e) {
		tiefe++;
		if(e.UnterEintaege.isEmpty()) {
			blatt++;
			return "Keine Unterordner";
		}
		for (VerzeichnisEintrag v : e.UnterEintaege) {
			if (v.visit(this) instanceof Datei) {
				this.visit((Datei) v);
			}
			if (v.visit(this) instanceof Ordner) {				
				this.visit((Ordner) v);
			}
		}

		return "ende";
	}
	
	public void ergebnis() {
		durchschnittlicherVerzweigungsGrad = verzweigungen/tiefe;
		
		System.out.println("Tiefe: " + tiefe);
		System.out.println("Blattknoten: " + blattKnoten);
		System.out.println("durchschnittliche Verzweigungen: " + durchschnittlicherVerzweigungsGrad);
	}

}
