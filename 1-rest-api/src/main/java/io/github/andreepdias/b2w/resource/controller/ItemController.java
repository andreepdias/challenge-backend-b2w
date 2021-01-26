package io.github.andreepdias.b2w.resource.controller;

import io.github.andreepdias.b2w.resource.dto.ItemDTO;
import io.github.andreepdias.b2w.service.ItemService.ItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("challenge-backend")
public class ItemController {

    private final ItemService service;

    public ItemController(ItemService service) {
        this.service = service;
    }

    @GetMapping("item")
    public List<ItemDTO> filterItemByDate(
            @RequestParam(name = "begindate") String beginDate,
            @RequestParam(name = "finaldate") String finalDate){
        return service.filterItemsByDateFromOrdersAPIItems(beginDate, finalDate);
    }
}
