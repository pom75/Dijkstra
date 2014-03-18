
public class Arete {
	public int c =0;
	public Sommet s1 = null;
	public Sommet s2 = null;
	public boolean vital=false;
	public boolean chemin=false;
	
	public Arete(int c,Sommet s1, Sommet s2){
		this.c=c;
		this.s1=s1;
		this.s2=s2;
	}
	
	public Sommet getS(int num){
		if(s1.num == num){
			return s2;
		}else 
			return s1;
	}
}
