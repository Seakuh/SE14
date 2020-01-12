package ctr;

public class TestDriver {

	public static void main(String[] args) {

		Ordner d = new Ordner("OberOrdner");

		Ordner bilder = new Ordner("Bilder");

		Datei bild5 = new Datei("IMG_35235", "jpg");
		Datei bild6 = new Datei("IMG_34564", "jpg");
		Datei bild7 = new Datei("IMG_34345", "jpg");
		Datei bild8 = new Datei("IMG_45346", "jpg");

		bilder.add(bild5);
		bilder.add(bild6);
		bilder.add(bild7);
		bilder.add(bild8);
		
		Ordner jahrOrdner = new Ordner("Jahreszeiten");

		Datei bild1 = new Datei("Sommer", "jpg");
		Datei bild2 = new Datei("Winter", "jpg");
		Datei bild3 = new Datei("Frühling", "jpg");
		Datei bild4 = new Datei("Herbst", "jpg");

		jahrOrdner.add(bild1);
		jahrOrdner.add(bild2);
		jahrOrdner.add(bild3);
		jahrOrdner.add(bild4);

		Ordner jahrDatum = new Ordner("Datum");

		Datei bild10 = new Datei("Bild_28.12.2020", "jpg");
		Datei bild11 = new Datei("Bild_18.02.2020", "jpg");
		Datei bild12 = new Datei("Bild_22.03.2020", "jpg");

		jahrDatum.add(bild10);
		jahrDatum.add(bild11);
		jahrDatum.add(bild12);

		jahrOrdner.add(jahrDatum);

		Ordner videos = new Ordner("Videos");

		Ordner schreibtisch = new Ordner("Schreibtisch");



		Ordner finanzen = new Ordner("Finanzen");

		Ordner dokumente = new Ordner("Dokumente");
		
		Datei hausaufgaben = new Datei("Hausaufgaben", "txt");
		Datei steuern = new Datei("Steuern_2019", "doc");

		dokumente.add(hausaufgaben);
		bilder.add(jahrOrdner);

		dokumente.add(finanzen);
		finanzen.add(steuern);

		d.add(bilder);
		d.add(dokumente);
		d.add(videos);
		d.add(schreibtisch);

		Ausgabe ausgabe = new Ausgabe();
		Info info = new Info();

		System.out.println(ausgabe.visit(d));

		info.visit(d);
		info.ergebnis();

	}
}
