package ads.a5;


public class BubbleSort extends SortingAlgorithmListe 
{

	

	
	
	@Override
	public Liste sort(Liste l) {
		return l;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Liste g, h;
		g=new Liste(3, new Liste(8, new Liste(2, new Liste(12, new Liste(13, null)))));
		printListe(g);
		BubbleSort sw =new BubbleSort();
		h=sw.sort(g);
		printListe(h);
	}
}
