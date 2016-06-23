package hometask_borovsky_7_8_lessons_task_4;

import java.io.*;
import java.util.*;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


public class Task_4_parse_json {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		InputStream input = new FileInputStream("src/office_staff.json");
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
		TypeFactory typeFactory = TypeFactory.defaultInstance();
		
		
		List<Office_staff> office = objectMapper.readValue(input,typeFactory.constructCollectionType(ArrayList.class, Office_staff.class));
		
		for(int i = 0; i<office.size(); i++)
		{
			System.out.println(office.get(i).getName());
			System.out.println(office.get(i).getAge());
			System.out.println(office.get(i).getProfession());
			System.out.println("--------------");
						
		}		
	}
}




@JsonIgnoreProperties(ignoreUnknown = true)
 class Office_staff {

	private int id;
	private String name;
	private int age;
	private String profession;
	

	@JsonCreator
	public Office_staff(@JsonProperty("id") int id, @JsonProperty("name") String name, 
		@JsonProperty("age") int age, @JsonProperty("profession") String profession)

		{
		this.id = id;
		this.name = name;
		this.age = age;
		this.profession = profession;
		}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

}
