package mundo;
import java.util.Date;


public class DiaException extends Exception {
	private String fecha;

  public DiaException( String causa,  String fecha){
	  
	  super(causa);
	  this.fecha = fecha;
	  
  }

  public String darFecha() {
  return fecha;
  }

}