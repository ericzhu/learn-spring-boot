package com.booster.cms;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.booster.cms.web.i18n.I18nMessageService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoCmsApplicationTests {

    @Autowired
    I18nMessageService i18nMessageService;

    @Test
    public void testMessageByLocale() {

        String expectedMessage = "Storefront Commerce Item Detail";
        String messageKey = "commerce.item.page.title";

        assertEquals(expectedMessage, i18nMessageService.getMessage(messageKey));

    }
}