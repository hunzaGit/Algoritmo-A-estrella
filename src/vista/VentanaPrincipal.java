package vista;

import heuristica.CalcularDistanciaLineaRecta;
import heuristica.InterfazHeuristica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

import aStar.AEstrella;
import aStar.Camino;
import aStar.Mapa;
import aStar.Nodo;

/**
 * 
 * @author usuario_local
 */
public class VentanaPrincipal extends javax.swing.JFrame implements
		ActionListener {
	// Variables declaration - do not modify
	private javax.swing.JButton jButtonComenzar;
	private javax.swing.JButton jButtonReiniciar;
	private javax.swing.JButton jButtonRedimensionar;

	private javax.swing.JLabel jLabelNombre;
	private javax.swing.JLabel jLabelFacultad;

	private javax.swing.JPanel panelTablero;
	private javax.swing.JPanel panelInputs;
	// private javax.swing.JPanel panelTablero;

	private javax.swing.JLabel jLabelInicio;
	private javax.swing.JTextField textFieldIniX;
	private javax.swing.JTextField textFieldIniY;

	private javax.swing.JLabel jLabelFinal;
	private javax.swing.JTextField textFieldFinX;
	private javax.swing.JTextField textFieldFinY;

	private javax.swing.JLabel jLabelDimensionTablero;
	private javax.swing.JTextField textFieldAnchuraTablero;
	private javax.swing.JTextField textFieldAlturaTablero;

	private int anchuraTablero = 15;
	private int alturaTablero = 10;

	// End of variables declaration
	private TableroCeldas tableroCeldas;
	private Mapa mapaLogico;
	InterfazHeuristica interfazHeuristic;
	AEstrella pathFinder;
	int[][] obstacleMap;
	Nodo nodo;
	private JLabel jLabelTama�o;
	private JPanel panelInputsIni;
	private JPanel panelInputsFin;
	private JPanel panelInputsTam;
	private JPanel panelInputsIniFin;
	private JPanel panelTamInputs;
	private JPanel panelInsputsSolo;

	// //////////////////////////////
	/**
	 * Creates new form Principal
	 */
	public VentanaPrincipal(Mapa map, InterfazHeuristica h, AEstrella pathFinder) {
		tableroCeldas = new TableroCeldas(this.anchuraTablero,
				this.alturaTablero);
		tableroCeldas.setAltura(alturaTablero);
		tableroCeldas.setAnchura(anchuraTablero);
		this.mapaLogico = map;
		interfazHeuristic = h;
		this.pathFinder = pathFinder;
		create();
		
		textFieldIniX.requestFocus();
		textFieldIniX.requestFocus(true);
	
	}

	public VentanaPrincipal(int anchura, int altura) {
		this.anchuraTablero = anchura;
		this.alturaTablero = altura;
		tableroCeldas = new TableroCeldas(this.anchuraTablero,
				this.alturaTablero);
		;
		tableroCeldas.setAltura(alturaTablero);
		tableroCeldas.setAnchura(anchuraTablero);
		tableroCeldas.inicializarEscuchadores(this);
		obstacleMap = new int[anchuraTablero + 1][alturaTablero + 1];
		create();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	private void create() {
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

		this.setSize(1200, 1000);
		this.setTitle("Algortimo A* [ "+ anchuraTablero +"x" + alturaTablero + " ] - Rodrigo de Miguel Gonz�lez");
		jLabelNombre = new javax.swing.JLabel();
		jLabelFacultad = new javax.swing.JLabel();

		jButtonComenzar = new javax.swing.JButton("Iniciar");
		jButtonReiniciar = new javax.swing.JButton("Reiniciar");
		jButtonRedimensionar = new javax.swing.JButton("Redimensionar");

		textFieldIniX = new javax.swing.JTextField(5);
		
		textFieldIniY = new javax.swing.JTextField(5);
		textFieldFinX = new javax.swing.JTextField(5);
		textFieldFinY = new javax.swing.JTextField(5);

		textFieldAlturaTablero = new javax.swing.JTextField(5);
		textFieldAnchuraTablero = new javax.swing.JTextField(5);

		jLabelInicio = new javax.swing.JLabel();
		jLabelFinal = new javax.swing.JLabel();

		panelTablero = new javax.swing.JPanel();
		panelInputs = new JPanel();
		panelInputsIni = new JPanel();
		panelInputsFin = new JPanel();
		panelInputsTam = new JPanel();

		Font font = new Font("Futura", Font.BOLD, 12);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		String nombre = "Rodrigo de Miguel Gonz�lez";
		String facultad = "Facultad Informatica - UCM";
		nombre = "";
		facultad = "";
		jLabelNombre.setText(nombre);
		jLabelNombre.setFont(font);
		jLabelFacultad.setText(facultad);
		jLabelFacultad.setFont(font);

		// ImageIcon imgStart= new
		// ImageIcon(this.getClass().getResource("/images/start.png"));
		// ImageIcon imgRestart= new
		// ImageIcon(this.getClass().getResource("/images/restart.png"));
		// jButton1.setIcon(imgStart);
		// jButton2.setIcon(imgRestart);

		jLabelInicio.setText("Inicio:");
		jLabelInicio.setFont(font);
		jLabelFinal.setText("Final:");
		jLabelFinal.setFont(font);

		jLabelTama�o = new JLabel("Tama�o:");

		// javax.swing.GroupLayout jPanel1Layout = new
		// javax.swing.GroupLayout(panelTablero);
		// ********
		//panelTablero.setBorder(BorderFactory.createLineBorder(Color.red));

		//panelInputs.setBorder(BorderFactory.createLineBorder(Color.red));

		// ******
		// panelTablero.setLayout(jPanel1Layout);
		// panelInputs.setLayout(jPanel1Layout);

		// jPanel1Layout.setHorizontalGroup(
		// jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		// .addComponent(tableroCeldas,
		// javax.swing.GroupLayout.Alignment.TRAILING,
		// javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
		// );
		//
		// jPanel1Layout.setVerticalGroup(
		// jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		// .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
		// jPanel1Layout.createSequentialGroup()
		// .addGap(0, 11, Short.MAX_VALUE)
		// .addComponent(tableroCeldas, javax.swing.GroupLayout.PREFERRED_SIZE,
		// 500, javax.swing.GroupLayout.PREFERRED_SIZE))
		// );

		// javax.swing.GroupLayout layout = new
		// javax.swing.GroupLayout(getContentPane());
		// getContentPane().setLayout(layout);
		//

		panelInputsIniFin = new JPanel();
		panelInputsIniFin.setLayout(new BorderLayout());
		panelInsputsSolo = new JPanel();
		panelInputsIniFin.setBorder(BorderFactory.createTitledBorder(""));

		this.setLayout(new BorderLayout());
		panelTablero.add(tableroCeldas);
		// panelTablero.setSize(900, 800);

		panelInputs.setLayout(new FlowLayout());

		// panelInputsIni.add(jLabelInicio);
		panelInputsIni.add(textFieldIniX);
		panelInputsIni.add(textFieldIniY);
		panelInputsIni.setBorder(BorderFactory.createTitledBorder("Inicio"));
		panelInsputsSolo.add(panelInputsIni);

		// panelInputsFin.add(jLabelFinal);
		panelInputsFin.add(textFieldFinX);
		panelInputsFin.add(textFieldFinY);
		panelInputsFin.setBorder(BorderFactory.createTitledBorder("Final"));
		panelInsputsSolo.add(panelInputsFin);

		// panelInputsIniFin.add(panelInputsIni);
		// panelInputsIniFin.add(panelInputsFin);

		panelInputsIniFin.add(panelInsputsSolo);
		panelInputsIniFin.add(jButtonComenzar, BorderLayout.SOUTH);

		// panelInputsTam.add(jLabelTama�o);
		panelInputsTam.setLayout(new BorderLayout());
		panelTamInputs = new JPanel();

		panelTamInputs.add(textFieldAnchuraTablero);
		panelTamInputs.add(textFieldAlturaTablero);
		panelInputsTam.add(panelTamInputs);
		panelInputsTam.setBorder(BorderFactory
				.createTitledBorder("Tablero[ "+ anchuraTablero +"x" + alturaTablero + " ]"));
		panelInputsTam.add(jButtonRedimensionar, BorderLayout.SOUTH);

		panelInputs.add(panelInputsIniFin);

		panelInputs.add(panelInputsTam);

		panelInputs.add(jButtonReiniciar);

		this.add(tableroCeldas, BorderLayout.CENTER);
		this.add(panelInputs, BorderLayout.SOUTH);

		jButtonReiniciar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaPrincipal.this.restaurarVentana();
			}
		});

		// ////////////////////////////empezar////////////////////////////////////////
		jButtonComenzar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// /comprobaciones que nos han puesto lo que nos tendrian que
				// poner
				try {

					int xInicio = Integer.parseInt(textFieldIniX.getText());
					int yInicio = Integer.parseInt(textFieldIniY.getText());

					int xFinal = Integer.parseInt(textFieldFinX.getText());
					int yFinal = Integer.parseInt(textFieldFinY.getText());

					if (xInicio > anchuraTablero - 1)
						JOptionPane.showMessageDialog(null,
								"Coor X Inicio fuera de rango");
					else if (yInicio > alturaTablero - 1)
						JOptionPane.showMessageDialog(null,
								"Coor Y Inicio fuera de rango");
					else if (xFinal > anchuraTablero - 1)
						JOptionPane.showMessageDialog(null,
								"Coor X Final fuera de rango");
					else if (yFinal > alturaTablero - 1)
						JOptionPane.showMessageDialog(null,
								"Coor Y Final fuera de rango");
					else {

						tableroCeldas.inicializarComienzoFin(xInicio, yInicio,
								xFinal, yFinal);
						// Inicializamos el mapa.
						mapaLogico = new Mapa(anchuraTablero, alturaTablero,
								obstacleMap);
						// Inicializamos la heur�stica.
						interfazHeuristic = new CalcularDistanciaLineaRecta();
						// Inicializamos el algoritmo
						pathFinder = new AEstrella(mapaLogico,
								interfazHeuristic);
						// Calculamos el camino m�s corto.
						pathFinder.calcularCaminoMasCorto(xInicio, yInicio,
								xFinal, yFinal);

						Camino caminoMasCorto = pathFinder.getCaminoMasCorto();
						pintarCaminoCeldas(caminoMasCorto);
					}
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null,
							"Introduzca un n�mero valido");
				}
			}
		});

		textFieldIniY.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				try {

					int xInicio = Integer.parseInt(textFieldIniX.getText());
					int yInicio = Integer.parseInt(textFieldIniY.getText());

					if (xInicio > anchuraTablero - 1)
						JOptionPane.showMessageDialog(null,
								"Coor X Inicio fuera de rango");
					else if (yInicio > alturaTablero - 1)
						JOptionPane.showMessageDialog(null,
								"Coor Y Inicio fuera de rango");
					else {

						tableroCeldas.getCelda(xInicio, yInicio).setColorMeta();

					}
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null,
							"Introduzca un n�mero valido");
				}

			}
		});

		textFieldIniY.addFocusListener(new FocusListener() {

			public void focusLost(FocusEvent arg0) {

				try {

					int xInicio = Integer.parseInt(textFieldIniX.getText());
					int yInicio = Integer.parseInt(textFieldIniY.getText());

					if (xInicio > anchuraTablero - 1)
						JOptionPane.showMessageDialog(null,
								"Coor X Inicio fuera de rango");
					else if (yInicio > alturaTablero - 1)
						JOptionPane.showMessageDialog(null,
								"Coor Y Inicio fuera de rango");
					else {

						tableroCeldas.getCelda(xInicio, yInicio).setColorMeta();

					}
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null,
							"Introduzca un n�mero valido");
				}
			}

			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		textFieldFinY.addFocusListener(new FocusListener() {

			public void focusLost(FocusEvent arg0) {

				try {

					int xFinal = Integer.parseInt(textFieldFinX.getText());
					int yFinal = Integer.parseInt(textFieldFinY.getText());

					if (xFinal > anchuraTablero - 1)
						JOptionPane.showMessageDialog(null,
								"Coor X Final fuera de rango");
					else if (yFinal > alturaTablero - 1)
						JOptionPane.showMessageDialog(null,
								"Coor Y Final fuera de rango");
					else {

						tableroCeldas.getCelda(xFinal, yFinal).setColorFinal();

					}
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null,
							"Introduzca un n�mero valido");
				}
			}

			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		jButtonComenzar.addKeyListener(new KeyListener() {
			
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void keyPressed(KeyEvent arg0) {
				//
				// Si la tecla presionada es el ENTER (KeyCode = 10) enviamos el mensaje
				if (arg0.getKeyCode() == 10) {
					jButtonComenzar.doClick();
					jButtonReiniciar.requestFocus();
				}
				
			}
		});
		
		jButtonReiniciar.addKeyListener(new KeyListener() {
			
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void keyPressed(KeyEvent arg0) {
				//
				// Si la tecla presionada es el ENTER (KeyCode = 10) enviamos el mensaje
				if (arg0.getKeyCode() == 10) {
					jButtonReiniciar.doClick();
					
				}
				
			}
		});
		
		jButtonRedimensionar.addKeyListener(new KeyListener() {
			
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void keyPressed(KeyEvent arg0) {
				//
				// Si la tecla presionada es el ENTER (KeyCode = 10) enviamos el mensaje
				if (arg0.getKeyCode() == 10) {
					jButtonRedimensionar.doClick();
				}
				
			}
		});
		
		jButtonRedimensionar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {

					int anchura = Integer.parseInt(textFieldAnchuraTablero
							.getText());
					int altura = Integer.parseInt(textFieldAlturaTablero
							.getText());

//					System.out.println("anchura: " + anchura);
//					System.out.println("altura: " + altura);

					VentanaPrincipal.this.alturaTablero = altura;
					VentanaPrincipal.this.anchuraTablero = anchura;
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null,
							"Introduzca un n�mero valido");
				}

				VentanaPrincipal.this.restaurarVentana();
			}
		});

		// ///////////////////////////////////////////////////////////////////////////

		setSize(1000, 700);
		textFieldIniX.requestFocus();
		setLocationRelativeTo(this);

		// pack();
		textFieldIniX.requestFocus();
	}// </editor-fold>

	protected void pintarCaminoCeldas(final Camino caminoMasCorto) {
		// TODO Auto-generated method stub
		new Thread(new Runnable() {

			public void run() {
				if (caminoMasCorto == null) {
					JOptionPane.showMessageDialog(null,
							"No existe un camino posible");
					restaurarVentana();
				} // no hay camino
				else
					for (int x = 0; x < mapaLogico.getAnchuraMapaLogico(); x++) {

						for (int y = 0; y < mapaLogico.getAlturaMapaLogico(); y++) {
							nodo = mapaLogico.getNodo(x, y);

							if (caminoMasCorto.contains(nodo.getX(),
									nodo.getY())) {
								try {
									// Retardo para pintar celdas
									Thread.sleep(200);

									if (x < mapaLogico.getAnchuraMapaLogico()) {
										tableroCeldas.pintarCelda(nodo.getX(),
												nodo.getY());
									}
								} catch (InterruptedException e) {
								}

							}
						}

					}
				int xFinal = Integer.parseInt(textFieldFinX.getText());
				int yFinal = Integer.parseInt(textFieldFinY.getText());
				tableroCeldas.pintarFinal(xFinal, yFinal);
			}

		}).start();
	}

	protected void restaurarVentana() {
		dispose();
		new VentanaPrincipal(anchuraTablero, alturaTablero).pintarse();
	}

	public void pintarse() {

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger
					.getLogger(VentanaPrincipal.class.getName()).log(
							java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger
					.getLogger(VentanaPrincipal.class.getName()).log(
							java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger
					.getLogger(VentanaPrincipal.class.getName()).log(
							java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger
					.getLogger(VentanaPrincipal.class.getName()).log(
							java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				setVisible(true);
			}
		});

	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Celda fuente = (Celda) arg0.getSource(); // el que gener� el evento
		tableroCeldas.pintarObstaculo(fuente.getFila(), fuente.getColumna());
		obstacleMap[fuente.getFila()][fuente.getColumna()] = 1;
	}

}