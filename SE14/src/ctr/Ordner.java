package ctr;

import java.util.ArrayList;

public class Ordner implements VerzeichnisEintrag {

	public String name = "";
	ArrayList<VerzeichnisEintrag> UnterEintaege = new ArrayList<VerzeichnisEintrag>();

	public Ordner(String n) {
		name = n;
	}

	public void add(VerzeichnisEintrag z) {
		UnterEintaege.add(z);
	}

	@Override
	public Object visit(VerzeichnisVisitor v) {
		return v.visit(this);
	}

}
