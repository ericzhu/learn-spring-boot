package com.booster.cms.web.i18n;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

@Service
public class I18nMessageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(I18nMessageService.class);

    private MessageSource       messageSource;

    @Autowired
    public I18nMessageService(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    /**
     * Return a message for a given message key, locale and parameters.
     * 
     * @param messageKey
     * @param locale
     * @param params
     * @return
     */
    public String getMessage(String messageKey, Locale locale, Object... params) {
        return messageSource.getMessage(messageKey, params, locale);
    }

    /**
     * Returns a message for a given message key and locale.
     * 
     * @param messageKey
     * @param locale
     * @return
     */
    public String getMessage(String messageKey, Locale locale) {
        return messageSource.getMessage(messageKey, null, locale);
    }

    /**
     * Returns a message for a given
     * 
     * @param messageKey
     * @return
     */
    public String getMessage(String messageKey) {
        LOGGER.info("Returning message for the message key : {}", messageKey);
        return messageSource.getMessage(messageKey, null, LocaleContextHolder.getLocale());
    }
}
