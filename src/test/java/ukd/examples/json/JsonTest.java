package ukd.examples.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class JsonTest {

    @Test
    public void testJsonProperty() throws JsonProcessingException {
        JsonExampleModel model = new JsonExampleModel();
        model.setFirstName("Firstname");
        model.setUsername("username");
        ObjectMapper mapper = new ObjectMapper();
        assertEquals("{\"firstName\":\"Firstname\",\"user\":\"username\"}", mapper.writeValueAsString(model));
    }

    @Test
    public void testJsonAlias() throws IOException {
        String modelString = "{\"name\":\"Firstname\",\"user\":\"username\"}";
        ObjectMapper mapper = new ObjectMapper();
        JsonExampleModel model = mapper.readValue(modelString, JsonExampleModel.class);

        assertEquals("Firstname", model.getFirstName());
        assertEquals("username", model.getUsername());
    }
}
