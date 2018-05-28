package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import interfaz.VentanaPrincipal;

/**Entidad del modelo del mundo que representa el Juego, clase principal del modelo
 * 
 * @author Alvaro Jose Escobar & Cristian Felipe Molina
 * @version 22/05/2018 Beta 1.0
 */
public class Juego {
	
	/** Relacion con un objeto de tipo Jugador
	 */
	private Jugador jugador;
	
	/** Relacion con un objeto de tipo VentanaPrincipal
	 */
	private VentanaPrincipal vp;
	private String[] users;
	private int[] trofeos;
	private int[] victorias;
	
	/**Constructor para los objetos de tipo Juego,inicializa los valores de las variables 
	 * 
	 * @param v de tipo VentanaPrincipal, es una referencia de la VentanaPrincipal de la interfaz
	 */
	public Juego(VentanaPrincipal v) {
		jugador = null;
		vp = v;
		mostrarPartidas();
		setTrofeos();
		setVictorias();
	}
	
	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases acceder 
	 * a la relacion que tiene la clase Juego con la clase Jugador
	 * 
	 * @return jugador es un objeto de tipo Jugador.
	 */
	public Jugador getJugador() {
		return jugador;
	}
	
	/**Este metodo se encarga de prestar el servicio de permitir a las demas clases modificar 
	 * la relacion con la clase Jugador
	 * 
	 * @pre el jugador se encuentra por defecto con los valores establecidos en el constructor
	 * @post se cambia el jugador anterior por el que se recibe por parametro
	 * 
	 * @param jugador es un objeto de tipo Jugador
	 */
	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
	
	/**Este metodo se encarga de realizar la persistencia del Juego y guarda el estado de la 
	 * partida 
	 * 
	 * @post se guarda un archivo nuevo en la carpeta partidas con el estado del juego
	 */
	public void guardarJuego(){
		try {
			File archivo = new File("data/partidas/"+jugador.getNombre()+".txt");
			FileWriter fw = new FileWriter(archivo);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			pw.write(jugador.getNombre());
			pw.append("\n"+jugador.getTrofeos());
			pw.append("\n"+jugador.getVictorias());
			pw.append("\n"+jugador.getGoles());
			
			pw.close();
			bw.close();
			
			File total = new File("total.txt");
			FileWriter escribir = new FileWriter(total, true);
			PrintWriter linea = new PrintWriter(escribir);
			if(!total.exists()){
				total.createNewFile();
				linea.println(jugador.getNombre());
				linea.close();
				escribir.close();
			}
			else{
				linea.println(jugador.getNombre());
				linea.close();
				escribir.close();
			}
			
			ObjectOutputStream guardado = new ObjectOutputStream(new FileOutputStream("data/juegos/"+jugador.getNombre()));
			guardado.writeObject(jugador);
			guardado.close();
			
		} catch (Exception e) {
			vp.mostrarMensaje(e.getMessage());
		}
	}
	
	/**Este metodo se encarga de cargar el estado de la partida que se guardo
	 * 
	 * @post se carga el archivo seleccionado con el nombre de la partida que se guardo
	 * 
	 * @param partida de tipo String, partida!="" & partida !=null
	 */
	public void cargarPartida(String partida){
		try {
			ObjectInputStream carga = new ObjectInputStream(new FileInputStream("data/juegos/"+partida));
			jugador = (Jugador)carga.readObject();
			carga.close();
			if(vp.getJuego().getJugador().getTorneo()!=null){
				vp.getJuego().getJugador().getTorneo().jugarPartido();
				jugador.getTorneo().setJuego(this);
				start();
			}
			vp.mostrarMensaje("Partida cargada");
		} catch (IOException | ClassNotFoundException e) {
			vp.mostrarMensaje(e.getMessage());
		}
		
	}
	
	public void reiniciar()
	{
		vp.Reiniciar();
	}
	
	public void parar()
	{
		vp.getHilo().interrupt();
	}
	
	public void mostrarVictoria()
	{
		vp.getDialogJuego().getPJ().pintarVictoria();
	}
	
	public void mostrarDerrota()
	{
		vp.getDialogJuego().getPJ().pintarDerrota();
	}
	
	public void apagar(){
		vp.getDialogJuego().setVisible(false);
	
	}
	
	public void mostrarMarcador(Boolean[] a, Boolean[] b)
	{
		vp.getDialogJuego().getPJ().marcador(a, b);
	}
	
	public void start()
	{
		vp.start();
	}
	
