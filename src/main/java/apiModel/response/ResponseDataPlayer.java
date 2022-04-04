package apiModel.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ResponseDataPlayer {

	@JsonProperty("bonuses_allowed")
	private boolean bonusesAllowed;

	@JsonProperty("birthdate")
	private Object birthdate;

	@JsonProperty("gender")
	private Object gender;

	@JsonProperty("surname")
	private String surname;

	@JsonProperty("timezone_id")
	private Object timezoneId;

	@JsonProperty("name")
	private String name;

	@JsonProperty("phone_number")
	private Object phoneNumber;

	@JsonProperty("id")
	private int id;

	@JsonProperty("is_verified")
	private boolean isVerified;

	@JsonProperty("country_id")
	private Object countryId;

	@JsonProperty("email")
	private String email;

	@JsonProperty("username")
	private String username;

}