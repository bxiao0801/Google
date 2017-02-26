import java.util.*;
import java.io.*;
import java.net.*;

class Point{
	int x;
	int y;
	public Point(int x,int y){
		this.x=x;
		this.y=y;
	}

	public int HashCode(){
		return x*101+y*7;
	}

	public boolean equals(Point p1){
		return this.x==p1.x&&this.y==p1.y;
	}

	public String toString(){
		return x+","+y;
	}
}

public class Solution{
	public int area(List<Point> pts){
		HashMap<Integer,List<Point[]>> map=new HashMap<>();
		int min=Integer.MAX_VALUE;
		for(int i=1;i<pts.size();i++){
			for(int j=0;j<i;j++){
				int len=dist(pts.get(i),pts.get(j));
				if(!map.containsKey(len)){
					map.put(len,new ArrayList());
				}
				map.get(len).add(new Point[]{pts.get(i),pts.get(j)});
			}
		}

		System.out.println(map);
		//

		for(int i=1;i<pts.size();i++){
			for(int j=0;j<i;j++){
				Point p1=pts.get(i);
				Point p2=pts.get(j);
				int len=dist(p1,p2);

				if(map.containsKey(len)){
					for(Point[] p:map.get(len)){
						Point p3=p[0];
						Point p4=p[1];
						if(p1==p3&&p2==p4||p1==p4&&p2==p3){
							continue;
						}
						if(p3.x+p4.x==p1.x+p2.x&&p3.y+p4.y==p1.y+p2.y){
							System.out.println("hey");
							min=Math.min(min,dist(p1,p3)*dist(p1,p4));
						}
					}
				}				
			}
		}

		return min;
	}

	public int dist(Point p1,Point p2){
		return (p1.x-p2.x)*(p1.x-p2.x)+(p1.y-p2.y)*(p1.y-p2.y);
	}

	public static void main(String[] args){
		Solution s=new Solution();
		List<Point> l=Arrays.asList(new Point(0,1),new Point(0,2),new Point(1,1),new Point(1,2),new Point(2,1),new Point(2,2));
		System.out.println(s.area(l));
	}
}