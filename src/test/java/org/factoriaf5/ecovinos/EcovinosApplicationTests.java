package org.factoriaf5.ecovinos;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import repositories.Vino;
import repositories.VinoRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
class EcovinosApplicationTests {

    @Test
    void contextLoads() {
    }
    @SpringBootTest
    @AutoConfigureMockMvc
    class ApplicationTests {

        @Autowired
        MockMvc mockMvc;

        @Test
        void loadsTheHomePage() throws Exception {
            mockMvc.perform(get("/"))
                    .andExpect(status().isOk())
                    .andExpect(view().name("home"));
        }
    }
    @Autowired
    VinoRepository vinoRepository;

    @Test
    void returnsTheExistingBooks() throws Exception {

        Vino vino = vinoRepository.save(new Vino("rioja"));

        MockMvc mockMvc;
        mockMvc.perform(get("/vinos"))
                .andExpect(status().isOk())
                .andExpect(view().name("vinos/all"))
                .andExpect(model().attribute("books", hasItem(vino)));
    }

}
