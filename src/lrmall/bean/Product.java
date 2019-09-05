package lrmall.bean;

public class Product {
    private int id; //商品唯一标识
    private String name; //商品名称
    private String description;  //商品描述
    private double price;  //商品价格
    private int number;  //商品数量

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getNumber() {
        return number;
    }
}
