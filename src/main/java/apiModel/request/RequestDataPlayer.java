package apiModel.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RequestDataPlayer {

	@JsonProperty("surname")
	private String surname;

	@JsonProperty("name")
	private String name;

	@JsonProperty("password_change")
	private String passwordChange;

	@JsonProperty("password_repeat")
	private String passwordRepeat;

	@JsonProperty("email")
	private String email;

	@JsonProperty("username")
	private String username;
}