package events;

import com.jyp.product.events.Event;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class EventTest {

    @Test
    public void builder() {
        String name = "test event";
        Event event = Event.builder()
                .name(name)
                .description("ksug")
                .build();
        assertThat(event.getName()).isEqualTo(name);
    }

    @Test
    public void javaBean() {
        String name = "pjy";
        Event event = new Event();
        event.setName(name);
        event.hashCode();
        assertThat(event.getName()).isEqualTo(name);
    }

}