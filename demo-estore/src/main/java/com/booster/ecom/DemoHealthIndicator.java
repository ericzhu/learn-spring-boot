package com.booster.ecom;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class DemoHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {

        try {
            int code = ((HttpURLConnection)new URL("http://www.github.com").openConnection()).getResponseCode();
            if (code >= 200 && code < 300) {
                return Health.up().build();
            }
            else {
                return Health.down().withDetail("HTTP status code", code).build();
            }

        }
        catch (IOException e) {
            return Health.down(e).build();
        }
    }

}
