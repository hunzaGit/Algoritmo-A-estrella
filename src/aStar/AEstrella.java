package aStar;

import heuristica.InterfazHeuristica;

import java.util.ArrayList;
import java.util.Collections;


public class AEstrella {
        private Mapa map;
        private InterfazHeuristica heuristic;
      
        private ArrayList<Nodo> listaCerrada;
        private ListaNodosOrdenadas listaAbierta;
        private Camino caminoMasCorto;

        public AEstrella(Mapa map, InterfazHeuristica heuristic) {
                this.map = map;
                this.heuristic = heuristic;

                listaCerrada = new ArrayList<Nodo>();
                listaAbierta = new ListaNodosOrdenadas();
        }

        public Camino calcularCaminoMasCorto(int startX, int startY, int goalX, int goalY) {

                map.setLocalizacionInicial(startX, startY);
                map.setLocalizacionDeLaMeta(goalX, goalY);

                if (map.getNodo(goalX, goalY).isObstacle()) {
                        return null;
                }

                map.getNodoInicial().setDistanceFromStart(0);
                listaCerrada.clear();
                listaAbierta.clear();
                listaAbierta.add(map.getNodoInicial());

                while(listaAbierta.size() != 0) {

                        Nodo actual = listaAbierta.getFirst();

                        if(actual.getX() == map.getLocalizacionFinalX() && actual.getY() == map.getLocalizacionFinalY()) {
                                return reconstruirCamino(actual);
                        }

                        listaAbierta.remove(actual);
                        listaCerrada.add(actual);

                        for(Nodo vecino : actual.getNeighborList()) {
                                boolean esMejorVecino;

                                if (listaCerrada.contains(vecino))
                                        continue;

                                if (!vecino.isObstacle()) {

                                        float distanciaDesdeElPrincipioAlVecino = (actual.getDistanceFromStart() + map.getDistanceBetween(actual, vecino));

                                       
                                        if(!listaAbierta.contains(vecino)) {
                                        	listaAbierta.add(vecino);
                                        	esMejorVecino = true;
                                                
                                        } else if(distanciaDesdeElPrincipioAlVecino < actual.getDistanceFromStart()) {
                                        	esMejorVecino = true;
                                        } else {
                                        	esMejorVecino = false;
                                        }
                                       
                                        if (esMejorVecino) {
                                        	vecino.setPreviousNode(actual);
                                        	vecino.setDistanceFromStart(distanciaDesdeElPrincipioAlVecino);
                                        	vecino.setHeuristicDistanceFromGoal(heuristic.calcularDistanciaAMeta(vecino.getX(), vecino.getY(), map.getLocalizacionFinalX(), map.getLocalizacionFinalY()));
                                        }
                                }

                        }

                }
                return null;
        }

        
        
        public void PintarCamino() {
                Nodo nodo;
                for(int x=0; x<map.getAnchuraMapaLogico(); x++) {

                        if (x==0) {
                                for (int i=0; i<=map.getAnchuraMapaLogico(); i++)
                                        System.out.print("-");
                                System.out.println();   
                        }
                        System.out.print("|");

                        for(int y=0; y<map.getAlturaMapaLogico(); y++) {
                                nodo = map.getNodo(x, y);
                                if (nodo.isObstacle()) {
                                        System.out.print("O");
                                } else if (nodo.isStart) {
                                        System.out.print("I");
                                } else if (nodo.isGoal) {
                                        System.out.print("F");
                                } else if (caminoMasCorto.contains(nodo.getX(), nodo.getY())) {
                                        System.out.print("*");
                                } else {
                                        System.out.print(" ");
                                }
                                if (y==map.getAlturaMapaLogico())
                                        System.out.print("_");
                        }

                        System.out.print("|");
                        System.out.println();
                }
                for (int i=0; i<=map.getAnchuraMapaLogico(); i++)
                        System.out.print("-");
        }

        private Camino reconstruirCamino(Nodo nodo) {
                Camino camino = new Camino();
                while(!(nodo.getPreviousNode() == null)) {
                	camino.prependWayPoint(nodo);
                    nodo = nodo.getPreviousNode();
                }
                this.caminoMasCorto = camino;
                return camino;
        }

        //clase anidada de la lista de nodos ordenada.
        private class ListaNodosOrdenadas {
                  //Lista de nodos.
                private ArrayList<Nodo> list = new ArrayList<Nodo>();

                public Nodo getFirst() {
                        return list.get(0);
                }

                public void clear() {
                        list.clear();
                }

                public void add(Nodo node) {
                        list.add(node);
                        Collections.sort(list);
                }

                public void remove(Nodo n) {
                        list.remove(n);
                }

                public int size() {
                        return list.size();
                }
                // devuelve si esta ese nodo en la lista.
                public boolean contains(Nodo n) {
                        return list.contains(n);
                }
        }
        public Mapa getMapa(){
        	return map;
        }
        public Camino getCaminoMasCorto(){
        	return caminoMasCorto;
        }
}
