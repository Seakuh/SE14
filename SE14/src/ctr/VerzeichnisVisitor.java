package ctr;

public interface VerzeichnisVisitor {
	
	public Object visit(Datei e);

	public Object visit(Ordner e);

}
