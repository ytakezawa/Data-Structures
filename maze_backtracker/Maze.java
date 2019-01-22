package maze_backtracker;

//yoshika takezawa
//i pledge my honor that i have abided by the stevens honor system

import java.util.ArrayList;
import java.util.Stack;

/**
 * Class that solves maze problems with backtracking.
 * @author Koffman and Wolfgang
 **/
public class Maze implements GridColors {

    /** The maze */
    private TwoDimGrid maze;

    public Maze(TwoDimGrid m) {
        maze = m;
    }

    /** Wrapper method. */
    public boolean findMazePath() {
        return findMazePath(0, 0); // (0, 0) is the start point.
    }

    /**
     * Attempts to find a path through point (x, y).
     * @pre Possible path cells are in BACKGROUND color;
     *      barrier cells are in ABNORMAL color.
     * @post If a path is found, all cells on it are set to the
     *       PATH color; all cells that were visited but are
     *       not on the path are in the TEMPORARY color.
     * @param x The x-coordinate of current point
     * @param y The y-coordinate of current point
     * @return If a path through (x, y) is found, true;
     *         otherwise, false
     */
    public boolean findMazePath(int x, int y) {
    	
    	if (x>= maze.getNRows() ||x<0 ||y<0|| y>= maze.getNCols()) {	//out of bounds?
    		return false;
    	}if (maze.getColor(x,y)!=(NON_BACKGROUND)) {					//path not red?
    		return false;
    	}if (x == maze.getNRows()-1 && y == maze.getNCols()-1) {		//last block?
    		maze.recolor(x,y, PATH);
    		return true;
    	}if (maze.getColor(x, y) == NON_BACKGROUND) {					//path red?
    		maze.recolor(x,y, TEMPORARY);
    		if (this.findMazePath(x,y-1) || this.findMazePath(x,y+1)|| this.findMazePath(x-1 ,y) ||this.findMazePath(x+1, y)) {
    			maze.recolor(x,y, PATH);
    			return true;
    		}
    	}
    	return findMazePath(x,y-1) || findMazePath(x,y+1)|| findMazePath(x-1 ,y) || findMazePath(x+1, y) ;
    }
    
    /**
     * sees if current block is possible, 
     * if last block, takes the stack and adds to arraylist
     * if trying to find the way- add to stack, seek possible routes
     * @param x current x value
     * @param y current y value
     * @param result arraylist of arraylists of possible paths
     * @param trace stack for tracing the steps
     */
    public void findMazePathStackBased(int x, int y, ArrayList<ArrayList<PairInt>> result, Stack<PairInt> trace) {
    	
    	if (x>= maze.getNRows() ||x<0 ||y<0|| y>= maze.getNCols()) {	//out of bounds
    		return;
    	}if (maze.getColor(x,y)==BACKGROUND || maze.getColor(x, y) == TEMPORARY) {	//user is in the maze and 
    		return;
    	}if (x == maze.getNRows()-1 && y == maze.getNCols()-1) {		//last block
    		PairInt current = new PairInt(x,y);
    		trace.push(current);
    		ArrayList<PairInt> pathArray = new ArrayList<PairInt>();
    		pathArray.addAll(trace);
    		result.add(pathArray);
    		trace.pop();
    		maze.recolor(x, y, NON_BACKGROUND);
    		return ;
    	}if (maze.getColor(x, y) == NON_BACKGROUND) {	//path red, testing
    		PairInt current = new PairInt(x,y);
    		trace.push(current);
    		maze.recolor(x, y, TEMPORARY);
    		findMazePathStackBased(x,y-1, result, trace);
        	findMazePathStackBased(x,y+1, result, trace);
        	findMazePathStackBased(x-1 ,y, result, trace);
        	findMazePathStackBased(x+1, y, result, trace);
        	maze.recolor(x, y,NON_BACKGROUND);
        	trace.pop();
        	return;
    	}
    }
    
    public ArrayList<ArrayList<PairInt>> findAllMazePaths(int x, int y){
    	ArrayList<ArrayList<PairInt>> result = new ArrayList<>();
    	Stack<PairInt> trace = new Stack<>();
    	findMazePathStackBased(0,0,result,trace);
    	return result;
    }

  //METHOD FOR PROBLEM 3

    public ArrayList<PairInt> findMazePathMin(int x, int y){
    	ArrayList<ArrayList<PairInt>> result = findAllMazePaths(0,0);
    	int minTemp = result.get(0).size();
    	int index = 0;
    	for (int i = 0; i<result.size();i++) {
    		if (result.get(i).size()<minTemp) {
    			minTemp = result.get(i).size();
    			index = i;
    		}
    	}
    	return result.get(index);
    }
  
  
  
    /*<exercise chapter="5" section="6" type="programming" number="2">*/
    public void resetTemp() {
        maze.recolor(TEMPORARY, BACKGROUND);
    }
    /*</exercise>*/

    /*<exercise chapter="5" section="6" type="programming" number="3">*/
    public void restore() {
        resetTemp();
        maze.recolor(PATH, BACKGROUND);
        maze.recolor(NON_BACKGROUND, BACKGROUND);
    }
    /*</exercise>*/
}
/*</listing>*/
