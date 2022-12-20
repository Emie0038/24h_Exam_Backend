package com.example.my24hexam.Controller;

import com.example.my24hexam.Entity.Product;
import com.example.my24hexam.Service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest()
class ProductControllerTest {


        private MockMvc mockMvc;

        @MockBean
        ProductService productService;

        private List<Product> productList;


        @BeforeEach
        void setUp() {
            productList = new ArrayList<>();
            productList.add(new Product("Rice", 35.0, "500"));

        }

        @Test
        void contextLoad() {
            assertThat(mockMvc).isNotNull();
        }

        //@Test
        void getAllProducts() throws Exception {
            Mockito.when(productService.getAllProducts()).thenReturn(productList);
            mockMvc.perform(MockMvcRequestBuilders
                            .get("/products")
                            .accept(MediaType.APPLICATION_JSON))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("[*]").exists())
                    .andExpect(MockMvcResultMatchers.jsonPath("[*].id").isNotEmpty());
        }

        @Test
        void getProductById() {
        }

        @Test
        void createProduct() throws Exception {
            Product product = new Product("Rice", 35.0, "500");

            Mockito.when(productService.createProduct(Mockito.any())).thenReturn(product);

            mockMvc.perform(MockMvcRequestBuilders
                            .post("/products")
                            .content(asJsonString(product))
                            .contentType(MediaType.APPLICATION_JSON_VALUE)
                    )
                    .andExpect(status().isCreated())
                    .andExpect(MockMvcResultMatchers.jsonPath("*.id").exists());
        }

        @Test
        void updateProduct() {
        }

        @Test
        void deleteProduct() {
        }

        public static String asJsonString(final Object obj) {
            try {
                return new ObjectMapper().writeValueAsString(obj);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

