package com.jyp.product.Health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicReference;

@Component
public class ApplicationHealthIndicator implements HealthIndicator {
    private final AtomicReference<Health> healthRefer = new AtomicReference<>(Health.down().build());

    @Override
    public Health health() {
        return healthRefer.get();
    }

    public void setHealth(Health health) {
        this.healthRefer.set(health);
    }
}

