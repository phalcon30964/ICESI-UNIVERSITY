package TadCola;

public class ColaPrioridad<T extends Prioridad>  extends Cola<T> implements IColaPrioriodad<T>{
	
	public final static int MAX = Integer.MAX_VALUE;
	
	public ColaPrioridad() {
		super();
	}

	@Override
	public void enQueue(T valor){
		try {
			enQueue(valor.getPrioridad(), valor);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void enQueue(int prioridad, T elemento) throws Exception  {
		
		if(cola.esVacia()){
			cola.agregar(elemento);
		}else if(cola.darLongitud()==1){
			
			if(cola.darElemento(0).getPrioridad()>prioridad){
				cola.agregar(0, elemento);
			}else{
				cola.agregar(elemento);
			}
			
		}else{
			
			int pos = 0;
			
			T actual = cola.darElemento(pos);
			
				while( pos<cola.darLongitud()-1 && (actual.getPrioridad())<=prioridad){
					pos++;
					actual = cola.darElemento(pos);
				}
				
				if(pos==cola.darLongitud()-1 && (actual.getPrioridad())<=prioridad){
					pos++;
				}
				
				if(pos==0){
					cola.agregar(pos,elemento);	
				}else{
					cola.agregar(pos, elemento);
				}
				
		}
		
	}


	
	
	


}
