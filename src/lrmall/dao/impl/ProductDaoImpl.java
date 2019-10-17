package lrmall.dao.impl;

import lrmall.bean.Product;
import lrmall.dao.ProductDao;
import lrmall.utils.DbUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author: Luoru
 * @Date: 2019/10/10 15:04
 * @Description: ProductDao实现类
 */
public class ProductDaoImpl extends DbUtil implements ProductDao {

    /**
     * @param id 商品id
     * @return product 根据id查询到的Product对象
     * @time 2019年10月10日15:20:28
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
                setProduct(resultSet, product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return product;
    }

    /**
     * @param product 需要添加的Product对象
     * @return 添加操作影响的数据项数
     * @time 2019年10月10日15:22:21
     */
    @Override
    public int addProduct(Product product) {
        try {
            String sql = "INSERT INTO Product(name,description,price,image,type,store) VALUES(?,?,?,?,?,?);";
            Object[] params = {product.getName(), product.getDescription(), product.getPrice(), product.getImage(),
                    product.getType(), product.getStore()};
            return this.doUpdate(sql, params);
        } finally {
            this.close();
        }
    }

    /**
     * @param type Product对象的商品类别type属性
     * @return 根据type查询到的所有Product的ArrayList集合
     * @time 2019年10月10日15:29:08
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
     * @param store 店铺的id
     * @return 所有属于该店铺的Product对象的ArrayList集合
     * @time 2019年10月10日15:26:45
     */
    @Override
    public ArrayList<Product> queryProductByStore(String store) {
        ArrayList<Product> products = new ArrayList<>();
        Product product;
        String sql = "SELECT * FROM PRODUCT WHERE store = ?";
        try {
            ResultSet resultSet = this.doQuery(sql, new Object[]{store});
            while (resultSet.next()) {
                product = new Product();
                setProduct(resultSet, product);
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
     * @return 数据库中所有的Product对象的ArrayList集合
     * @time 2019年10月10日15:27:12
     */
    @Override
    public ArrayList<Product> queryAllProducts() {
        ArrayList<Product> products = new ArrayList<>();
        Product product;
        String sql = "SELECT * FROM PRODUCT";
        try {
            ResultSet resultSet = this.doQuery(sql, null);
            while (resultSet.next()) {
                product = new Product();
                setProduct(resultSet, product);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return products;
    }

    @Override
    public int deleteProduct(int productId) {
        String sql = "DELETE from product WHERE id = ?";
        try {
            return this.doUpdate(sql, new Object[]{productId});
        } finally {
            this.close();
        }
    }

    @Override
    public int updateProduct(Product product) {
        String sql = "UPDATE product set name=?,description=?,price=?,image=? WHERE id=?";
        Object[] params = {product.getName(), product.getDescription(), product.getPrice(), product.getImage(), product.getId()};
        try {
            return this.doUpdate(sql, params);
        } finally {
            this.close();
        }
    }

    @Override
    public ArrayList<Product> selectLikeProduct(String keyword) {
        ArrayList<Product> likeProducts = new ArrayList<>();
        String sql = "SELECT * FROM product WHERE name like '%"+keyword+"%' OR description like '%"+keyword+"%'";
        ResultSet resultSet = this.doQuery(sql, null);
        try {
            while(resultSet.next()){
                Product product = new Product();
                setProduct(resultSet,product);
                likeProducts.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return likeProducts;
    }

    @Override
    public ArrayList<Product> selectLikeProductLimit(String keyword,int start,int number) {
        ArrayList<Product> pageProducts = new ArrayList<>();
        String sql = "SELECT * FROM product WHERE name like '%"+keyword+"%' OR description like '%"+keyword+"%' limit "+start+","+number+"";
        try {
            ResultSet resultSet = this.doQuery(sql, null);
            while(resultSet.next()){
                Product product = new Product();
                setProduct(resultSet,product);
                pageProducts.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return pageProducts;
    }

    /**
     * @param resultSet 数据库查询到的所有商品信息的结果集
     * @param product   需要初始化的product对象
     * @time 2019年10月10日15:28:21
     */
    private void setProduct(ResultSet resultSet, Product product) throws SQLException {
        product.setId(resultSet.getInt("id"));
        product.setName(resultSet.getString("name"));
        product.setNumber(resultSet.getInt("stock"));
        product.setImage(resultSet.getString("image"));
        product.setType(resultSet.getInt("type"));
        product.setDescription(resultSet.getString("description"));
        product.setPrice(resultSet.getDouble("price"));
        product.setStore(resultSet.getString("store"));
    }

}
