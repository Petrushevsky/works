package com.petrushevsky.itemstestapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Items {

    private String id;
    private String product;
    private String category;
    private String component1;
    private String component2;
    private String report1;
    private String report2;
    private String report3;
    private String report4;
    private String report5;

    @Override
    public String toString() {

        return "Items{" +
                "id='" + id + '\'' +
                ", product='" + product + '\'' +
                ", category='" + category + '\'' +
                ", component1='" + component1 + '\'' +
                ", component2='" + component2 + '\'' +
                ", report1='" + report1 + '\'' +
                ", report2='" + report2 + '\'' +
                ", report3='" + report3 + '\'' +
                ", report4='" + report4 + '\'' +
                ", report5='" + report5 + '\'' +
                '}';
    }


}
