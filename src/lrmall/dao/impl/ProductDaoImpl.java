package lrmall.dao.impl;

import lrmall.bean.Product;
import lrmall.dao.ProductDao;
import lrmall.utils.DbUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *  @author: Luoru
 *  @Date: 2019/10/10 15:04
 *  @Description: ProductDao实现类
 */
public class ProductDaoImpl extends DbUtil implements ProductDao {

    /**
     * @time 2019年10月10日15:20:28
     * @param id 商品id
     * @return product 根据id查询到的Product对象
     */
    @Override
    public Product queryProductById(int id) {
        String sql = "SELECT * FROM PRODUCT WHERE id = ?";
        Object[] params = {id};
        Product product = null;
        try {
            ResultSet resultSet = this.doQuery(sql, params);
            while (resultSet.next()) {
                product = new Product();
                setProduct(resultSet,product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return product;
    }

    /**
     * @time 2019年10月10日15:22:21
     * @param product 需要添加的Product对象
     * @return 添加操作影响的数据项数
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
     * @time 2019年10月10日15:29:08
     * @param type Product对象的商品类别type属性
     * @return 根据type查询到的所有Product的ArrayList集合
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

    /**
     * @time 2019年10月10日15:26:45
     * @param storeId 店铺的id
     * @return 所有属于该店铺的Product对象的ArrayList集合
     */
    @Override
    public ArrayList<Product> queryProductByStore(int storeId) {
        ArrayList<Product> products = new ArrayList<>();
        Product product;
        String sql = "SELECT * FROM PRODUCT WHERE store = ?";
        try {
            ResultSet resultSet = this.doQuery(sql, new Object[]{storeId});
            while(resultSet.next()){
                product = new Product();
                setProduct(resultSet,product);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return products;
    }

    /**
     * @time 2019年10月10日15:27:12
     * @return 数据库中所有的Product对象的ArrayList集合
     */
    @Override
    public ArrayList<Product> queryAllProducts() {
        ArrayList<Product> products = new ArrayList<>();
        Product product;
         String sql = "SELECT * FROM PRODUCT";
        try {
            ResultSet resultSet = this.doQuery(sql, null);
            while(resultSet.next()){
                product = new Product();
                setProduct(resultSet,product);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return products;
    }

    /**
     * @time 2019年10月10日15:28:21
     * @param resultSet 数据库查询到的所有商品信息的结果集
     * @param product 需要初始化的product对象
     */
    private void setProduct(ResultSet resultSet,Product product) throws SQLException {
        product.setId(resultSet.getInt("id"));
        product.setName(resultSet.getString("name"));
        product.setNumber(resultSet.getInt("stock"));
        product.setImage(resultSet.getString("image"));
        product.setType(resultSet.getInt("type"));
        product.setDescription(resultSet.getString("description"));
        product.setPrice(resultSet.getDouble("price"));
        product.setStore(resultSet.getInt("store"));
    }

}
