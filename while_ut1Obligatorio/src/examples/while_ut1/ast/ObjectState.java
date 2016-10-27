package examples.while_ut1.ast;

public class ObjectState {

	public String tipo;
	public boolean assigned=false;
	
	@Override
	public ObjectState clone(){
		ObjectState objectState=new ObjectState();
		objectState.assigned=new Boolean(this.assigned);
		objectState.tipo=new String(this.tipo);
		return objectState;
	}
}
