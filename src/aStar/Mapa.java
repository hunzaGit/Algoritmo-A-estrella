package aStar;

import java.util.ArrayList;

public class Mapa {

        public int anchuraMapa;
        public int alturaMapa;
        private ArrayList<ArrayList<Nodo>> mapa;
        private int localizacionInicialX = 0;
        private int localizacionInicialY = 0;
        private int localizacionFinalX = 0;
        private int localizacionFinalY = 0;
        private int[][] mapaDeObstaculos;
        
        public Mapa(int ancho, int alto, int[][] obstacleMap) {
                this.anchuraMapa = ancho;
                this.alturaMapa = alto;
                this.mapaDeObstaculos = obstacleMap;
                
                crearMapa();
                establecerBordesMapa();
        }
        private void crearMapa() {
                Nodo node;
                mapa = new ArrayList<ArrayList<Nodo>>();
                for (int x=0; x<anchuraMapa; x++) {
                        mapa.add(new ArrayList<Nodo>());
                        for (int y=0; y<alturaMapa; y++) {
                                node = new Nodo(x,y);
                                if (mapaDeObstaculos[x][y] == 1)
                                        node.setObstical(true);
                                mapa.get(x).add(node);
                        }
                }
        }


        private void establecerBordesMapa() {
                for ( int x = 0; x < anchuraMapa-1; x++ ) {
                        for ( int y = 0; y < alturaMapa-1; y++ ) {
                                Nodo node = mapa.get(x).get(y);
                                if (!(y==0))
                                        node.setNorth(mapa.get(x).get(y-1));
                                if (!(y==0) && !(x==anchuraMapa))
                                        node.setNorthEast(mapa.get(x+1).get(y-1));
                                if (!(x==anchuraMapa))
                                        node.setEast(mapa.get(x+1).get(y));
                                if (!(x==anchuraMapa) && !(y==alturaMapa))
                                        node.setSouthEast(mapa.get(x+1).get(y+1));
                                if (!(y==alturaMapa))
                                        node.setSouth(mapa.get(x).get(y+1));
                                if (!(x==0) && !(y==alturaMapa))
                                        node.setSouthWest(mapa.get(x-1).get(y+1));
                                if (!(x==0))
                                        node.setWest(mapa.get(x-1).get(y));
                                if (!(x==0) && !(y==0))
                                        node.setNorthWest(mapa.get(x-1).get(y-1));
                        }
                }
        }
        
        

        public ArrayList<ArrayList<Nodo>> getNodos() {
                return mapa;
        }
        public void setObstaculo(int x, int y, boolean isObstical) {
                mapa.get(x).get(y).setObstical(isObstical);
        }

        public Nodo getNodo(int x, int y) {
                return mapa.get(x).get(y);
        }

        public void setLocalizacionInicial(int x, int y) {
                mapa.get(localizacionInicialX).get(localizacionInicialY).setStart(false);
                mapa.get(x).get(y).setStart(true);
                localizacionInicialX = x;
                localizacionInicialY = y;
        }

        public void setLocalizacionDeLaMeta(int x, int y) {
                mapa.get(localizacionFinalX).get(localizacionFinalY).setGoal(false);
                mapa.get(x).get(y).setGoal(true);
                localizacionFinalX = x;
                localizacionFinalY = y;
        }

        public int getLocalizacionInicialX() {
                return localizacionInicialX;
        }

        public int getLocalizacionInicialY() {
                return localizacionInicialY;
        }
        
        public Nodo getNodoInicial() {
                return mapa.get(localizacionInicialX).get(localizacionInicialY);
        }

        public int getLocalizacionFinalX() {
                return localizacionFinalX;
        }

        public int getLocalizacionFinalY() {
                return localizacionFinalY;
        }
        
        public Nodo getLocalizacionFinal() {
                return mapa.get(localizacionFinalX).get(localizacionFinalY);
        }
        public ArrayList<ArrayList<Nodo>> getMapa(){
        	return mapa;
        }
        
        public float getDistanceBetween(Nodo node1, Nodo node2) {
                //if the nodes are on top or next to each other, return 1
                if (node1.getX() == node2.getX() || node1.getY() == node2.getY()){
                        return 1*(alturaMapa+anchuraMapa);
                } else { //if they are diagonal to each other return diagonal distance: sqrt(1^2+1^2)
                        return (float) 1.7*(alturaMapa+anchuraMapa);
                }
        }
        
        public int getAnchuraMapaLogico() {
                return anchuraMapa;
        }
        public int getAlturaMapaLogico() {
                return alturaMapa;
        }
        public void clear() {
                localizacionInicialX = 0;
                localizacionInicialY = 0;
                localizacionFinalX = 0;
                localizacionFinalY = 0;
                crearMapa();
                establecerBordesMapa ();
        }
}