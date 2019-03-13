public class Main {
	public final static int WEIGHT = 10;
	/*(0,0),(1,0).........(10,0)
	 * ........................
	 * ........................
	 * ........................
	 * (0,10),(1,10).....(10,10)
	 */
	private static boolean isObstacleExist = true;
	//20個
	private static Point obstacles[] = {new Point(0,2),new Point(2,0),new Point(4,1),new Point(1,4),new Point(4,2),new Point(2,4),
			new Point(5,5),new Point(3,0),new Point(3,1),new Point(3,2),new Point(1,7),new Point(7,2),new Point(2,7),
			new Point(7,4),new Point(4,7),new Point(7,8),new Point(8,7),new Point(8,6),new Point(6,8),new Point(4,4),};
//	private static Point obstacles[] = {new Point(0,2),new Point(2,0),new Point(2,2),new Point(4,1),new Point(1,4),new Point(4,2),new Point(2,4)};
//	private static Point obstacles[] = {new Point(0,2),new Point(2,0)};
	public static void main(String[] args) {
		MyNode map[][] = new MyNode[WEIGHT][WEIGHT];
		for(int i=0;i<WEIGHT;i++) {
			for(int k=0;k<WEIGHT;k++) {
				map[i][k]=new MyNode(i,k,false);
			}
		}
		if(isObstacleExist) {
			//障害物があったときのやつ
			for(int i=0;i<20;i++) {
				map[obstacles[i].getX()][obstacles[i].getY()].setObstacle(true);
				map[obstacles[i].getX()][obstacles[i].getY()].setState(MyNode.State.OBSTA);
			}
		}
		String s1;
		String s2;
		String s3;
		String s4;
		String s5;
		for(int i=0;i<WEIGHT;i++) {
			s1="";
			s2="";
			s4="";
			s5="";
			for(int k=0;k<WEIGHT;k++) {
				s1+="x:"+String.valueOf(map[k][i].getX())+" y:"+String.valueOf(map[k][i].getY())+"\t\t";
				s2+=map[k][i].getObstacle()+"\t\t";
				s4+="sta:"+map[k][i].getState()+"\t";
				s5+="obs:"+map[k][i].getObstacle()+"\t";
			}
			System.out.println(s1);
			System.out.println(s2);
			System.out.println(s4);
			System.out.println(s5);
			System.out.println("");
		}
		//dijkstra法での解
		Dijkstra d= new Dijkstra();
		d.setMap(map);
		d.calc();
		d.disp();

		for(int i=0;i<WEIGHT;i++) {
			s1="";
			s2="";
			s3="";
			s4="";
			for(int k=0;k<WEIGHT;k++) {
				s1+="x:"+String.valueOf(map[k][i].getX())+" y:"+String.valueOf(map[k][i].getY())+"\t\t";
				s2+=map[k][i].getObstacle()+"\t\t";
				s3+="c:"+map[k][i].getCost()+"\t\t";
				s4+="s:"+map[k][i].getState()+"\t\t";
			}
			System.out.println(s1);
			System.out.println(s3);
			System.out.println(s4);
			System.out.println(s2);
			System.out.println("");
		}
		//aStarでの解
	}

}

