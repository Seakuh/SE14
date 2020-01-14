package ctr;

import java.util.ArrayList;

public class Info implements VerzeichnisVisitor {

	static int tiefe = 1;
	static int blattKnoten = 0;
	static int blatt = 0;
	static double durchschnittlicherVerzweigungsGrad = 0;
	static int verzweigungen = 0;
	static int aktTiefste = 1;

	public static int getTiefe() {
		return tiefe;
	}

	public static void setTiefe(int tiefe) {
		Info.tiefe = tiefe;
	}

	public static int getBlattKnoten() {
		return blattKnoten;
	}

	public static void setBlattKnoten(int blattKnoten) {
		Info.blattKnoten = blattKnoten;
	}

	public static int getBlatt() {
		return blatt;
	}

	public static void setBlatt(int blatt) {
		Info.blatt = blatt;
	}

	public static double getDurchschnittlicherVerzweigungsGrad() {
		return durchschnittlicherVerzweigungsGrad;
	}

	public static void setDurchschnittlicherVerzweigungsGrad(double durchschnittlicherVerzweigungsGrad) {
		Info.durchschnittlicherVerzweigungsGrad = durchschnittlicherVerzweigungsGrad;
	}

	public static int getVerzweigungen() {
		return verzweigungen;
	}

	public static void setVerzweigungen(int verzweigungen) {
		Info.verzweigungen = verzweigungen;
	}

	public static int getAktTiefste() {
		return aktTiefste;
	}

	public static void setAktTiefste(int aktTiefste) {
		Info.aktTiefste = aktTiefste;
	}

	@Override
	public Object visit(Datei e) {
		blatt++;
		return e;
	}

	public boolean hatBefuellteUnterOrdner(Ordner o) {

		for (VerzeichnisEintrag u : o.getUnterEintaege()) {
			if (u instanceof Ordner && (!((Ordner) u).UnterEintaege.isEmpty())) {
				aktTiefste++;

				if (aktTiefste > tiefe) {
					tiefe = aktTiefste;
				}
				return true;
			}
		}
		return false;

	}

	public Object visit(Ordner e) {
		if (e.UnterEintaege.isEmpty()) {
			blatt++;
			// System.out.println("Kein Knoten: " + e.name);
			return "Keine Unterordner";
		} else {
			blattKnoten++;
		}

		if(!(this.hatBefuellteUnterOrdner(e))) {
			blatt++;
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
		System.out.println("Blätter: " + blatt);
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
