package Homtsk_7_8__2;
//2) Використання класів Random , Date у циклі та з колекціями 
//(згенерувати випадкову колекцію стрічок, кожна з яких є стрічкою, що містить від 6 до 15 символів).
//Продемонстуйте розпарсання дати, додавання/віднімання дати(дня, місяця, року) від поточної дати.

import java.util.*;
import java.math.*;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class task2 {
	
	public static void main(String[] args) {
	task2.dictionary_generate();
	task2.dateParse();
	}
		
	public static void dictionary_generate()
	{
		Random rand= new Random();
		List <String> list = new ArrayList();
		for (int y=0; y<10; y++)
		{
			int hm = (rand.nextInt(9)+6);
			//65-90
			String str="";
				for (int i = 0; i <hm; i++)
				{
					str+=((char)(rand.nextInt(25)+65));
					
				}
				list.add(str);
		}
		System.out.print(list);
	}
	
	public static void dateParse()
	{
//		
	}

}
