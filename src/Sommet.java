import java.util.LinkedList;
import java.util.List;


public class Sommet {
	public int num=0;
	public double x;
	public double y;
	public List<Arete> Successeur  = new LinkedList<Arete>();
	public int distance = 0;
	
	public Sommet(int num,double x,double y){
		this.num=num;
		this.x=x;
		this.y=y;
	}
	
	public void addArete(Arete a){
		Successeur.add(a);
	}

	public int compareTo(Sommet s) {
		if(this.distance > s.distance)
			return -1;
		else if(this.distance > s.distance){
			return 1;
		}
		return 0;
	}
 
}
