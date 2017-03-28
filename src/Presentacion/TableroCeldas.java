package Presentacion;


import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.EventListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;


public class TableroCeldas extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Celda[][] panel; //private matriz de JPlacecells...
	private int altura = 10;
	private int anchura = 15;
	
	public TableroCeldas(int anchura, int altura){
		this.anchura = anchura;
		this.altura = altura;
		inicializarPanel();
	}

	private void inicializarPanel() {
		// TODO Auto-generated method stub
		
		this.setBorder(BorderFactory.createTitledBorder(""));
		this.setName("Tablero");

		
		panel= new Celda[anchura][altura];
		this.setLayout(new GridLayout(anchura, altura)); //ordenacion de celdas alto x ancho
		//INICIALIZACION DE LA TABLA.
		for( int x=0; x< anchura;x++){
			for (int y=0; y< altura;y++){
				this.panel[x][y] = new Celda(); 
				this.add(panel[x][y]);
				this.panel[x][y].setColorNormal();
				this.panel[x][y].setToolTipText(Integer.toString(x) + " , " + Integer.toString(y));
			}
		}

	}
	
	//Inicializa los escuchadores de los botones de la matriz
	public void inicializarEscuchadores(EventListener e){
		for(int x=0;x<anchura;x++){
			for(int y=0; y<altura;y++){
				this.panel[x][y].addActionListener((ActionListener) e);
				this.panel[x][y].setName("Map");
				this.panel[x][y].setFila(x);
				this.panel[x][y].setColumna(y);
			}
		}
	}
	
	
	public void pintarCeldaCamino(int x, int y){		
		this.panel[x][y].setColorCamino();
	}
	
	public void pintarCeldaNormal(int x, int y){		
		this.panel[x][y].setColorNormal();
	}
	
	public void pintarObstaculo(int x, int y){		
		this.panel[x][y].setColorObstaculo();
	}

	public void pintarFinal(int xFinal, int yFinal) {
		// TODO Auto-generated method stub
		this.panel[xFinal][yFinal].setColorFinal();
	}
	
	public void pintarInicio(int x, int y) {
		// TODO Auto-generated method stub
		this.panel[x][y].setColorInicio();
	}

	/**
	 * @return the altura
	 */
	public int getAltura() {
		return altura;
	}

	/**
	 * @param altura the altura to set
	 */
	public void setAltura(int altura) {
		this.altura = altura;
	}

	/**
	 * @return the anchura
	 */
	public int getAnchura() {
		return anchura;
	}

	/**
	 * @param anchura the anchura to set
	 */
	public void setAnchura(int anchura) {
		this.anchura = anchura;
	}
	
	
	public Celda getCelda(int x, int y) {
		return panel[x][y];
	}
	
}
