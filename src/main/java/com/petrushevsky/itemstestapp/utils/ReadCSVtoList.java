package com.petrushevsky.itemstestapp.utils;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;
import com.petrushevsky.itemstestapp.model.Items;

import java.io.FileReader;
import java.util.List;

public class ReadCSVtoList {
    public static List readCSVtoLost() throws Exception {
        @SuppressWarnings({"rawtypes", "unchecked"})
        CsvToBean csv = new CsvToBean();
        String csvFilename = "src/main/resources/csv/products.csv";
        CSVReader csvReader = new CSVReader(new FileReader(csvFilename));
        List list = csv.parse(setColumMapping(), csvReader);
        return list;
    }


    @SuppressWarnings({"rawtypes", "unchecked"})
    private static ColumnPositionMappingStrategy setColumMapping() {
        ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
        strategy.setType(Items.class);
        String[] columns = new String[]{"id", "product", "category", "component1", "component2", "report1", "report2", "report3", "report4", "report5"};
        strategy.setColumnMapping(columns);
        return strategy;
    }
}