package hello;

public class WordUtil {

	public static String[]  permute(String word,int p){
		String[] per=new String[p];
		int l = word.length();
		String[] aux = permutation(word);
		int pos =0;
		if(p==1|l==1){
			per[0] = word;
			return per;
		}
		for(int i=0;i<aux.length;i++){
			String[] auxiliary = permute(aux[i].substring(1),factorial(l-1));
			for(int j=0;j<auxiliary.length;j++){
				per[pos]=aux[i].charAt(0)+auxiliary[j];
				pos++;
			}
		}
		return per; 
	}
		
	public static String[] permutation(String word){
		int n = word.length();
		String temporal="";
		String[] vector = new String[n];
		vector[0]=word;
		for(int i=1;i<n;i++){
			for(int j=0;j<n;j++){
				if(j==n-1)
						temporal = word.charAt(j)+temporal;
				else temporal += word.charAt(j);
			}
			word=temporal;
			vector[i]=temporal;
			temporal="";
		}
		return vector;
	}

	public static int factorial (int n){
		int resultado;
		if(n==1||n==0)
			return 1;
		resultado = factorial(n-1)*n;
		return resultado;
	}
	
}
