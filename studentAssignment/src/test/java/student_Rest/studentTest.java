package student_Rest;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class studentTest {
	public static void main(String[] args) throws IOException, ParseException 
	{
		JSONParser jsonparser = new JSONParser();
		try {
			FileReader reader = new FileReader("StudentData.json");
			Object obj = jsonparser.parse(reader);
			JSONObject studentJson = (JSONObject)obj;
			String username = (String) studentJson.get("username");
			System.out.println("username = "+username);
			JSONArray sessionIdsArray =(JSONArray)studentJson.get("sessionid");
			System.out.println("Sessionids are :"+sessionIdsArray);
			JSONArray students = (JSONArray)studentJson.get("students");
			
				JSONObject  Secondstudentdetails = (JSONObject)students.get(1);
				JSONObject  firsttudentdetails = (JSONObject)students.get(0);
				JSONArray marksList = (JSONArray) Secondstudentdetails.get("marks");
				System.out.println("Second student marks :" +marksList);
				//JSONArray address = (JSONArray)students.get("address");
				JSONArray firstaddress =(JSONArray) firsttudentdetails.get("address");
				JSONArray secondAddr = (JSONArray)Secondstudentdetails.get("address");
				JSONObject secondAddress =  (JSONObject)firstaddress.get(1);
				System.out.println("  second state in first addess of stundent :"+secondAddress.get("state"));
				for(int i=0; i<secondAddr.size();i++ ) {
					JSONObject city = (JSONObject)secondAddr.get(i);
					System.out.println("  city is in second address of  :"+city.get("city"));
				}
				//to find contacts of all student
				for(int i =0; i< students.size();i++) 
				{
					JSONObject  stuObj = (JSONObject)students.get(i);
					JSONArray contact = (JSONArray) stuObj.get("contact");
					System.out.println("size :"+contact.size());
					for(int j =0; j< contact.size();j++) 
					{
						System.out.println("contact from contacts :" +contact.get(j));
					}
				}
				
		// first student address
				System.out.println("first address of student :" +firstaddress.get(0));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
