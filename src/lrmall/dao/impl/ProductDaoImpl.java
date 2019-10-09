package lrmall.dao.impl;

import lrmall.bean.Product;
import lrmall.dao.ProductDao;
import lrmall.utils.DbUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class ProductDaoImpl extends DbUtil implements ProductDao {

    /**
     * 根据ID查询商品全部信息
     */
    @Override
    public Product queryProductById(int id) {
        String sql = "SELECT * FROM PRODUCT WHERE id = ?";
        Object[] params = {id};
        Product product = null;
        try {
            ResultSet resultSet = this.doQuery(sql, params);
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                double price = resultSet.getDouble("price");
                String image = resultSet.getString("image");
                int type = resultSet.getInt("type");
                product = new Product(id, name, description, price, image, type);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return product;
    }

    /**
     * 添加商品
     * 添加商品的name,description,price,image
     */
    @Override
    public int addProduct(Product product) {
        try {
            String sql = "INSERT INTO Product(name,description,price,image,type) VALUES(?,?,?,?,?);";
            Object[] params = {product.getName(), product.getDescription(), product.getPrice(), product.getImage(),
                    product.getType()};
            return this.doUpdate(sql, params);
        } finally {
            this.close();
        }
    }

    /**
     * 根据商品Id查询商品的所有规格
     * 返回商品规格的Map
     */
    @Override
    public HashMap<String, ArrayList<String>> queryNorm(int id) {
        HashMap<String, ArrayList<String>> stringMap = new HashMap<>();
        String sql = "select * from norm where pid = ?";
        ResultSet resultSet = this.doQuery(sql, new Object[]{id});
        try {
            while (resultSet.next()) {
                String aName = resultSet.getString("aName");
                String aValue = resultSet.getString("aValue");
                //键已经存在
                if (stringMap.containsKey(aName)) {
                    stringMap.get(aName).add(aValue);
                } else {
                    ArrayList<String> value = new ArrayList<>();
                    value.add(aValue);
                    stringMap.put(aName, value);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return stringMap;
    }

    /**
     * 根据商品类别查询商品
     */
    @Override
    public ArrayList<Product> queryProductByType(int type) {
        ArrayList<Product> arrayList = new ArrayList<>();
        String sql = "SELECT * FROM PRODUCT WHERE type = ?";
        ResultSet resultSet = this.doQuery(sql, new Object[]{type});
        try {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                double price = resultSet.getDouble("price");
                String image = resultSet.getString("image");
                arrayList.add(new Product(id, name, description, price, image, type));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return arrayList;
    }

    /**
     * 添加商品规格
     */
    @Override
    public void addTips(String tipName, String tip) {
        String sql = "INSERT INTO NORM(pid,aName,aValue) VALUES ((SELECT MAX(id) FROM product),?,?)";
        this.doUpdate(sql, new Object[]{tipName, tip});
        this.close();
    }

}
