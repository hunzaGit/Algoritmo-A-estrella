package Presentacion.Controlador;

import Negocio.Transfer;
import Negocio.aStar.Algoritmo_A_Estrella;
import Negocio.aStar.Mapa;
import Negocio.cronometro.Cronometro;
import Negocio.heuristica.CalcularDistanciaLineaRecta;

public class Controlador {

	
	Algoritmo_A_Estrella pathFinder;
	private CalcularDistanciaLineaRecta interfazHeuristic;
	private Mapa mapaLogico;
	
	
	
	
	
	
	
	public Controlador(int anchuraTablero, int alturaTablero) {

		// Inicializamos el mapa.
		mapaLogico = new Mapa(anchuraTablero, alturaTablero);
		// Inicializamos la heurística.
		interfazHeuristic = new CalcularDistanciaLineaRecta();
		
		// Inicializamos el algoritmo
		pathFinder = new Algoritmo_A_Estrella(mapaLogico, interfazHeuristic);
	}







	public Object action(int evento, Object datos) {
		
		
		switch (evento) {
		
			case EventoGUI.CALCULAR_CAMINO_MAS_CORTO:{
				Transfer miTransfer = (Transfer) datos;
				
				Cronometro crono = new Cronometro();
				crono.start();
				pathFinder.calcularCaminoMasCorto(miTransfer.getCoorInicio(), miTransfer.getCoorFin(), miTransfer.getObstacleMap());
				
				crono.stop();
				
				miTransfer = new Transfer();
				miTransfer.setCosteTiempo(crono.getElapsedTime());
				datos = miTransfer;
				
			}break;
	
			case EventoGUI.GET_CAMINO_MAS_CORTO:
				
				datos = pathFinder.getCaminoMasCorto();
				
				break;
				
			default:
				break;
		}
		return datos;
	}
	
	
}
