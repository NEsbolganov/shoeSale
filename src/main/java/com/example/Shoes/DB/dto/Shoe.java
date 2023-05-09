package com.example.Shoes.DB.dto;

import jakarta.persistence.*;

@Entity
@Table
public class Shoe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "size")
    private Integer size;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "type")
    private String type;

    @Column(name = "material")
    private String material;

    @Column(name = "price")
    private Integer price;

    @Override
    public String toString() {
        return "Shoe{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", size=" + size +
                ", manufacturer='" + manufacturer + '\'' +
                ", type='" + type + '\'' +
                ", material='" + material + '\'' +
                ", price=" + price +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
