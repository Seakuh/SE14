package ctr;

import java.util.ArrayList;

public class Ordner implements VerzeichnisEintrag {

	public String name = "";
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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
