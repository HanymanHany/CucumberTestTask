package constants.data;

import com.github.javafaker.Faker;
import env.api.ApiEnvContainer;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Getter
@FieldDefaults(level = AccessLevel.PUBLIC)
public class Generator extends ApiEnvContainer {
    Faker faker = new Faker();

    String name = faker.name().firstName(),
            surname = faker.name().lastName(),
            username = faker.name().username(),
            email = faker.internet().emailAddress();

    public String getPassword() {
        return EncodingBase64(faker.internet().password());
    }
}
