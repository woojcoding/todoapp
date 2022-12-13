//package woojcoding.todoapp.Todo;
//
//import com.google.gson.Gson;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.web.util.UriComponentsBuilder;
//
//import java.net.URI;
//
//import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
//import static org.hamcrest.Matchers.startsWith;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.springframework.test.web.client.match.MockRestRequestMatchers.header;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//class TodoControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private Gson gson;
//
//    @Test
//    public void PostTodoTest() throws Exception {
//        //given
////        TodoDto.Post post = new TodoDto.Post("exercise", 1, false);
//
//        String content = gson.toJson(post);
//
//        //when
//        ResultActions actions = mockMvc.perform(
//                post("/")
//                        .accept(MediaType.APPLICATION_JSON)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(content)
//        );
//
//        //then
//        actions
//                .andExpect(status().isCreated());
//
//    }
//
//    @Test
//    public void getTodoTest() throws Exception {
//        //given
////        TodoDto.Post post = new TodoDto.Post("exercise", 1, false);
//        String postContent = gson.toJson(post);
//
//        ResultActions postActions = mockMvc.perform(
//                post("/")
//                        .accept(MediaType.APPLICATION_JSON)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(postContent)
//        );
//
//        int todoId;
//
//        //when
//        String location = postActions.andReturn().getResponse().getHeader("Location");
//        System.out.println(location + "ddd");
//        todoId = 1;
//
//        URI uri = UriComponentsBuilder.newInstance().path("/{todo-id}").buildAndExpand(todoId).toUri();
//        //then
//        mockMvc
//                .perform(
//                        get(uri)
//                                .accept(MediaType.APPLICATION_JSON)
//                )
//                .andExpect(status().isOk());
//    }
//}