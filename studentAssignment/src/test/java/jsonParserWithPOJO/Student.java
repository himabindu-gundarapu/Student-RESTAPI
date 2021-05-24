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
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonPropertyOrder({
	"id",
	"name",
	"marks",
	"contact",
	"address"
	})
		@Generated("jsonschema2pojo")
		public class Student {
		
		@JsonProperty("id")
		private Integer id;
		@JsonProperty("name")
		private String name;
		@JsonProperty("marks")
		private List<Integer> marks = null;
		@JsonProperty("contact")
		private List<String> contact = null;
		@JsonProperty("address")
		private List<Address> address = null;
		@JsonIgnore
		private Map<String, Object> additionalProperties = new HashMap<String, Object>();
		
		@JsonProperty("id")
			public Integer getId() 
			{
			return id;
			}
		
		@JsonProperty("id")
			public void setId(Integer id) 
			{
				this.id = id;
			}
		
			@JsonProperty("name")
			public String getName()
			{
				return name;
			}
		
		@JsonProperty("name")
			public void setName(String name) 
			{
			this.name = name;
			}
		
			@JsonProperty("marks")
			public List<Integer> getMarks() {
				return marks;
			}
		
			@JsonProperty("marks")
				public void setMarks(List<Integer> marks) 
				{
					this.marks = marks;
				}
		
			@JsonProperty("contact")
			public List<String> getContact() 
			{
				return contact;
			}
		
			@JsonProperty("contact")
			public void setContact(List<String> contact) 
			{
				this.contact = contact;
			}
		
			@JsonProperty("address")
			public List<Address> getAddress() 
			{
				return address;
			}
		
			@JsonProperty("address")
			public void setAddress(List<Address> address) 
			{
				this.address = address;
				}
		
			@JsonAnyGetter
			public Map<String, Object> getAdditionalProperties() 
			{
				return this.additionalProperties;
			}
		
			@JsonAnySetter
			public void setAdditionalProperty(String name, Object value) 
			{
				this.additionalProperties.put(name, value);
			}
		
		}
	
	
