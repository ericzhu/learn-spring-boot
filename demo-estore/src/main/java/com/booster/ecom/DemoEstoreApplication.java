package com.booster.ecom;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.EnumSet;
import java.util.stream.Stream;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.endpoint.MetricReaderPublicMetrics;
import org.springframework.boot.actuate.endpoint.PublicMetrics;
import org.springframework.boot.actuate.metrics.repository.InMemoryMetricRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionEvaluationReport;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.FileSystemUtils;

import com.booster.ecom.constant.ApplicationConstants;
import com.booster.ecom.constant.Profiles;
import com.booster.ecom.model.entity.Image;
import com.booster.ecom.model.entity.User;
import com.booster.ecom.repository.db.ImageRepository;
import com.booster.ecom.repository.db.UserRepository;

@SpringBootApplication
public class DemoEstoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoEstoreApplication.class, args);
    }

    @Bean
    public InMemoryMetricRepository inMemoryMetricRepository() {
        return new InMemoryMetricRepository();
    }

    @Bean
    public PublicMetrics publicMetrics(InMemoryMetricRepository repository) {
        return new MetricReaderPublicMetrics(repository);
    }

    // @Bean
    // public FilterRegistrationBean getSpringSecurityFilterChainBindedToError(@Qualifier("springSecurityFilterChain")
    // Filter springSecurityFilterChain) {
    //
    // FilterRegistrationBean registration = new FilterRegistrationBean();
    // registration.setFilter(springSecurityFilterChain);
    // registration.setDispatcherTypes(EnumSet.allOf(DispatcherType.class));
    // return registration;
    // }

    @Bean
    @Profile(Profiles.DEMO)
    public CommandLineRunner setup(ImageRepository imageRepository, UserRepository userRepository, ConditionEvaluationReport report) throws IOException {
        return (args) -> {

            // === add sample files
            FileSystemUtils.deleteRecursively(new File(ApplicationConstants.UPLOAD_DIR));
            Files.createDirectory(Paths.get(ApplicationConstants.UPLOAD_DIR));

            FileCopyUtils.copy("test file1", new FileWriter(ApplicationConstants.UPLOAD_DIR + "/test1"));
            imageRepository.save(new Image("test1", null));

            FileCopyUtils.copy("test file2", new FileWriter(ApplicationConstants.UPLOAD_DIR + "/test2"));
            imageRepository.save(new Image("test2", null));

            FileCopyUtils.copy("test file3", new FileWriter(ApplicationConstants.UPLOAD_DIR + "/test3"));
            imageRepository.save(new Image("test3", null));

            // === add sample users
            User[] users = { new User("user1", "user1", "ROLE_ADMIN", "ROLE_USER"),
                new User("user2", "user2", "ROLE_ADMIN", "ROLE_USER"),
                new User("user3", "user3", "ROLE_ADMIN", "ROLE_USER"),
                new User("user4", "user4", "ROLE_ADMIN", "ROLE_USER") };
            Stream.of(users).forEach(userRepository::save);

            report.getConditionAndOutcomesBySource().entrySet().stream().filter(e -> e.getValue().isFullMatch()).forEach(e -> {
                System.out.println(e.getKey() + " => match? " + e.getValue().isFullMatch());
            });
        };
    }
}
