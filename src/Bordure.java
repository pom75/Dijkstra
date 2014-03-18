
public abstract class Bordure {
	abstract void initialiser(int n, int C);
	abstract void ajouter(Sommet s);
	abstract void supprimer(Sommet s);
	abstract boolean estVide();
	abstract Sommet recupMin();
}
