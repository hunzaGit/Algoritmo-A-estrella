package Negocio.heuristica;


/**
 * A heuristic that uses the tile that is closest to the target
 * as the next best tile.
 */
public class CalcularDistanciaLineaRecta implements InterfazHeuristica {

        public float calcularDistanciaAMeta(int startX, int startY, int goalX, int goalY) {         
            
        	//Distancia en el eje de las x
        	float dx = goalX - startX;
        	//Distancia en el eje de las y
            float dy = goalY - startY;
            //Calculamos la distancia utilizando el teorema de pitagoras
            return (float) Math.sqrt((dx*dx)+(dy*dy));
        }

}