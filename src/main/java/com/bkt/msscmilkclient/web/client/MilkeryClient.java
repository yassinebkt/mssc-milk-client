package com.bkt.msscmilkclient.web.client;

import com.bkt.msscmilkclient.web.model.CustomerDto;
import com.bkt.msscmilkclient.web.model.MilkDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "sfg.milkery", ignoreUnknownFields = false)
public class MilkeryClient {

    public final String MILK_PATH_V1 = "/api/v1/milk/";
    public final String CUSTOMER_PATH_V1 = "/api/v1/customer/";


    private String apiHost;
    private final RestTemplate restTemplate;

    public MilkeryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public MilkDto getMilkById(UUID uuid){
        return restTemplate.getForObject(apiHost + MILK_PATH_V1 + uuid.toString(), MilkDto.class);
    }

    public URI saveNewBeer(MilkDto milkDto){
        return restTemplate.postForLocation(apiHost + MILK_PATH_V1, milkDto );
    }

    public void updateMilk(UUID uuid, MilkDto milkDto){
        restTemplate.put(apiHost + MILK_PATH_V1 + uuid.toString(), milkDto );
    }

    public void deleteMilk(UUID uuid){
        restTemplate.delete(apiHost + MILK_PATH_V1 + uuid.toString());
    }

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }

    public CustomerDto getCustomerById(UUID customerId) {
        return restTemplate.getForObject(apiHost+ CUSTOMER_PATH_V1 + customerId.toString(), CustomerDto.class);
    }

    public CustomerDto saveNewCustomer(CustomerDto customerDto) {
        return  restTemplate.postForObject(apiHost + CUSTOMER_PATH_V1,customerDto, CustomerDto.class);
    }

    public void updateCustomer(UUID customerId, CustomerDto customerDto) {
        restTemplate.put(apiHost + CUSTOMER_PATH_V1 + customerId, customerDto);
    }

    public void deleteCustomer(UUID customerId) {
        restTemplate.delete(apiHost + CUSTOMER_PATH_V1 + customerId);
    }
}
