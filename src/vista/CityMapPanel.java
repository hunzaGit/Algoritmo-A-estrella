package vista;


import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.EventListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;


// ESTA CLASE ESTA DENTRO DE MAIN WINDOW Y CONTIENE EL PANEL CE CELDAS Y LA IMAGEN DE WALLE 
public class CityMapPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PlaceCell[][] panel; //private matriz de JPlacecells...
	
	public CityMapPanel(){
		inicializarPanel();
	}

	private void inicializarPanel() {
		// TODO Auto-generated method stub
		this.setBorder(new TitledBorder("Mapa(20x20)"));
		this.setName("Mapa");

		panel= new PlaceCell[20][20];
		this.setLayout(new GridLayout(21, 21)); //ordenacion de celdas 20x20
		//INICIALIZACION DE LA TABLA.
		for( int i=0; i< 20;i++){
			for (int j=0; j< 20;j++){
				this.panel[i][j] = new PlaceCell(); 
				this.add(panel[i][j]);
				this.panel[i][j].setColorNormal();
				this.panel[i][j].setToolTipText(Integer.toString(i) + " , " + Integer.toString(j));
			}
		}

	}
	
	//Inicializa los escuchadores de los botones de la matriz
	public void inicializarEscuchadores(EventListener e){
		for(int i=0;i<20;i++){
			for(int j=0; j<20;j++){
				this.panel[i][j].addActionListener((ActionListener) e);
				this.panel[i][j].setName("Map");
				this.panel[i][j].setFila(i);
				this.panel[i][j].setColumna(j);
			}
		}
	}
	
	public void cambiarXY(){
	/*	switch(asd){
		case NORTH: this.x--;break;
		case SOUTH: this.x++;break;
		case WEST: this.y--;break;
		case EAST: this.y++;break;
		default: break;
		}
		*/
	}

	public void inicializarComienzoFin(int xIni, int yIni, int xFin, int yFin) {
		// TODO Auto-generated method stub
		this.panel[xIni][yIni].setColorMeta();
		this.panel[xFin][yFin].setColorMeta();
		/*
		if(!this.lugarActual.equals(lugar)){
			this.panel[x][y].setName("Gris");
			this.panel[x][y].setPlace(this.lugarActual);
			this.lugarActual=lugar;
			this.panel[x][y].setColorAntiguo();
			
			this.cambiarXY(direccion);
			this.panel[x][y].setColorActual();
			this.panel[x][y].setText(lugar.getNombre());
			this.panel[x][y].setName(lugar.getNombre());
		}*/
		
	}
	
	public void pintarCelda(int x, int y){		
		this.panel[x][y].setColorCamino();
	}
	
	public void pintarObstaculo(int x, int y){		
		this.panel[x][y].setColorObstaculo();
	}

	public void pintarFinal(int xFinal, int yFinal) {
		// TODO Auto-generated method stub
		this.panel[xFinal][yFinal].setColorFinal();
	}
}
