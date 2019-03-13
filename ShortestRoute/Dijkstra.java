import java.util.ArrayList;
import java.util.List;

public class Dijkstra {
	int WEIGHT =10;
	private MyNode map[][] = new MyNode[WEIGHT][WEIGHT];
	Dijkstra(){
	}
	void setMap(MyNode list[][]) {
		int length = list.length*list[0].length;
		for(int i=0;i<length;i++) {
			MyNode node = list[i/WEIGHT][i%WEIGHT];
//			System.out.println("i/10:"+i/10+" i%10:"+i%10);
			map[i/WEIGHT][i%WEIGHT] = new MyNode(node.getX(),node.getY(),node.getObstacle());
			map[i/WEIGHT][i%WEIGHT].setState(node.getState());
		}
	}
	//start(0,0) goal(9,9)
	void calc() {
		boolean bool = true;
		List<MyNode> openList = new ArrayList<>();
		map[0][0].setState(MyNode.State.OPEN);
		map[0][0].setCost(0);
		while(bool) {
			bool = false;
			openList.clear();
			for(int i=0;i<WEIGHT;i++) {
				for(int k=0;k<WEIGHT;k++) {
					if(MyNode.State.NONE==map[i][k].getState()) {
						bool = true;
						//System.out.println("OPEN:("+String.valueOf(i)+","+String.valueOf(k)+")");
					}else if(MyNode.State.OPEN==map[i][k].getState()) {
						openList.add(map[i][k]);
					}
				}
			}
			for(MyNode node:openList) {
				try {
					MyNode n = map[node.getX()-1][node.getY()];
					if(n.getState()==MyNode.State.NONE&&node.getCost()+1<n.getCost()){
						n.setCost(node.getCost()+1);
						n.setState(MyNode.State.OPEN);
						n.setParent(node);
					}
				}catch(ArrayIndexOutOfBoundsException e) {
				}catch(NullPointerException e) {
				}
				try {
					MyNode n = map[node.getX()+1][node.getY()];
					if(n.getState()==MyNode.State.NONE&&node.getCost()+1<n.getCost()){
						n.setCost(node.getCost()+1);
						n.setState(MyNode.State.OPEN);
						n.setParent(node);
					}
				}catch(ArrayIndexOutOfBoundsException e) {
				}catch(NullPointerException e) {
				}
				try {
					MyNode n = map[node.getX()][node.getY()-1];
					if(n.getState()==MyNode.State.NONE&&node.getCost()+1<n.getCost()){
						n.setCost(node.getCost()+1);
						n.setState(MyNode.State.OPEN);
						n.setParent(node);
					}
				}catch(ArrayIndexOutOfBoundsException e) {
				}catch(NullPointerException e) {
				}
				try {
					MyNode n = map[node.getX()][node.getY()+1];
					if(n.getState()==MyNode.State.NONE&&node.getCost()+1<n.getCost()){
						n.setCost(node.getCost()+1);
						n.setState(MyNode.State.OPEN);
						n.setParent(node);
					}
				}catch(ArrayIndexOutOfBoundsException e) {
				}catch(NullPointerException e) {
				}
				node.setState(MyNode.State.CLOSE);
			}
			//safty-
//			bool = false;
//			System.out.println("CLOSE");
			//-safty
		}
	}
	void disp() {
		List<Point> pointList = new ArrayList<>();
		map[9][9].getRoute(pointList);
		String s1;
		String s2;
		String s3;
		String s4;
		String s5;
		String s6;
		for(int i=0;i<WEIGHT;i++) {
			s1="";
			s2="";
			s3="";
			s4="";
			s5="";
			s6="";
			for(int k=0;k<WEIGHT;k++) {
				s1+="x:"+String.valueOf(map[k][i].getX())+" y:"+String.valueOf(map[k][i].getY())+"\t\t";
				s2+=map[k][i].getObstacle()+"\t\t";
				s3+="cost:"+map[k][i].getCost()+"\t\t";
				s4+="sta:"+map[k][i].getState()+"\t";
				s5+="obs:"+map[k][i].getObstacle()+"\t";
				String s7="◇◇◇◇◇◇◇\t";
				for(Point p:pointList) {
					if(Integer.valueOf(k).equals(p.getX())&&Integer.valueOf(i).equals(p.getY())) {
						s7="◆◆◆◆◆◆◆\t";
					}
				}
				s6+=s7;
			}
			System.out.println(s1);
			System.out.println(s3);
			System.out.println(s4);
			System.out.println(s6);
			System.out.println(s2);
			System.out.println(s5);
			System.out.println("");
		}

		int j = 0;
		for(Point p:pointList) {
			System.out.println(j+"\tx:"+p.getX()+" y:"+p.getY());
			j++;
		}
	}
}
