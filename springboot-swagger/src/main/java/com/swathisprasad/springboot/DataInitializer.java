package com.swathisprasad.springboot;

import com.swathisprasad.springboot.dao.entity.Language;
import com.swathisprasad.springboot.dao.repository.ILanguageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    private final Logger logger = LoggerFactory.getLogger(DataInitializer.class);

    @Autowired
    ILanguageRepository languageRepository;

    public void initData() {

        try {
            Language language = new Language();
            language.setName("Java");
            languageRepository.save(language);

            language = new Language();
            language.setName("JavaScript");
            languageRepository.save(language);

            language = new Language();
            language.setName("C++");
            languageRepository.save(language);

            language = new Language();
            language.setName("Groovy");
            languageRepository.save(language);

            language = new Language();
            language.setName("Python");
            languageRepository.save(language);

            language = new Language();
            language.setName("Swift");
            languageRepository.save(language);


        } catch (final Exception ex) {
            logger.error("Exception while inserting mock data {}", ex);
        }

    }


}
