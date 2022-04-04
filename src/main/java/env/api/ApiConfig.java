package env.api;

import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.LoadType.MERGE;

@Config.LoadPolicy(MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/env/api.properties"
})

/** data for initialization api
 path config/env/api.properties **/
public interface ApiConfig extends Config {

    @Key("url")
    String getUrl();

    @Key("basic_auth")
    String getBasicAuth();

    @Key("host")
    String getHost();


}
