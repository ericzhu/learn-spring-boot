package com.booster.cms.integration;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.booster.cms.DemoCmsApplication;
import com.booster.cms.core.domain.Plan;
import com.booster.cms.core.domain.Role;
import com.booster.cms.core.domain.User;
import com.booster.cms.core.domain.UserRole;
import com.booster.cms.core.repository.PlanRepository;
import com.booster.cms.core.repository.RoleRepository;
import com.booster.cms.core.repository.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoCmsApplication.class)
public class RepositoryIntegrationTest {

    private static final Long BASIC_PLAN_ID = 1L;
    private static final Long BASIC_ROLE_ID = 1L;

    @Autowired
    private PlanRepository    planRepository;

    @Autowired
    private RoleRepository    roleRepository;

    @Autowired
    private UserRepository    userRepository;

    @Before
    public void init() {
        Assert.assertNotNull(planRepository);
    }

    @Test
    public void testCreateNewPlan() {
        planRepository.save(createBasicPlan());
        Plan plan = planRepository.findOne(BASIC_PLAN_ID);
        Assert.assertNotNull(plan);
    }

    @Test
    public void testCreateNewRole() {
        roleRepository.save(createBasicRole());
        Role role = roleRepository.findOne(BASIC_ROLE_ID);
        Assert.assertNotNull(role);
    }

    @Test
    public void testCreateNewUser() {
        Plan basicPlan = createBasicPlan();
        planRepository.save(basicPlan);

        User basicUser = createBasicUser();
        basicUser.setPlan(basicPlan);

        Role basicRole = createBasicRole();
        Set<UserRole> userRoles = new HashSet<>();
        UserRole userRole = new UserRole(basicUser, basicRole);
        userRoles.add(userRole);
        basicUser.getUserRoles().addAll(userRoles);
        basicUser.getUserRoles().forEach(ur -> roleRepository.save(ur.getRole()));

        userRepository.save(basicUser);
        User newlyCreatedUser = userRepository.findOne(basicUser.getId());

        Assert.assertNotNull(newlyCreatedUser);
        Assert.assertTrue(newlyCreatedUser.getId() > 0L);
        Assert.assertNotNull(newlyCreatedUser.getPlan());
        System.out.println(newlyCreatedUser.getUserRoles().size());
        Assert.assertTrue(newlyCreatedUser.getUserRoles().size() == 1L);
    }

    private Plan createBasicPlan() {
        return new Plan(BASIC_PLAN_ID, "basic");
    }

    private Role createBasicRole() {
        return new Role(BASIC_ROLE_ID, "ROLE_ADMIN");
    }

    private User createBasicUser() {
        User user = new User();
        user.setUsername("");
        user.setPassword("");

        user.setFirstName("Frist Name");
        user.setLastName("Last name");

        user.setCountry("CA");
        user.setProfileImageUrl("http://abc.amazon.com");
        user.setEmail("abc@email.com");
        user.setEnabled(true);
        user.setDescription("a test user");

        return user;
    }
}
