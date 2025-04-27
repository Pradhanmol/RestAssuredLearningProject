package org.modals;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private int id ;
    private String name;
    private String description;
    private double price;
    private int category_id;
    private String category_name;
    public Product(){

    }
    // for post req setting the valuing using below constructor
    public Product(String name, String description, double price, int category_id, String category_name){
        setName(name);
        setDescription(description);
        setPrice(price);
        setCategory_id(category_id);
        setCategory_name(category_name);
    }
    public Product(int id,String name, String description, double price, int category_id, String category_name){
        setId(id);
        setName(name);
        setDescription(description);
        setPrice(price);
        setCategory_id(category_id);
        setCategory_name(category_name);
    }

}