	public void mostrarPartidas()
	{
		File archivo;
		FileReader leer;
		BufferedReader almacenamiento;
		
		archivo = new File("total.txt");
		ArrayList<String> users = new ArrayList<String>();
		try {
			leer = new FileReader(archivo);
			almacenamiento = new BufferedReader(leer);
			String cad = "s";
			while (cad!=null&&!cad.equals("")) {
				cad = almacenamiento.readLine();
				boolean repetido = false;
				for (int i = 0; i < users.size(); i++) {
					if(users.get(i).equals(cad))
					{
						repetido =true;
					}
				}
				if(!cad.equals(null)&&!repetido)
				{
					users.add(cad);
				}
			}
		} catch (Exception e) {
			
		}
		
		this.users = new String[users.size()];
		for (int i = 0; i < this.users.length; i++) {
			this.users[i] = users.get(i);
		}
	}
	
	public void setTrofeos()
	{
		trofeos = new int[users.length];
		for (int i = 0; i < users.length; i++) {
			String partida = users[i];
			partida = "data/partidas/"+partida+".txt";
			BufferedReader bf;
			try {
				bf = new BufferedReader(new FileReader(partida));
				bf.readLine();
				String b = (String)bf.readLine();
				int c = Integer.parseInt(b);
				trofeos[i] = c;
				bf.close();
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
	}
	
	public void setVictorias()
	{
		victorias = new int[users.length];
		for (int i = 0; i < users.length; i++) {
			String partida = users[i];
			partida = "data/partidas/"+partida+".txt";
			BufferedReader bf;
			try {
				bf = new BufferedReader(new FileReader(partida));
				bf.readLine();
				bf.readLine();
				String b = (String)bf.readLine();
				int c = Integer.parseInt(b);
				victorias[i] = c;
				bf.close();
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
	}
	
	public void ordenarAlfabeto()
	{
		for (int i = 0; i < users.length-1; i++) {
			String menor = users[i];
			int trofeo = trofeos[i];
			int cual = i;
			int victoria = victorias[i];
			for (int j = i+1; j < users.length; j++) {
				if(users[j].compareTo(menor)<0)
				{
					menor = users[j];
					trofeo = trofeos[j];
					cual = j;
					victoria = victorias[j];
				}
			}
			String temp = users[i];
			int t = trofeos[i];
			int te = victorias[i];
			trofeos[i] = trofeo;
			users[i] = menor;
			victorias[i] = victoria;
			users[cual] = temp;
			trofeos[cual] = t;
			victorias[cual] = te;
		}
	}
	
	public void ordenarTrofeos()
	{
		for (int i = 1; i < trofeos.length; i++) {
			for (int j = i; j > 0 && trofeos[j - 1] > trofeos[j]; j--) {
				int temp = trofeos[j];
				trofeos[j] = trofeos[j-1];
				trofeos[j-1] = temp;
				String t = users[j];
				users[j] = users[j-1];
				users[j-1] = t;
				int te = victorias[j];
				victorias[j] = victorias[j-1];
				victorias[j-1] = te;
			}
		}
	}
	
	public void ordenarVictorias()
	{
		for (int i = 0; i < victorias.length-1; i++) {
			for (int j = 0; j < victorias.length-1-i; j++) {
				if(victorias[j]<victorias[j+1])
				{
					int temp = trofeos[j];
					trofeos[j] = trofeos[j+1];
					trofeos[j+1] = temp;
					String t = users[j];
					users[j] = users[j+1];
					users[j+1] = t;
					int te = victorias[j];
					victorias[j] = victorias[j+1];
					victorias[j+1] = te;
				}
				
			}
		}
	}
	
	public boolean estaRepetido(String s)
	{
		ordenarAlfabeto();
		boolean found = false;
		int ini = 0;
		int fin = users.length-1;
		while(ini<=fin && !found)
		{
			
			int medio = (fin + ini)/2;
			if(users[medio].equals(s))
			{
				found = true;
			}
			else if(users[medio].compareTo(s)<0)
			{
				ini = medio + 1;
			}
			else
			{
				fin = medio - 1;
			}
		}
		return found;
	}
	
	public String[] getUsers()
	{
		return users;
	}

	public String[] getDatos()
	{
		String[] datos = new String[users.length];
		for (int i = 0; i < datos.length; i++) {
			datos[i] = "Nombre: " + users[i]+". Trofeos: " + trofeos[i] + ". Victorias: "+victorias[i]+".";
		}
		return datos;
	}
	
	public String busquedaVictorias(int val)
	{
		ordenarVictorias();
		boolean encontro = false;
		String us = "Ningun jugador tiene este puntaje";
		int ini = 0;
		int fin = victorias.length-1;
		while(ini<=fin&&!encontro)
		{
			int medio = (fin + ini)/2;
			if(victorias[medio] == val)
			{
				us = users[medio];
				encontro = true;
			}
			else if(victorias[medio] > val)
			{
				ini = medio + 1;
			}
			else
			{
				fin = medio - 1;
			}
		}
		return us;
	}
}
