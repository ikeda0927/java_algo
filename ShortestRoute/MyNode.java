import java.util.List;

public class MyNode{
	private int x;
	private int y;
	private boolean isObstacle;
	
	private int cost = 99;//dijkstra
	private int actualCost = 1000;//aStar
	private int estimatedCost = 1000;//aStar
	private MyNode parent = null;
	private State state = State.NONE;
	MyNode(int x,int y,boolean isObstacle){
		this.x=x;
		this.y=y;
		this.isObstacle=isObstacle;
	}
	void setObstacle(boolean bool) {
		isObstacle = bool;
	}
	boolean getObstacle() {
		return isObstacle;
	}
	public int getX() {
		return x;
	}
	int getY() {
		return y;
	}
	State getState() {
		return state;
	}
	void setCost(int c) {
		cost = c;
	}
	int getCost() {
		return cost;
	}
	void setState(State s) {
		state = s;
	}
	void setParent(MyNode parent) {
		this.parent = parent;
	}
	void getRoute(List<Point> list) {
		if(parent!=null) {
			parent.getRoute(list);
			list.add(new Point(parent.getX(),parent.getY()));
		}else {
			return;
		}
	}
	static protected enum State{
		OPEN,
		CLOSE,
		NONE,
		OBSTA
	}
}