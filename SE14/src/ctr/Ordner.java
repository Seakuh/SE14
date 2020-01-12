package ctr;

import java.util.ArrayList;

public class Ordner implements VerzeichnisEintrag {

	public String name = "";
	ArrayList<VerzeichnisEintrag> UnterEintaege = new ArrayList<VerzeichnisEintrag>();

	
	public ArrayList<VerzeichnisEintrag> getUnterEintaege() {
		return UnterEintaege;
	}

	public void setUnterEintaege(ArrayList<VerzeichnisEintrag> unterEintaege) {
		UnterEintaege = unterEintaege;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


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
