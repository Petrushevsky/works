package com.petrushevsky.itemstestapp.service;

import com.petrushevsky.itemstestapp.model.Items;

import java.util.List;

public interface ItemsService {
    String getAll();
    String getAllItemsReports(int reportNumber);

    String getCategoriesReports();
    String getComponentsReports(int reportNumber);
}
