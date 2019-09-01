package com.bkt.msscmilkclient.web.client;

import com.bkt.msscmilkclient.web.model.CustomerDto;
import com.bkt.msscmilkclient.web.model.MilkDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class milkeryClientTest {

    @Autowired
    MilkeryClient client;

    @Test
    void getMilkById() {
        MilkDto dto = client.getMilkById(UUID.randomUUID());

        assertNotNull(dto);
    }

    @Test
    void saveNewBeer() {
        //given
        MilkDto milkDto = MilkDto.builder().milkName("New milk").build();

        URI uri = client.saveNewBeer(milkDto);

        assertNotNull(uri);

        System.out.println(uri.toString());
    }

    @Test
    void updateMilk() {
        //given
        MilkDto milkDto = MilkDto.builder().milkName("New milk").build();

        client.updateMilk(UUID.randomUUID(), milkDto);
    }

    @Test
    void deleteMilk() {

        client.deleteMilk(UUID.randomUUID());
    }

    @Test
    void getCustomerById() {
        CustomerDto dto = client.getCustomerById(UUID.randomUUID());

        assertNotNull(dto);

    }

    @Test
    void testSaveNewCustomer() {
        //given
        CustomerDto customerDto = CustomerDto.builder().name("Joe").build();

        CustomerDto customerDto1 = client.saveNewCustomer(customerDto);

        assertNotNull(customerDto1);

        System.out.println(customerDto1.toString());

    }

    @Test
    void testUpdateCustomer() {
        //given
        CustomerDto customerDto = CustomerDto.builder().name("Jim").build();

        client.updateCustomer(UUID.randomUUID(), customerDto);

    }

    @Test
    void testDeleteCustomer() {
        client.deleteCustomer(UUID.randomUUID());

    }
}
