package env.web;

import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.LoadType.MERGE;

@Config.LoadPolicy(MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/env/web.properties"
})

/** data for initialization api
 path config/env/api.properties **/
public interface WebConfig extends Config {

    @Key("url")
    String getUrl();

    @Key("login")
    String getLogin();

    @Key("password")
    String getPassword();

}
