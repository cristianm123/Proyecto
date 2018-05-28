package modelo;

/**Entidad del modelo del mundo que representa la Plaza y hereda de Equipo, una Plaza es un 
 * lugar en el Torneo que se encuentra vacio
 * 
 * @author Alvaro Jose Escobar & Cristian Felipe Molina
 * @version 22/05/2018 Beta 1.0
 */
public class Plaza extends Equipo {

	/**Constructor para los objetos de tipo Plaza
	 * 
	 * @param int es una variable de tipo ind que recibe de la super clase Equipo
	 */
	public Plaza(int ind){
		super("", ind);
	}
	
	/**Este metodo se encarga de revisar quienes pasan a la siguiente ronda del Torneo
	 * 
	 * @pre izq!=null,der!=null y raiz!=null
	 * @post dependiendo en que hoja del arbol se encuentre el equipo seleccionado por el ususario
	 * y si gano se pasa al siguiente nodo del arbol contra el siguiente equipo 
	 */
	public void nextStage(Equipo ganador){
		if(super.getIndex()==8){
			if(ganador.getIndex()>super.getIndex()){
				
				super.setDer(ganador);
				super.getDer().setRaiz(this);
				int op = (int)(Math.random()*2);
				if(op==0){
					
					super.setIzq(super.getIzq().getIzq());
					super.getIzq().setRaiz(this);
					
				}
				else{
					super.setIzq(super.getIzq().getDer());
					super.getIzq().setRaiz(this);
				}
			}
			else{
				super.setIzq(ganador);
				super.getIzq().setRaiz(this);
				int op = (int)(Math.random()*2);
				if(op==0){
					super.setDer(super.getDer().getIzq());
					super.getDer().setRaiz(this);
				}
				else{
					super.setDer(super.getDer().getDer());
					super.getDer().setRaiz(this);
				}
			}
		}
		else{
			if(ganador.getIndex()>(super.getIndex()-4)&&ganador.getIndex()<(super.getIndex()+4)){
				if(ganador.getIndex()>super.getIndex()){
					
					super.setDer(ganador);
					super.getDer().setRaiz(this);
					int op = (int)(Math.random()*2);
					if(op==0){
						super.setIzq(super.getIzq().getIzq());
					}
					else{
						super.setIzq(super.getIzq().getDer());
					}
					super.getIzq().setRaiz(this);
				}
				else{
					
					super.setIzq(ganador);
					super.getIzq().setRaiz(this);
					int op = (int)(Math.random()*2);
					if(op==0){
						super.setDer(super.getDer().getIzq());
					}
					else{
						super.setDer(super.getDer().getDer());	
					}
					super.getDer().setRaiz(this);
				}
			}
			else{
				int op = (int)(Math.random()*2);
				if(op==0){
					super.setDer(super.getDer().getIzq());
				}
				else{
					super.setDer(super.getDer().getDer());
					
				}
				super.getDer().setRaiz(this);
				op = (int)(Math.random()*2);
				if(op==0){
					super.setIzq(super.getIzq().getIzq());
				}
				else{
					super.setIzq(super.getIzq().getDer());
				}
				super.getIzq().setRaiz(this);
			}
		}
	}
}