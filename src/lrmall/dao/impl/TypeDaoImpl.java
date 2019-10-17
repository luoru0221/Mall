package lrmall.dao.impl;

import lrmall.bean.Type;
import lrmall.dao.TypeDao;
import lrmall.utils.DbUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TypeDaoImpl extends DbUtil implements TypeDao {
    @Override
    public int addType(Type type) {
        String sql = "INSERT INTO productType (fid,name) values(?,?)";
        Object[] params = {type.getFid(),type.getName()};
        try {
            return this.doUpdate(sql,params);
        } finally {
            this.close();
        }
    }

    @Override
    public void selectAllType(ArrayList<Type> allTypes, int fId) {
        String sql = "SELECT * FROM PRODUCTTYPE WHERE fid = ?";
        try {
            ResultSet resultSet = this.doQuery(sql, new Object[]{fId});
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                int fid = resultSet.getInt("fid");
                String name = resultSet.getString("name");
                ArrayList<Type> children = new ArrayList<>();
                Type type = new Type();
                type.setId(id);
                type.setFid(fid);
                type.setName(name);
                type.setcTypes(children);
                allTypes.add(type);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally
        {
            this.close();
        }
        for (Type allType : allTypes) {
            if(allType!=null){
                selectAllType(allType.getcTypes(),allType.getId());
            }
        }
    }


    @Override
    public ArrayList<Type> selectChildrenTypes(int fId) {
        String sql = "SELECT * FROM PRODUCTTYPE WHERE fid = ?";
        ArrayList<Type> childrenTypes = new ArrayList<>();
        ResultSet resultSet = this.doQuery(sql, new Object[]{fId});
        Type type;
        try {
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                int fid = resultSet.getInt("fid");
                String name = resultSet.getString("name");
                type = new Type();
                type.setId(id);
                type.setFid(fid);
                type.setName(name);

                childrenTypes.add(type);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return childrenTypes;
    }
}
