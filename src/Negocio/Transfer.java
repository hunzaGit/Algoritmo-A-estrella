package Negocio;

import javax.swing.BorderFactory;

import Negocio.aStar.Algoritmo_A_Estrella;
import Negocio.aStar.Camino;
import Negocio.aStar.Mapa;
import Negocio.aStar.Nodo;
import Negocio.cronometro.Cronometro;
import Negocio.heuristica.CalcularDistanciaLineaRecta;
import Negocio.heuristica.InterfazHeuristica;

public class Transfer {
	
	private Coordenadas coorInicio;
	private Coordenadas coorFin;
	
	private int[][] obstacleMap;

	private long costeTiempo;
	
	/** Constructor del Transfer
	 * @param coorInicio Coordenada de inicio de camino
	 * @param coorFin Coordenada de Fin de camino
	 * @param obstacleMap Matriz con los obstaculos
	 */
	public Transfer(Coordenadas coorInicio, Coordenadas coorFin,
			int[][] obstacleMap) {
		
		this.coorInicio = coorInicio;
		this.coorFin = coorFin;
		this.obstacleMap = obstacleMap;
	}
	
	
	public Transfer() {
		
	}


	/**
	 * @return the coorInicio
	 */
	public Coordenadas getCoorInicio() {
		return coorInicio;
	}
	/**
	 * @param coorInicio the coorInicio to set
	 */
	public void setCoorInicio(Coordenadas coorInicio) {
		this.coorInicio = coorInicio;
	}
	/**
	 * @return the coorFin
	 */
	public Coordenadas getCoorFin() {
		return coorFin;
	}
	/**
	 * @param coorFin the coorFin to set
	 */
	public void setCoorFin(Coordenadas coorFin) {
		this.coorFin = coorFin;
	}
	/**
	 * @return the obstacleMap
	 */
	public int[][] getObstacleMap() {
		return obstacleMap;
	}
	/**
	 * @param obstacleMap the obstacleMap to set
	 */
	public void setObstacleMap(int[][] obstacleMap) {
		this.obstacleMap = obstacleMap;
	}


	public long getCosteTiempo() {
		return costeTiempo;
	}


	public void setCosteTiempo(long costeTiempo) {
		this.costeTiempo = costeTiempo;
	}
	

}


/*


Cronometro crono = new Cronometro();
						crono.start();

						// Calcula la ruta con estos obstaculos

						// Inicializamos el mapa.
						mapaLogico = new Mapa(anchuraTablero, alturaTablero,
								obstacleMap);

						// Inicializamos la heurística.
						interfazHeuristic = new CalcularDistanciaLineaRecta();

						// Inicializamos el algoritmo
						pathFinder = new Algoritmo_A_Estrella(mapaLogico,
								interfazHeuristic);

						// Calculamos el camino más corto.
						//Transfer miTransfer = new Transfer();	
						//control.action(EventoGUI.CALCULAR_CAMINO_MAS_CORTO, TRNASFER(COORDiNICIO, cOORDfIN, OBSTACLEmAP) );
						pathFinder.calcularCaminoMasCorto(new Coordenadas(xInicio, yInicio), new Coordenadas(xFinal, yFinal), obstacleMap);

						Camino caminoMasCorto = pathFinder.getCaminoMasCorto();
						crono.stop();

						panelInputsTam.setBorder(BorderFactory
								.createTitledBorder(stringTamañoTiempoTablero.concat(" - " 
										+ crono.getElapsedTime() + " ms")));
						
						
						pintarCaminoCeldas(caminoMasCorto);








  public Camino calcularCaminoMasCorto(Coordenadas coord_inicio, Coordenadas coord_Fin, int[][] mapaDeObstaculos) {

        		map.setMapaDeObstaculos(mapaDeObstaculos);
        		map.setLocalizacionInicial(coord_inicio.getCoord_x(), coord_inicio.getCoord_Y());
        		map.setLocalizacionInicial(coord_Fin.getCoord_x(), coord_Fin.getCoord_Y());
                

                if (map.getNodo(coord_Fin.getCoord_x(), coord_Fin.getCoord_Y()).isObstacle()) {
                        return null;
                }







*/