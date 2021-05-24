package student_Rest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class StudentDetails {

	public static JSONObject studentJson;
	public static JSONArray studentsArray;
	public static JSONObject studentObj;
	public static JSONObject firstStuObj;
	public static JSONObject secondStuObj;
	public static JSONObject addressObj;
	public static JSONArray firsrAddressArray;
	public static JSONArray secondAddressArray;
	public static JSONObject firstaddressObj;
	public static JSONObject secondaddessObj;
	
	
	public static void main(String[] arg) throws IOException, ParseException 
	{
		JSONParser parser =new JSONParser();
		
		try {
			
			FileReader file =new FileReader("StudentData.json");
			Object obj = parser.parse(file);
			studentJson =(JSONObject)obj;
			//First student object
			studentsArray = (JSONArray) studentJson.get("students");
			 firstStuObj = (JSONObject)studentsArray.get(0);
			//Second student object
			 secondStuObj = (JSONObject)studentsArray.get(1);
			 //JSONArray addressArray = (JSONArray)studentJson.get("address");
			 firsrAddressArray = (JSONArray) firstStuObj.get("address");
			 secondAddressArray = (JSONArray) secondStuObj.get("address");
			 firstaddressObj=(JSONObject) firsrAddressArray.get(0);
			 secondaddessObj  = (JSONObject)secondAddressArray.get(1);
			 
			
			//1.To find username
			 
			String userName = findUserName(); 
			System.out.println("username  : "+userName);
			
			//2.print all sessionids
			
			JSONArray  sessionIdArray= allSessionIds();
			System.out.println("All session ids are : " + sessionIdArray);
			
			//3.To get last session id 
			
			 Long lastSessionId = lastValueOfSessionId(sessionIdArray); 
			 System.out.println("Last SessionID : "+lastSessionId);
			 
			 // 4.second student marks
			 List<String> ls =findAllMarksOfSecondStudent();
			 System.out.println("marks list of second student : " +ls);
			 
			 //5.Second state value of first student
			 String stateOfFistStu =findScndStateValueOfFrstStu();
			 System.out.println("Second state of  stu first address : " +stateOfFistStu);
			//6. SecondContact
			 List<String> secondContact = secondContact();
			 System.out.println("contacts from second student details : "+secondContact);
			 //7.second city list  of secondstudent
			 List<String> citiesList = secondAddressCities();
			 System.out.println("Second address cities list : "+citiesList);
			 
			 
			//8.to get All contacts
			 List<String> allContacts = contactsOfAllStu();
			 System.out.println("All contacts : "+allContacts);
			 
			 //9.To print first student address
			 List<String> firstStuAddress = addressOfFirstStu();
			 System.out.println(" first Address Of student : "+firstStuAddress);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	//Method to  return Username
	public static String findUserName() {
		//JSONObject uName = (JSONObject) studentJson.get("username");
		String username = (String)studentJson.get("username");
		return username;
	}
	//Method to return all sessionids
	public static JSONArray  allSessionIds() 
	{
		JSONArray sessionIdArray = (JSONArray) studentJson.get("sessionid");
		return sessionIdArray;
	}
	//Method to return last sessionid
	public static Long lastValueOfSessionId(JSONArray sessionidArray) {
		int size = sessionidArray.size();
		System.out.println("size :"+size);
		Long lastvalue = (Long) sessionidArray.get(size-1);
		return lastvalue;
		
	}
	// method to find secondstudentmarks
	public static List<String>findAllMarksOfSecondStudent() {
		JSONArray marksArray = (JSONArray) secondStuObj.get("marks");
		List<String> marksList = new ArrayList<>();
		marksList.addAll(marksArray);
		return marksList;
		
		
	}
	//Method to find second state value of first student address
	public static String findScndStateValueOfFrstStu() 
	{	
		JSONArray addressArray = (JSONArray)secondStuObj.get("address");
		JSONObject addObj = (JSONObject)addressArray.get(1);
		String stateobj = (String)addObj.get("state");
		return stateobj;
	}
	// To get contact from second address of student
	public static List<String> secondCntctOfSecondStu() 
	{
		JSONArray contactArray = (JSONArray) secondStuObj.get("contact");
		//System.out.println("contactarray : " +contactArray);
		List<String> contactList =  new ArrayList<>();
		for(int i=0; i<contactArray.size();i++) 
		{
			if(contactArray!=null) 
			{
				contactList.add((String) contactArray.get(i));
			}
		
		}
		return contactList;
	}
	//to get all cities list form second address
		public static List<String> secondAddressCities() 
		{
			JSONArray addressArray = (JSONArray)secondStuObj.get("address");
			//System.out.println("SIZE :"+addressArray);
			List<String> citiesList = new ArrayList<>();
			for(int i =0; i< addressArray.size();i++) 
			{
				JSONObject obj = (JSONObject) addressArray.get(i);
				if(addressArray!=null) {
					 String cityObj = (String)obj.get("city");
					citiesList.add(cityObj);
				}
			}
			return citiesList;
		}
			
		// method to get all student contacts
		public static List<String> contactsOfAllStu() 
		{
			List<String> allContactslist = new ArrayList<>();
			JSONArray FirstcontactArray = (JSONArray)  firstStuObj.get("contact");
			JSONArray SecondcontactArray = (JSONArray) secondStuObj.get("contact");
			allContactslist.addAll(FirstcontactArray);
			allContactslist.addAll(SecondcontactArray);
			return allContactslist;
			
		}
		// Method get first address of student
		public static List<String> addressOfFirstStu() 
		{
			List<String> addressList = new ArrayList<>();
			JSONArray address = (JSONArray) firstStuObj.get("address");
			addressList.addAll(address);
			return addressList;
		}
		// to find second student contact
		public static List<String> secondContact(){
			List<String> secondContactList = new ArrayList<>();
			JSONArray secondContact = (JSONArray) secondStuObj.get("contact");
			
			secondContactList.addAll(secondContact);
			return secondContactList;
		}
		

}
/*
 * username  : aa@m.com
All session ids are : [12,23,34,56]
size :4
Last SessionID : 56
marks list of second student : [40, 35, 22]
Second state of  stu first address : TX
contacts from second student details : [4534, 3456]
Second address cities list : [NewJersy, Dallas]
All contacts : [1234, 6789, 4534, 3456]
 first Address Of student : [{"city":"santaclara","state":"CA"}, {"city":"NewYork","state":"NY"}]

 */
	

