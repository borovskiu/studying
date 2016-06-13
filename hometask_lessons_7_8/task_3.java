package hometask_borovsky_7_8_lessons_task_3;

//Напишіть метод, який зчитує дані з файлу у Map, 
//ключем якої є номер рядку файлу, а value - це текст у рядку файлу. 
//Запишіть у інший файл тільки ті значення Map , ключі яких є степенем 2.
//Використайте перехоплення виключення ситуацій.

import java.util.*;
import java.io.*;

public class task_3 {

	public static void main(String[] args) throws IOException {
		
		try{
		StringBuilder sb = new StringBuilder();
  		   BufferedReader in = new BufferedReader(new FileReader("D:\\base.txt"));
	        Map num = new HashMap();
	        try {
	            String s;
	                        
	           int y=0;
	            while ((s = in.readLine()) != null) {
	           sb.append(s);
	           sb.append("/n");
	           String word = s;
	        	   num.put(y, word);
	        	   y++;
	           }
	           System.out.println(num);
	            	
	        } 
	        catch(IOException ex)
	        {
	        	System.out.println(ex.getMessage());
	        }
	        
	        finally {
	            
	            in.close();
	        }
		        
	        
	        try(FileWriter writer = new FileWriter("D:\\base_new.doc"))
	        {
	        	
	            for (int u = 0; u< num.size();u++ ){
	        	
	            	if((u > 0) & ((u & (u - 1)) == 0)){
	            	String text =((num.get(u)).toString()+'\n') ;
	            
	            	
	           writer.write(text);
	           
	          System.out.print(text);
	            	}
	            	else{continue;}
	            }
	        }
		
	        catch(IOException ex){
	             
	            System.out.println(ex.getMessage());
	        }
	        finally{
	        	in.close();
	        }  
		}
		catch(IOException ex){
			System.out.println(ex.getMessage());
		}
		

	}

}
