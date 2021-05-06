package ukd.examples.json;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonExampleModel {

    @JsonProperty("user")
    String username;

    @JsonAlias("name")
    String firstName;

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "Username: " + username + " First name: " + firstName;
    }
}
