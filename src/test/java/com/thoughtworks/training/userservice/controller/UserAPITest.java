package com.thoughtworks.training.userservice.controller;

import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class UserAPITest {

//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private ToDoRepository toDoRepository;
//    @MockBean
//    ToDoListService toDoListService;
//
//    @Test
//    @WithMockUser(value = "zhang")
//    public void shouldReturnItemListMockService() throws Exception {
//        when(toDoListService.getAll()).thenReturn(Arrays.asList(new ToDo(1, "text", false, new Date().getTime(), 1, null)));
//        mockMvc.perform(get("/lists"))
//                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(1))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].text").value("text"));
//    }

}