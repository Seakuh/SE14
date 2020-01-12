package ctr;

public class Datei implements VerzeichnisEintrag {

	public String name = "";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String format = "";

	public Datei(String n, String f) {
		name = n;
		format = f;
	}

	@Override
	public Object visit(VerzeichnisVisitor v) {
		return v.visit(this);
	}

}
