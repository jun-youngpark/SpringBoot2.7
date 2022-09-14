package com.jyp.product.Health;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.health.Health;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(path = "/health")
@RequiredArgsConstructor
public class L7CheckApi {
    private final ApplicationHealthIndicator healthIndicator;

    @PutMapping(path = "/up")
    public void up() {
        final Health up = Health.up().build();
        healthIndicator.setHealth(up);
    }

    @PutMapping(path = "/down")
    public void down() {
        final Health down = Health.down().build();
        healthIndicator.setHealth(down);
    }
}
