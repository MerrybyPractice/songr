package com.cimakasky.songr;

import com.cimakasky.songr.database.Song;
import com.cimakasky.songr.database.SongRepository;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class SongControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webapplicationContext;

    @Autowired
    SongController songController;

    @Autowired
    SongRepository repo;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webapplicationContext).build();
    }

    @Test
    public void testCreateSong() throws Exception {
        Song song = new Song();
        song.title = "test";
        repo.save(song);

        Song song2 = new Song();
        song2.title = "Blur";
        repo.save(song2);

        mockMvc.perform(MockMvcRequestBuilders.get("/create"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/html; charset=UTV-8"))
                .andExpect(content().string(Matchers.containsString("test")))
                .andExpect(content().string(Matchers.containsString("Blur")));
    }
}
