package com.example.jsf4test;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class BarBean {

    String name;
    List<Item> items = new ArrayList<>();

@PostConstruct
public void init(){
    items.add(new Item("item1", new Feature("feature1", "important"), new Feature("feature2", "normal")));
    items.add(new Item("item2", new Feature("feature3", "minor"), new Feature("feature4", "normal")));
}

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Item> getItems() {
        return items;
    }

    public class Item {
        String name;
        List<Feature> features = new ArrayList<>();

        public Item(String name, Feature... features) {
            this.name = name;
            this.features = List.of(features);
        }

        public String getName() {
            return name;
        }

        public List<Feature> getFeatures() {
            return features;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setFeatures(List<Feature> features) {
            this.features = features;
        }
    }

    public class Feature{
        String name;
        String flag;

        public Feature(String name, String flag) {
            this.name = name;
            this.flag = flag;
        }

        public String getName() {
            return name;
        }

        public String getFlag() {
            return flag;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setFlag(String flag) {
            this.flag = flag;
        }
    }
}
