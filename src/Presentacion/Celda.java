package Presentacion;

import java.awt.Color;

import javax.swing.JButton;
//ESTO ESTA DENTRO DE TableroCeldas
public class Celda extends JButton{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int fila;
	private int columna;
	
	public Celda(){

		this.setFocusable(false);
	}

public void setColorNormal(){
	this.setBackground(Color.GRAY);
}
public void setColorMeta(){
	this.setBackground(Color.YELLOW);
}
public void setColorCamino(){
	setBackground(Color.DARK_GRAY);
}

public void setColorObstaculo(){
	this.setBackground(Color.RED);
}

public int getColumna() {
	return columna;
}

public void setColumna(int columna) {
	this.columna = columna;
}

public int getFila() {
	return fila;
}

public void setFila(int fila) {
	this.fila = fila;
}

public void setColorFinal() {
	// TODO Auto-generated method stub
	//ImageIcon imgMeta= new ImageIcon(this.getClass().getResource("/images/meta.png"));
	//this.setIcon(imgMeta);
	this.setBackground(Color.green);
}

}
