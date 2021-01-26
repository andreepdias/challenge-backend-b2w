package io.github.andreepdias.b2w.service.ItemService;

import io.github.andreepdias.b2w.resource.restcall.OrderAPIRestCall;
import io.github.andreepdias.b2w.resource.dto.ItemDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {

    private final OrderAPIRestCall orderAPIRestCall;

    public ItemService(OrderAPIRestCall orderAPIRestCall) {
        this.orderAPIRestCall = orderAPIRestCall;
    }

    public List<ItemDTO> filterItemsByDateFromOrdersAPIItems(String beginDateRaw, String finalDateRaw) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-M-yyyy");

        LocalDate beginDate = LocalDate.parse(beginDateRaw, formatter);
        LocalDate finalDate = LocalDate.parse(finalDateRaw, formatter);

        List<ItemDTO> orderItemsAPI = orderAPIRestCall.getAllOrderItemsFromAPI();

        return orderItemsAPI.stream()
                .filter(x -> !(x.getDate().toLocalDate().isAfter(finalDate) || x.getDate().toLocalDate().isBefore(beginDate)) )
                .collect(Collectors.toList());
    }
}
