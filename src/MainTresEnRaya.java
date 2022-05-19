import java.util.Scanner;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;

/**
 * Clase principal que implementa la partida, para
 * ello se sirve de la clase TresEnRaya que implementa los
 * elementos del juego propiamente dicho: tablero, fichas, movimientos
 * Tambi�n utiliza una librer�a auxiliar para poder enviar c�digos
 * de color a la consola
 
 * @author loned
 * 
 */
public class MainTresEnRaya {

	/**
	 * Emulaci�n de consola Ansi 
	 */
	public static Ansi scr0;
	
	/**
	 * men� del juego, pinta en pantalla las opciones disponibles y 
	 * solicita al jugador la elecci�n de una ellas
	 * @return sel Opci�n elegida por el jugador
	 */
	public static int menu() {	
		int sel = 0;

		Scanner teclado = new Scanner(System.in);
		System.out.println(scr0.fgBrightCyan());
		System.out.println("---- Opciones ----");
		System.out.print(scr0.fg(Ansi.Color.WHITE));
		System.out.println("1. Mueve Jugador 1");
		System.out.println("2. Mueve Jugador 2");
		System.out.println("0. Termina Partida");
		System.out.println(scr0.fgBrightCyan());
		System.out.println("------------------");
		System.out.println(scr0.fgBrightYellow());
		System.out.print(">>>?");
		System.out.print(scr0.fg(Ansi.Color.WHITE));
		sel = teclado.nextInt();
		teclado.close();
		return sel;
	}
/**
 * Funci�n principal, donde se gestiona la partida
  * <br>
 * Consultar el m�todo: {@link TresEnRaya#mostrarTablero}
 * @param args	Par�metro sin uso, se manteniene por compatibidad
 * @see "Clase 3 en raya"
 */
	
	public static void main(String[] args) {
		/**
		 * Seudoc�digo
		 *  Instancia partida
		 *  Limpia y muestra tablero
		 *  mientras exista una opci�n valida
		 *  	opcion = menu (Presenta y elige opciones de juego)
		 *  	Ejecuta turnos de jugador 1/2
		 *  	y muestra la jugada
		 *  	o abandona la partida  
		 */
		AnsiConsole.systemInstall();			// Activar
		int opc = -1;
		scr0 = new Ansi();
		// creamos una partida
		TresEnRaya jugar = new TresEnRaya();
		jugar.limpiarTablero();
		jugar.mostrarTablero();
		while (opc != 0) {
			opc = menu();		
		    if((opc == 1) || (opc ==2 )) {
		        jugar.movimientoJugador(opc);
		        jugar.mostrarTablero();
		      } else if(opc==0) {
		        opc = 0;
		        System.out.println(scr0.fg(Ansi.Color.GREEN));
		        System.out.println("Partida Terminada");
		      } else {
		    	  System.out.println(scr0.fg(Ansi.Color.RED));
		    	  System.out.println("Opcion no valida!");
				  opc = -1;
		      }	
		    System.out.println(scr0.fg(Ansi.Color.WHITE));
		} // while
		AnsiConsole.systemUninstall();// Terminar
	}	
}
