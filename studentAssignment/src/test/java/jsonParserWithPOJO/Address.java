package jsonParserWithPOJO;

		
import java.util.HashMap;
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
"state",
"city"
})
	@Generated("jsonschema2pojo")
	public class Address {

	@JsonProperty("state")
	private String state;
@JsonProperty("city")
	private String city;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("state")
		public String getState() 
		{
		return state;
		}

	@JsonProperty("state")
		public void setState(String state) 
		{
			this.state = state;
		}

	@JsonProperty("city")
		public String getCity() 
		{
			return city;
		}

		@JsonProperty("city")
		public void setCity(String city) 
		{
			this.city = city;
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
			




