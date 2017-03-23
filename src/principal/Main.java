package principal;

import java.util.Random;
import java.util.Scanner;

import javax.swing.SwingUtilities;

import vista.VentanaPrincipal;
import cronometro.Cronometro;

public class Main {

	private static int anchuraMapa;
	private static int alturaMapa;
	private static int startX;
	private static int startY;
	private static int goalX;
	private static int goalY;
	private int numObstaculos;
	private static int[][] obstacleMap;

	//
	// ={{0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0},
	// {0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,1,1,0},
	// {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,1,0,0},
	// {0,0,0,0,1,1,0,0,1,0,0,0,0,0,0,1,1,0,0,0},
	// {0,1,1,1,1,0,0,1,1,0,0,0,0,0,1,1,0,0,0,0},
	// {0,0,0,0,0,0,0,1,0,0,0,0,0,1,1,0,0,0,0,0},
	// {1,1,1,1,1,1,1,1,0,0,0,0,1,1,0,0,0,0,0,0},
	// {0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0},
	// {0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0},
	// {0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0},
	// {0,0,0,0,0,0,0,0,1,1,0,0,0,0,1,1,0,0,0,0},
	// {0,0,0,0,0,0,0,1,1,0,0,0,1,1,1,0,0,0,0,0},
	// {0,0,0,0,0,0,1,1,0,0,0,0,1,0,0,0,0,0,0,0},
	// {0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
	// {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	// {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	// {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	// {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	// {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	// {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};

	// private void inicializa (){
	//
	// mapWith = 20;
	// mapHeight = 20;
	// startX = 0;
	// startY = 1;
	// goalX = 19;
	// goalY = 15;
	//
	// }

	private void inicializa(int ancho, int alto, int sX, int sY, int gX,
			int gY, int obstaculos) {

		anchuraMapa = ancho;
		alturaMapa = alto;
		startX = sX;
		startY = sY;
		goalX = gX;
		goalY = gY;
		obstacleMap = new int[anchuraMapa][alturaMapa];
		numObstaculos = obstaculos;

	}

	public void pedirDatos() {

		int ancho = 0;
		int alto = 0;
		int iniX = 0;
		int iniY = 0;
		int finX = 0;
		int finY = 0;
		int Obstaculos = 0;

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduzca Ancho del mapa");
		ancho = Integer.parseInt(sc.nextLine());
		System.out.println("Introduzca Alto del mapa");
		alto = Integer.parseInt(sc.nextLine());
		System.out.println("Introduzca posición de inicio X");
		iniX = Integer.parseInt(sc.nextLine());
		System.out.println("Introduzca posición de inicio Y");
		iniY = Integer.parseInt(sc.nextLine());
		System.out.println("Introduzca posición final X");
		finX = Integer.parseInt(sc.nextLine());
		System.out.println("Introduzca posición final Y");
		finY = Integer.parseInt(sc.nextLine());
		System.out.println("Introduzca el numero de obstaculos");
		Obstaculos = Integer.parseInt(sc.nextLine());

		inicializa(ancho, alto, iniX, iniY, finX, finY, Obstaculos);

	}

	public void insertarObstaculos() {

		int j = 0;
		int k = 0;
		Random rnd = new Random();
		for (int i = 0; i < numObstaculos; i++) {
			boolean coincide = false;
			do {
				j = rnd.nextInt(anchuraMapa - 1);
				k = rnd.nextInt(alturaMapa - 1);
				if ((j == startX) && (k == startY)) {
					coincide = true;
				}
				if ((j == goalX) && (k == goalY)) {
					coincide = true;
				}
			} while (coincide);
			obstacleMap[j][k] = 1;
		}

	}

	public static void main(String[] args) {


		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>
	

		Main p = new Main();
		//Cronometro s = new Cronometro();
		// p.pedirDatos();
		p.insertarObstaculos();

		// Ponemos en marcha el cronómetro.
		//s.start();

		// Inicializamos el mapa.
		// Mapa map = new Mapa(anchuraMapa, alturaMapa, obstacleMap);

		// Inicializamos la heurística.
		// InterfazHeuristica heuristic = new CalcularDistanciaLineaRecta();

		// Inicializamos el algoritmo
		// AEstrella pathFinder = new AEstrella(map, heuristic);

		// iniciamos vista

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new VentanaPrincipal(15, 10).pintarse();
			}
		});
		
		
		/*
		 * 
		 * 
		 * // Calculamos el camino más corto.
		 * pathFinder.calcularCaminoMasCorto(startX, startY, goalX, goalY);
		 * 
		 * // Paramos el cronómetro. s.stop();
		 * 
		 * System.out.print(("ha tardado en calcular el camino " +
		 * s.getElapsedTime()) + " milisegundos");
		 * 
		 * // Mostramos el camino en el mapa. System.out.println(" ");
		 * System.out.print(" "); pathFinder.PintarCamino();
		 */
	}
}
