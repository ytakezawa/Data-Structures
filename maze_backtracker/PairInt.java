package maze_backtracker;
//yoshika takezawa
//i pledge my honor that i have abided by the stevens honor system

public class PairInt {
	private int x;
	private int y;
	
	public PairInt(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public boolean equals(Object p) {
		if (p == null) {
			return false;
		}
		if (!(p instanceof PairInt)) {
			return false;
		}
		return (this.x == ((PairInt)p).x && this.y ==((PairInt)p).y);
	}
	
	public String toString() {
		return "(" + x +"," + y+ ")";
	}
	
	public PairInt copy() {
		PairInt clone = new PairInt(this.x, this.y);
		return clone;
	}
	
}
