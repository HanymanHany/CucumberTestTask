package apiModel.request;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RequestResourceCredentials{

	@JsonProperty("password")
	private String password;

	@JsonProperty("grant_type")
	private String grantType;

	@JsonProperty("username")
	private String username;
}
