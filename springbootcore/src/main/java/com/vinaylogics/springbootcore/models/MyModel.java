package com.vinaylogics.springbootcore.models;

import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class MyModel {

    private String name;
    private Integer id;
    private Long timestamp;
    private List<String> list;
    private Set<String> set;
    private Map<Integer,String> map;
    private Product product;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public Map<Integer, String> getMap() {
        return map;
    }

    public void setMap(Map<Integer, String> map) {
        this.map = map;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyModel myModel = (MyModel) o;
        return Objects.equals(name, myModel.name) && Objects.equals(id, myModel.id) && Objects.equals(timestamp, myModel.timestamp) && Objects.equals(list, myModel.list) && Objects.equals(set, myModel.set) && Objects.equals(map, myModel.map) && Objects.equals(product, myModel.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, timestamp, list, set, map, product);
    }

    @Override
    public String toString() {
        return "MyModel{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", timestamp=" + timestamp +
                ", list=" + list +
                ", set=" + set +
                ", map=" + map +
                ", product=" + product +
                '}';
    }
}
