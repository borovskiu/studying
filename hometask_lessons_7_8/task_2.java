package hometask_borovsky_7_8_lessons_task_2;

//2) Використання класів Random , Date у циклі та з колекціями 
//(згенерувати випадкову колекцію стрічок, кожна з яких є стрічкою, що містить від 6 до 15 символів).
//Продемонстуйте розпарсання дати, додавання/віднімання дати(дня, місяця, року) від поточної дати.

import java.util.*;
import java.math.*;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class task_2 {

	public static void main(String[] args) {
		task_2.dictionary_generate();
		task_2.dateParse();
		}
			
		public static void dictionary_generate()
		{
			Random rand= new Random();
			List <String> list = new ArrayList();
			for (int y=0; y<10; y++)
			{
				int hm = (rand.nextInt(9)+6);
				//65-90 ASCII
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
			String date_1 = " 01.06.2016";
			String date_2 = " 10.06.2016";
			SimpleDateFormat strdatef = new SimpleDateFormat("dd.MM.yyyy");
			Date date1 = null;
			Date date2 = null;
			try {
			    date1 = strdatef.parse(date_1);
			    date2 = strdatef.parse(date_2);
			} catch (Exception ex) {
			    ex.printStackTrace();
			}
			
			long period;
			
			if (date1.getTime()>date2.getTime()){
				period = date1.getTime() - date2.getTime();
					
			}
			else
			{
				period = date2.getTime()-date1.getTime();
			}
		
			int days = (int)(period / 86400000);
			System.out.println('\n'+"Разница в днях: " + days);
			
		}

	}