package me.song.mvcfirst;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.song.mvcfirst.beans.Product;
import me.song.mvcfirst.repository.ProductRepository;
import me.song.mvcfirst.service.ProductService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.regex.Matcher;

import static org.junit.jupiter.api.Assertions.*;
@WebMvcTest({ProductController.class,ProductService.class, ProductRepository.class}) // controller만 test
class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    @DisplayName("Product를 cd로 조회하는 테스트")
    @Test
    void getProducttest() throws Exception {
        Long cd = 1L;
//        mockMvc.perform(MockMvcRequestBuilders
//                .get("/product/" + "1")
//                .accept(MediaType.APPLICATION_JSON)
//
//        ).andExpect(MockMvcResultMatchers.jsonPath("$.cd", Matchers.is(1)))
//         .andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.is("Samsung")))
//         .andDo(MockMvcResultHandlers.print());

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/product/" + "1")
                        .accept(MediaType.APPLICATION_JSON)

                ).andReturn();

        String body = result.getResponse().getContentAsString();

        System.out.println("body");

        ObjectMapper objectMapper = new ObjectMapper();

        Product product = objectMapper.readValue(body, Product.class);

        assertAll(
                ()->{
                    System.out.println("s1");
                    boolean flg1 = product.getCd() == 1;
                    assertTrue(flg1);
                },
                ()->{
                    System.out.println("s1");
                    boolean flg2 = product.getName().equals("Samsung");
                    assertTrue(flg2);
                }

        );

    }
}