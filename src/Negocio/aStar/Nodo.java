package Negocio.aStar;

import java.util.ArrayList;

public class Nodo implements Comparable<Nodo> {
        /* Nodes that this is connected to */
        Mapa map;
        Nodo north;
        Nodo northEast;
        Nodo east;
        Nodo southEast;
        Nodo south;
        Nodo southWest;
        Nodo west;
        Nodo northWest;
        ArrayList<Nodo> neighborList;
        boolean visited;
        float distanceFromStart;
        float heuristicDistanceFromGoal;
        Nodo previousNode;
        int x;
        int y;
        private boolean isObstacle;
        boolean isStart;
        boolean isGoal;
        
        public Nodo(int x, int y) {
                neighborList = new ArrayList<Nodo>();
                this.x = x;
                this.y = y;
                this.visited = false;
                this.distanceFromStart = Integer.MAX_VALUE;
                this.setObstacle(false);
                this.isStart = false;
                this.isGoal = false;
        }
        
        public Nodo (int x, int y, boolean visited, int distanceFromStart, boolean isObstical, boolean isStart, boolean isGoal) {
                neighborList = new ArrayList<Nodo>();
                this.x = x;
                this.y = y;
                this.visited = visited;
                this.distanceFromStart = distanceFromStart;
                this.setObstacle(isObstical);
                this.isStart = isStart;
                this.isGoal = isGoal;
        }
        
        public Nodo getNorth() {
                return north;
        }

        public void setNorth(Nodo north) {
                //replace the old Node with the new one in the neighborList
                if (neighborList.contains(this.north))
                        neighborList.remove(this.north);
                neighborList.add(north);
                
                //set the new Node
                this.north = north;
        }

        public Nodo getNorthEast() {
                return northEast;
        }

        public void setNorthEast(Nodo northEast) {
                //replace the old Node with the new one in the neighborList
                if (neighborList.contains(this.northEast))
                        neighborList.remove(this.northEast);
                neighborList.add(northEast);
                
                //set the new Node
                this.northEast = northEast;
        }

        public Nodo getEast() {
                return east;
        }

        public void setEast(Nodo east) {
                //replace the old Node with the new one in the neighborList
                if (neighborList.contains(this.east))
                        neighborList.remove(this.east);
                neighborList.add(east);
                
                //set the new Node
                this.east = east;
        }

        public Nodo getSouthEast() {
                return southEast;
        }

        public void setSouthEast(Nodo southEast) {
                //replace the old Node with the new one in the neighborList
                if (neighborList.contains(this.southEast))
                        neighborList.remove(this.southEast);
                neighborList.add(southEast);
                
                //set the new Node
                this.southEast = southEast;
        }

        public Nodo getSouth() {
                return south;
        }

        public void setSouth(Nodo south) {
                //replace the old Node with the new one in the neighborList
                if (neighborList.contains(this.south))
                        neighborList.remove(this.south);
                neighborList.add(south);
                
                //set the new Node
                this.south = south;
        }

        public Nodo getSouthWest() {
                return southWest;
        }

        public void setSouthWest(Nodo southWest) {
                //replace the old Node with the new one in the neighborList
                if (neighborList.contains(this.southWest))
                        neighborList.remove(this.southWest);
                neighborList.add(southWest);
                
                //set the new Node
                this.southWest = southWest;
        }

        public Nodo getWest() {
                return west;
        }

        public void setWest(Nodo west) {
                //replace the old Node with the new one in the neighborList
                if (neighborList.contains(this.west))
                        neighborList.remove(this.west);
                neighborList.add(west);
                
                //set the new Node
                this.west = west;
        }

        public Nodo getNorthWest() {
                return northWest;
        }

        public void setNorthWest(Nodo northWest) {
                //replace the old Node with the new one in the neighborList
                if (neighborList.contains(this.northWest))
                        neighborList.remove(this.northWest);
                neighborList.add(northWest);
                
                //set the new Node
                this.northWest = northWest;
        }
        
        public ArrayList<Nodo> getNeighborList() {
                return neighborList;
        }

        public boolean isVisited() {
                return visited;
        }

        public void setVisited(boolean visited) {
                this.visited = visited;
        }

        public float getDistanceFromStart() {
                return distanceFromStart;
        }

        public void setDistanceFromStart(float f) {
                this.distanceFromStart = f;
        }

        public Nodo getPreviousNode() {
                return previousNode;
        }

        public void setPreviousNode(Nodo previousNode) {
                this.previousNode = previousNode;
        }
        
        public float getHeuristicDistanceFromGoal() {
                return heuristicDistanceFromGoal;
        }

        public void setHeuristicDistanceFromGoal(float heuristicDistanceFromGoal) {
                this.heuristicDistanceFromGoal = heuristicDistanceFromGoal;
        }

        public int getX() {
                return x;
        }

        public void setX(int x) {
                this.x = x;
        }

        public int getY() {
                return y;
        }

        public void setY(int y) {
                this.y = y;
        }
        
        public boolean isObstical() {
                return isObstacle();
        }

        public void setObstical(boolean isObstical) {
                this.setObstacle(isObstical);
        }

        public boolean isStart() {
                return isStart;
        }

        public void setStart(boolean isStart) {
                this.isStart = isStart;
        }

        public boolean isGoal() {
                return isGoal;
        }

        public void setGoal(boolean isGoal) {
                this.isGoal = isGoal;
        }

        public boolean equals(Nodo node) {
                return (node.x == x) && (node.y == y);
        }

        public int compareTo(Nodo otherNode) {
                float thisTotalDistanceFromGoal = heuristicDistanceFromGoal + distanceFromStart;
                float otherTotalDistanceFromGoal = otherNode.getHeuristicDistanceFromGoal() + otherNode.getDistanceFromStart();
                
                if (thisTotalDistanceFromGoal < otherTotalDistanceFromGoal) {
                        return -1;
                } else if (thisTotalDistanceFromGoal > otherTotalDistanceFromGoal) {
                        return 1;
                } else {
                        return 0;
                }
        }

		public boolean isObstacle() {
			return isObstacle;
		}

		public void setObstacle(boolean isObstacle) {
			this.isObstacle = isObstacle;
		}
}

