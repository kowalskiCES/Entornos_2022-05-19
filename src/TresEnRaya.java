import java.util.Scanner;
import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.Ansi.Color;

/**
 * UT 6.- Documentación y control de versiones: Tres en raya
 * @author lone
 * @version 1.1
 * 
 * Curso 2021 - 2022
 * Entornos de Desarrollo (GDAM)
 *
 */
public class TresEnRaya {

	// Atributos
/**
 * Tablero de la partida 	
 */
	private char[][] tablero;
/**
 *  Identifica el turno actual jugador1 ó jugador2
 */
	private int jugada;
/**
 * Caracter para representar la ficha de cada jugador
 */
	private final char[] ficha = {'X','O'};

	/**
	 * Objeto terminal ansi
	 * @see <a href="https://javadoc.io/doc/org.fusesource.jansi/jansi/latest/index.html">Jansi 2.4.0</a> 
	 */
	Ansi scr;
	
	// Metodos

	/**
	 * Contructor
	 * Crea un tablero vacío
	 * 
	 * texto en negrita!
	 */
	public  TresEnRaya() {
		tablero = new char[3][3];
		jugada = 0;
		scr = MainTresEnRaya.scr0;
		System.out.println(scr.fgBrightMagenta());
		System.out.println("Creando un tablero para la partida ...");
		System.out.println(scr.fg(Ansi.Color.WHITE));
	}
	
	/**
	 * setjugada: setter para la propiedad jugada
	 * @param valor : Identifica quien realiza la jugada
	 * @author lone
	 */
	void setjugada(int valor) {
		jugada = valor;
		
	}
	/**
	 * setter para la propiedad jugada
	 *  @return jugada: Devuelve el valor de la propiedad jugada
	  * @author lone
	 */
	int getjugada() {
		return jugada;
		
	}
	char[][] getTablero(){
        return this.tablero;
    }

	/**
	 * limpiarTablero: Inicializa el tablero, eliminando
	 * cualquier ficha existente
	 * @author lone
	 */
	
	void limpiarTablero() {
		
		
		for (int i=0; i< tablero.length; i++){
			for (int j=0; j< tablero.length; j++) {
				tablero[i][j]=  '-';
			}
		}
		
	}
	/**
	 * muestraTablero: Pinta el tablero con el estado 
	 * actual de la partida
	 * @author lone
	 */
	
	
	void mostrarTablero() {
		char celda;
		Color colorcelda = Ansi.Color.WHITE;
		
		System.out.println();
		for (int i=0; i< tablero.length; i++){
			System.out.print("     ");
			for (int j=0; j< tablero.length; j++) {	
				celda = tablero[i][j];
				switch (celda){
					case 'X':
						colorcelda = Ansi.Color.RED;
						break;
					case 'O':
						colorcelda = Ansi.Color.BLUE;
						break;
					case '-':
						colorcelda = Ansi.Color.WHITE;
					}
				System.out.print(scr.fg(colorcelda));
				System.out.print(celda);
				System.out.print(scr.fg(Ansi.Color.WHITE));
				System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println();
		
	}
	/**
	 * Solicita la posición de la ficha y la coloca en el tablero.
	 * No está implementada la comprobación de posición válida de la ficha.
	 * <br> Utiliza {@link TresEnRaya#marcarCelda} 
	 * @param Jugador : Jugador que realiza el movimiento.
	 * @author lone
	 */	
	void movimientoJugador(int Jugador) {
		
		Scanner teclado = new Scanner( System.in);
		int fi,co;
		System.out.println(scr.fgBrightYellow());
		System.out.print("Mueve Jugador ");
		System.out.println(Jugador);
		System.out.print(scr.fg(Ansi.Color.GREEN));
		System.out.print("\nFila?: ");
		System.out.print(scr.fg(Ansi.Color.WHITE));
		fi = teclado.nextInt();
		System.out.print(scr.fg(Ansi.Color.GREEN));
		System.out.print("\nColumna?: ");
		System.out.print(scr.fg(Ansi.Color.WHITE));
		co = teclado.nextInt();
		marcarCelda(fi,co,ficha[Jugador-1]);
		teclado.close();
	}
/**
 * marcarCelda: Coloca la ficha en el tablero
 * @param fila		Fila donde colocar la ficha
 * @param columna     Columna donde colocar la ficha
 * @param valor		Propiedad de la ficha: (X) Jugador 1, (O) Jugador 2
 * @author lone
 */
	void marcarCelda(int fila, int columna,char valor) {
		
		tablero[fila][columna]= valor;
		
	}


	boolean posicionLibre(int fila,int columna){
    
    if (tablero[fila][columna]=='-') return true; else return false;
    }

int huecosLibres(){
    int hl=0;    
    for (int i=0; i< tablero.length; i++){
        for (int j=0; j< tablero.length; j++) {
	if (tablero[i][j]==  '-') hl++;
        }
}
    return hl;
    }

	
}
