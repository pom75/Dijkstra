import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;



public class Graphe {
	public Sommet TabSommet [];
	public int nbSommet=0;
	public int nbArete=0;
	public String nom;
	public int s;
	public int t;
	public int C = 0;
	
	
	
	public Graphe (String nom) throws IOException{
		this.nom =nom;	
	}
	
	public void suppA(Arete a){
		for(int i=0;i<TabSommet[a.s2.num].Successeur.size();i++){
			if(TabSommet[a.s2.num].Successeur.get(i).getS(a.s2.num).num == a.s1.num ){
				TabSommet[a.s2.num].Successeur.remove(i);
			}
		}
		for(int i=0;i<TabSommet[a.s1.num].Successeur.size();i++){
			if(TabSommet[a.s1.num].Successeur.get(i).getS(a.s1.num).num == a.s2.num ){
				TabSommet[a.s1.num].Successeur.remove(i);
			}
		}

	}

	public void addA(Arete a){
		TabSommet[a.s1.num].Successeur.add(a);
		TabSommet[a.s2.num].Successeur.add(a);
	}


	public void recupElem(String phrase,int i){
		String X="";
		String Y="";
		String Z="";


		if (i == 0){

			for(int t = 0; t<phrase.length() ;t++){	
				if(phrase.charAt(t)>=48 && phrase.charAt(t)<=57){

					for(int p= t; p<phrase.length() ;p++){	
						if(phrase.charAt(p)>=48 && phrase.charAt(p)<=57){
							X+=""+phrase.charAt(p);
						}
						else{

							for(int k= p+1; k<phrase.length() ;k++){

								if(phrase.charAt(k)>=48 && phrase.charAt(k)<=57){
									Y+=""+phrase.charAt(k);
								}
							}
							nbSommet = Integer.parseInt(X);
							nbArete = Integer.parseInt(Y);
							return;


						}
					}
				}


			}
		}else if(i == 1){

			TabSommet = new Sommet[nbSommet];

			for(int t = 0; t<phrase.length() ;t++){	
				if(phrase.charAt(t)>=48 && phrase.charAt(t)<=57){

					for(int p= t; p<phrase.length() ;p++){	
						if(phrase.charAt(p)>=48 && phrase.charAt(p)<=57){
							X+=""+phrase.charAt(p);

						}
						else{
							for(int v = p+1; v<phrase.length() ;v++){	
								if(phrase.charAt(v)>=48 && phrase.charAt(v)<=57){

									Y+=""+phrase.charAt(v);
								}
							}

							s = Integer.parseInt(X);
							this.t = Integer.parseInt(Y);
							return;

						}
					}
				}
			}

		}else if(i >=2 && i<2+nbSommet){

			for(int t = 0; t<phrase.length() ;t++){	
				if(phrase.charAt(t)>=48 && phrase.charAt(t)<=57){

					for(int p= t; p<phrase.length() ;p++){	
						if(phrase.charAt(p)>=48 && phrase.charAt(p)<=57){
							X+=""+phrase.charAt(p);
						}
						else{
							for(int v = p; v<phrase.length() ;v++){	
								if(phrase.charAt(v)>=48 && phrase.charAt(v)<=57){
									for(int k= v; k<phrase.length() ;k++){

										if(phrase.charAt(k)>=48 && phrase.charAt(k)<=57){
											Y+=""+phrase.charAt(k);
										}
										else{


											for(int r= v+1; r<phrase.length() ;r++){
												if(phrase.charAt(r)>=48 && phrase.charAt(r)<=57){
													Z+=""+phrase.charAt(r);
												}

											}
											TabSommet[Integer.parseInt(X)]=new Sommet(Integer.parseInt(X),Double.parseDouble(Y),Double.parseDouble(Z));
											return;



										}
									}


								}
							}
						}
					}
				}
			}
		}else {
			for(int t = 0; t<phrase.length() ;t++){	
				if(phrase.charAt(t)>=48 && phrase.charAt(t)<=57){

					for(int p= t; p<phrase.length() ;p++){	
						if(phrase.charAt(p)>=48 && phrase.charAt(p)<=57){
							X+=""+phrase.charAt(p);
						}
						else{
							for(int v = p; v<phrase.length() ;v++){	
								if(phrase.charAt(v)>=48 && phrase.charAt(v)<=57){
									for(int k= v; k<phrase.length() ;k++){

										if(phrase.charAt(k)>=48 && phrase.charAt(k)<=57){
											Y+=""+phrase.charAt(k);
										}
										else{

											for(int r= v+1; r<phrase.length() ;r++){
												if(phrase.charAt(r)>=48 && phrase.charAt(r)<=57){
													Z+=""+phrase.charAt(r);
												}
											}
											if(C < Integer.parseInt(Z)){
												C = Integer.parseInt(Z);
											}
											TabSommet[Integer.parseInt(X)].addArete(new Arete(Integer.parseInt(Z),TabSommet[Integer.parseInt(Y)],TabSommet[Integer.parseInt(X)]));
											TabSommet[Integer.parseInt(Y)].addArete(new Arete(Integer.parseInt(Z),TabSommet[Integer.parseInt(Y)],TabSommet[Integer.parseInt(X)]));
											return;


										}
									}
								}


							}
						}
					}
				}
			}

		}



	}
	
	public void lireFichier(String nom) throws IOException{
		String nomDuFichier = nom;
		int i = 0;
		
		BufferedReader reader = null;
		try{
			reader = new BufferedReader( new FileReader(nomDuFichier));
		}catch(IOException e){
			System.out.println(e);
		}

		String ligne = reader.readLine();
		while (ligne!=null)
		{
			recupElem(ligne,i);
			ligne = reader.readLine();
			i++;
		}

		reader.close();
	}
	
	public void ecrirFichier(String nom,Graphe g) throws IOException{
		
		PrintWriter ecrir = new PrintWriter(new FileWriter(nom));
		String text="";
		for(int i= 0;i<g.TabSommet.length;i++){
			text+=g.TabSommet[i].x+" "+g.TabSommet[i].y+" 2.5 0 360 arc \n";
			text+="fill\n";
			text+="stroke\n";
		}
		for(int i= 0;i<g.TabSommet.length;i++){
			for(int j = 0;j<g.TabSommet[i].Successeur.size();j++){
				
				if(g.TabSommet[i].Successeur.get(j).vital){
					text+="1 0 0 setrgbcolor \n";
					System.out.println(g.TabSommet[i].Successeur.get(j).s1.num+" "+g.TabSommet[i].Successeur.get(j).s2.num);
				}else if(g.TabSommet[i].Successeur.get(j).chemin){
					text+="0 1 0 setrgbcolor \n";
				}
				
				text+=g.TabSommet[i].x+" "+g.TabSommet[i].y+" moveto \n";
				text+=g.TabSommet[i].Successeur.get(j).getS(i).x+" "+g.TabSommet[i].Successeur.get(j).getS(i).y+"lineto \n";
				text+="stroke \n";
			}
			
		}

		
		
		ecrir.print(text);
		ecrir.flush();
		ecrir.close();
	}

	
	
	
}
