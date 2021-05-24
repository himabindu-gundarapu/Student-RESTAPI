package jsonParserWithPOJO;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

	
	
	public class Root {
	
	@JsonProperty("username")
	private String username;
	@JsonProperty("password")
	private String password;
	@JsonProperty("sessionid")
	private List<Integer> sessionid = null;
	@JsonProperty("students")
	private List<Student> students = null;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	
	@JsonProperty("username")
	public String getUsername() {
	return username;
	}
	
	@JsonProperty("username")
	public void setUsername(String username) {
	this.username = username;
	}
	
	@JsonProperty("password")
	public String getPassword() {
	return password;
	}
	
	@JsonProperty("password")
	public void setPassword(String password) {
	this.password = password;
	}
	
	@JsonProperty("sessionid")
	public List<Integer> getSessionid() {
	return sessionid;
	}
	
	@JsonProperty("sessionid")
	public void setSessionid(List<Integer> sessionid) {
	this.sessionid = sessionid;
	}
	
	@JsonProperty("students")
	public List<Student> getStudents() {
	return students;
	}
	
	@JsonProperty("students")
	public void setStudents(List<Student> students) {
	this.students = students;
	}
	
	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
	return this.additionalProperties;
	}
	
	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
	this.additionalProperties.put(name, value);
	}

}

