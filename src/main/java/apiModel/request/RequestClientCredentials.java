package apiModel.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RequestClientCredentials {

	@JsonProperty("grant_type")
	private String granType;
	@JsonProperty("scope")
	private String scope;
}