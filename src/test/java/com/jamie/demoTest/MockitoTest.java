package com.jamie.demoTest;
import com.jamie.demo.*;
import io.cucumber.java.jv.Lan;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class MockitoTest {
    private DatabaseApplication databaseApplication;
    @Mock
    private LanguageRepository languageRepository;

    @Mock
    private ActorRepository actorRepository;

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private FilmRepository filmRepository;

    @BeforeEach
    void Setup(){
        databaseApplication = new DatabaseApplication(actorRepository,
                languageRepository,
                categoryRepository,
                filmRepository);
    }

    @Test
    public void testAddLanguage(){
        Language savedLanguage = new Language("Test Language ");
        String expected = "save";
        String actual = databaseApplication.addLanguage(savedLanguage.getName());
        ArgumentCaptor<Language>languageArgumentCaptor= ArgumentCaptor.forClass(Language.class);
        verify(languageRepository).save(languageArgumentCaptor.capture());
        languageArgumentCaptor.getValue();
        Assertions.assertEquals(expected,actual,"data hasn't been entered into the mock database");



    }


}
