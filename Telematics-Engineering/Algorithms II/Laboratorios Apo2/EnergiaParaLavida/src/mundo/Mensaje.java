package mundo;


public class Mensaje {
	
	private Mensaje siguiente;
	private Mensaje anterior;
	private String msjMotivacion;
	private String autorMsj;
	private int id;
  
  public Mensaje( String msjMotivacion,  String autorMsj, 
       int id){
	  this.msjMotivacion = msjMotivacion;
	  this.autorMsj = autorMsj;
	  
	  darSiguiente();
	  id++;
	  this.id = id;
  }

  public Mensaje darSiguiente() {
  return siguiente;
  }

  public Mensaje darAnterior() {
  return anterior;
  }

  public void cambiarSiguiente(Mensaje siguiente) {
	  this.siguiente = siguiente;
  }

  public void cambiarAnterior(Mensaje anterior) {
	  this.anterior = anterior;
  }

  public String darMsjMotivacion() {
  return msjMotivacion;
  }

  public String darAutorMsj() {
  return autorMsj;
  }

  public void autoDesconectarse() {
	  
  }
  public int darId(){
	  return id;
  }

}
