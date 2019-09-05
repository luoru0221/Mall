package lrmall.dao.impl;

import lrmall.bean.Product;
import lrmall.dao.ProductDao;
import lrmall.utils.DbUtil;

public class ProductDaoImpl extends DbUtil implements ProductDao {

    /**
     * 添加商品
     */
    @Override
    public int addProduct(Product product) {
        try {
            String sql = "INSERT INTO Product(id,name,description,price,number) VALUES(?,?,?,?,?);";
            Object[] params = {product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getNumber()};
            return this.doUpdate(sql, params);
        } finally {
            this.close();
        }
    }


}
