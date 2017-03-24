

import java.util.Random;
import java.util.Scanner;

import javax.swing.SwingUtilities;

import Presentacion.VentanaPrincipal;

public class Main {

	private static int anchuraMapa;
	private static int alturaMapa;
	private static int startX;
	private static int startY;
	private static int goalX;
	private static int goalY;
	private int numObstaculos;
	private static int[][] obstacleMap;


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
	

		Main p = new Main();

		//p.insertarObstaculos();


		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new VentanaPrincipal(15, 10).pintarse();
			}
		});

	}
}
