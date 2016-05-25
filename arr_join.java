package studying;

public class arr_join {

	public static void main(String[] args) {
		int[] num = {-9, 6, 0,100, -500, -59};
		  int [] num2 = {-10, 5, 0,-780};
		  int[] res = new int[num.length+num2.length];
		  
		  
		  for(int i = 0; i < num.length; i++){
		  res[i] = num[i];
		  }
		  
		  for(int q = 0; q <num2.length; q++){
		  res[q+num.length] = num2[q];}
		  
		  for (int w = 0; w<res.length; w++){
		   System.out.println(res[w]);
		  }

	}

}
