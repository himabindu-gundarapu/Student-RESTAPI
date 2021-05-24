package jsonParserWithPOJO;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import student_Rest.studentTest;

public class JsonReadWithObjectMapper {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		//Map<String,Object> map = new HashMap<>();
		File file =new File("StudentData.json");
		Root rootobj = mapper.readValue(file,Root.class);
		System.out.println("username :" +rootobj.getUsername());
		System.out.println("password :" + rootobj.getPassword());
		System.out.println("SessionId :"+ rootobj.getSessionid());
		List<Integer> sessionIdList= rootobj.getSessionid();
		System.out.println("Last session id : "+sessionIdList.get(sessionIdList.size()-1));
		List<Student> student = rootobj.getStudents();
		List<Integer> marksList = student.get(1).getMarks();
		System.out.println("List of student second marks : "+marksList);
		//getting first student address
		List<Address> Firstaddress =  student.get(0).getAddress();
		//second student address
		List<Address> secondAddress = student.get(1).getAddress();
		//Second state value from second address
		System.out.println("Second state from second address :" +secondAddress.get(0).getState());
		//second contact value from second address
		System.out.println("Second contact from second address : " +student.get(1).getContact().get(1));
		
		// to get all cities from 2nd addresses
		List<String> cities = new ArrayList<>();
		cities.add(secondAddress.get(0).getCity());
		cities.add(secondAddress.get(1).getCity());
		System.out.println("All cities from second address : "+cities);
		
		//Find contacts of all student
		List<String> allContacts = new ArrayList<>();
		
		for(int i=0; i< 2; i++) {
			List<String> contacts = student.get(i).getContact();
			for (int j=0; j<contacts.size(); ++j) {
				allContacts.add(contacts.get(j));
			}
		}
		System.out.println("all contacts : "+allContacts);
		
	// find address of first student
		List<Address> firstStuAddress = student.get(0).getAddress();
		List<String> frstAddress = new ArrayList<>();
		for(Address s :firstStuAddress) {
			frstAddress.add(s.getCity());
			frstAddress.add(s.getState());
			}
			System.out.println("First student city " +frstAddress);
			
		}
	}
/*username :aa@m.com
password :12xyz
SessionId :[12, 23, 34, 56]
Last session id : 56
List of student second marks : [40, 35, 22]
Second state from second address :Nj
Second contact from second address : 3456
All cities from second address : [NewJersy, Dallas]
all contacts : [1234, 6789, 4534, 3456]
First student city [santaclara, CA, NewYork, NY]

*/ 
