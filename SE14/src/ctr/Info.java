package ctr;

import java.util.ArrayList;

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

	public boolean hatBefuellteUnterOrdner(Ordner o) {
		for (VerzeichnisEintrag u : o.getUnterEintaege()) {
			if (u instanceof Ordner && (!((Ordner) u).UnterEintaege.isEmpty())) {
				return true;
			}
		}
		return false;

	}

	@Override
	public Object visit(Ordner e) {
		if (e.UnterEintaege.isEmpty()) {
			blatt++;
			return "Keine Unterordner";
		} else if(this.hatBefuellteUnterOrdner(e)){
			blattKnoten++;
		}
		for (VerzeichnisEintrag v : e.UnterEintaege) {
			if (v instanceof Datei) {
				this.visit((Datei) v);
			} else if (v instanceof Ordner) {
				this.visit((Ordner) v);
			}
		}

		return "ende";

	}

	public void ergebnis() {

		durchschnittlicherVerzweigungsGrad = blatt / tiefe;

		System.out.println("Tiefe: " + tiefe);
		System.out.println("Blattknoten: " + blattKnoten);
		System.out.println("durchschnittliche Verzweigungen: " + durchschnittlicherVerzweigungsGrad);
	}

//	if(e.UnterEintaege.isEmpty()) {
//	blatt++;
//	System.out.println("Keine Unterordner");
//	return "Keine Unterordner";
//}else {
//	blattKnoten++;
//}
//
//System.out.println("Ordner der Interiert wird : \t" + e.getName() );
//
//for (VerzeichnisEintrag v : e.UnterEintaege) {
//	if (v.visit(this) instanceof Datei) {
//		blatt++;
//		System.out.println("Dateiname:---- " + ((Datei)v).getName());
//		this.visit((Datei) v);
//	}else {
//		System.out.println("Ordername: --------------" + ((Ordner)v).getName());
//		this.visit((Ordner) v);
//	}
//}

}
