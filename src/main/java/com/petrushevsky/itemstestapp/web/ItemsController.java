package com.petrushevsky.itemstestapp.web;

import com.petrushevsky.itemstestapp.service.ItemsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)

public class ItemsController {
    private final ItemsService itemsService;

    //вывод всего CSV файла
    @GetMapping("/items")
    @ResponseStatus(HttpStatus.OK)
    public String readAll() {
        return itemsService.getAll();
    }

    //вывод всех категорий по шаблону из ТЗ
    @GetMapping("/categories")
    @ResponseStatus(HttpStatus.OK)
    public String readCategories() {
        return itemsService.getCategoriesReports();
    }

    //вывод отчета с товарами по номерам 1-5
    @GetMapping("/reports/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String getReport(@PathVariable Integer id) {
        return itemsService.getAllItemsReports(id);
    }

    //вывод отчета с компонентами по номерам 1-5
    @GetMapping("/components/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String getComponents(@PathVariable Integer id) {
        return itemsService.getComponentsReports(id);
    }

}
