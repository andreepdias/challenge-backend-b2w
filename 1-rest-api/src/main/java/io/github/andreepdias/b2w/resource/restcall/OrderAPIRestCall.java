package io.github.andreepdias.b2w.resource.restcall;

import io.github.andreepdias.b2w.resource.dto.ItemDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class OrderAPIRestCall {

    private final String URL = "http://www.mocky.io/v2/5817803a1000007d01cc7fc9";

    public List<ItemDTO> getAllOrderItemsFromAPI(){
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<ItemDTO[]> orderItemsRequest = restTemplate.getForEntity(URL, ItemDTO[].class);
        ItemDTO[] orderItems = orderItemsRequest.getBody();

        return new ArrayList<>(Arrays.asList(orderItems));

    }
}
