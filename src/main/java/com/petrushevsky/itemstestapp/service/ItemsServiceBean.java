package com.petrushevsky.itemstestapp.service;
import com.petrushevsky.itemstestapp.model.Items;
import com.petrushevsky.itemstestapp.utils.ReadCSVtoList;
import java.util.*;

@org.springframework.stereotype.Service
public class ItemsServiceBean implements ItemsService {

    final List listCSV = ReadCSVtoList.readCSVtoLost();//защищаем от изменений

    public ItemsServiceBean() throws Exception {}


    @Override
    public String getAll() {
        return listCSV.toString();
    }

    @Override
    public String getCategoriesReports() {
        List list = listCSV;
        String categoryEquals = ""; //переменная для сравнения и поиска уникальных категорий

        String report = "categories:[{"; //начало длинного отчета
        //объявление коллекций
        ArrayList<String> categoriesList = new ArrayList<>();
        ArrayList<String> productsList = new ArrayList<>();
        ArrayList<String> reportsList = new ArrayList<>();
        //создаем список из уникальных категорий
        for (Object object : list) {
            Items items = (Items) object;

            if (!items.getCategory().equals(categoryEquals)) {
                categoriesList.add(items.getCategory());
                categoryEquals = items.getCategory();
            }

        }
        //проходим по каждой категории и отбираем продукты на основе этих категорий
        report = getBigReport(list, report, categoriesList, productsList, reportsList);

        return report;
    }

    private String getBigReport(List list, String report, ArrayList<String> categoriesList, ArrayList<String> productsList, ArrayList<String> reportsList) {
       //TODO Надо отрефакторить и ускорить перебор
        for (String s : categoriesList) {
            report = report + "name:" + "\"" + s + "\"";
            for (Object object : list) {
                Items items = (Items) object;
                //отбираем продукт собержащий категорию выше
                if (items.getCategory().contains(s)) {
                    productsList.add(items.getProduct());
                    report = report + ",products:[{" + "\"" + items.getProduct() + "\"" + ",components:[";
                    //выводим его компоненты
                    if (!items.getComponent1().isEmpty()) {
                        report = report + "\"" + items.getComponent1() + "\"";
                    }
                    if (!items.getComponent2().isEmpty()) {
                        report = report + "," + "\"" + items.getComponent2() + "\"";
                    }
                    report = report + "],reports:";
                    //выводим отчеты по каждому продукту
                    if (!items.getReport1().isEmpty()) {
                        reportsList.add("\"report1\"");
                    }
                    if (!items.getReport2().isEmpty()) {
                        reportsList.add("\"report2\"");
                    }
                    if (!items.getReport3().isEmpty()) {
                        reportsList.add("\"report3\"");
                    }
                    if (!items.getReport4().isEmpty()) {
                        reportsList.add("\"report4\"");
                    }
                    if (!items.getReport5().isEmpty()) {
                        reportsList.add("\"report5\"");
                    }
                    report += reportsList.toString() + "}]";
                    reportsList.clear();
                }

            }
            report += "}]";

        }
        return report;
    }

    @Override
    public String getAllItemsReports(int reportNumber) {
        while (reportNumber > 0 && reportNumber < 6) {
            List list = listCSV;

            List<String> reportsList = new ArrayList<>();
            //Обходим все объекты класса Items и ввыбираем его поле из report1-6 через переменную reportNumber
            for (Object object : list) {
                Items items = (Items) object;

                switch (reportNumber) {
                    case 1:
                        if (!items.getReport1().isEmpty()) { //любое значение подходит в том числе как в ТЗ "Х" если оно присутствует
                            reportsList.add("\"" + items.getProduct() + "\"");
                        }
                        break;
                    case 2:
                        if (!items.getReport2().isEmpty()) {
                            reportsList.add("\"" + items.getProduct() + "\"");
                        }
                        break;
                    case 3:
                        if (!items.getReport3().isEmpty()) {
                            reportsList.add("\"" + items.getProduct() + "\"");
                        }
                        break;
                    case 4:
                        if (!items.getReport4().isEmpty()) {
                            reportsList.add("\"" + items.getProduct() + "\"");
                        }
                        break;
                    case 5:
                        if (!items.getReport5().isEmpty()) {
                            reportsList.add("\"" + items.getProduct() + "\"");
                        }
                        break;
                }
            }
            return "reports: [{" + "name:\"report" + reportNumber + "\",products:" + reportsList.toString() + "}]";
        }
        return "Error - only reports from 1 to 5";
    }


    @Override
    public String getComponentsReports(int reportNumber) {
        List list = listCSV;
        while (reportNumber > 0 && reportNumber < 6) {

            List<String> componentsList = new ArrayList<>();

            for (Object object : list) {
                Items items = (Items) object;
              //проходим все обьекты класса айтем и выбираем его поле по номеру входной переменной и выводим компоненты согласно отчету
                switch (reportNumber) {
                    case 1:
                        if (!items.getReport1().isEmpty()) {
                            if (!items.getComponent1().isEmpty()) {
                                componentsList.add("\"" + items.getComponent1() + "\"");
                            }
                            if (!items.getComponent2().isEmpty()) {
                                componentsList.add("\"" + items.getComponent2() + "\"");
                            }

                        }
                        break;
                    case 2:
                        if (!items.getReport2().isEmpty()) {
                            if (!items.getComponent1().isEmpty()) {
                                componentsList.add("\"" + items.getComponent1() + "\"");
                            }
                            if (!items.getComponent2().isEmpty()) {
                                componentsList.add("\"" + items.getComponent2() + "\"");
                            }

                        }
                        break;
                    case 3:
                        if (!items.getReport3().isEmpty()) {
                            if (!items.getComponent1().isEmpty()) {
                                componentsList.add("\"" + items.getComponent1() + "\"");
                            }
                            if (!items.getComponent2().isEmpty()) {
                                componentsList.add("\"" + items.getComponent2() + "\"");
                            }

                        }
                        break;
                    case 4:
                        if (!items.getReport4().isEmpty()) {
                            if (!items.getComponent1().isEmpty()) {
                                componentsList.add("\"" + items.getComponent1() + "\"");
                            }
                            if (!items.getComponent2().isEmpty()) {
                                componentsList.add("\"" + items.getComponent2() + "\"");
                            }

                        }
                        break;
                    case 5:
                        if (!items.getReport5().isEmpty()) {
                            if (!items.getComponent1().isEmpty()) {
                                componentsList.add("\"" + items.getComponent1() + "\"");
                            }
                            if (!items.getComponent2().isEmpty()) {
                                componentsList.add("\"" + items.getComponent2() + "\"");
                            }

                        }
                        break;
                }
            }
            return "reports: [{" + "name:\"report" + reportNumber + "\",components:" + componentsList.toString() + "}]";
        }
        return "Error - only reports from 1 to 5";
    }
}

