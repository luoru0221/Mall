package lrmall.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.Properties;

/**
 * 数据库连接工具
 * 使用Druid数据库连接池
 */
public class DbConnection {

    //数据库连接池对象
    private static DataSource dataSource;

    static{
        try {
            //加载配置文件
            Properties properties = new Properties();
            properties.load(Objects.requireNonNull(DbConnection.class.getClassLoader().getResourceAsStream("druid.properties")));
            //获得数据库连接池对象
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获得数据库的连接
     */
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    /**
     *关闭数据库连接
     */
    public static void close(ResultSet resultSet, Statement statement,Connection connection){
        try {
            if (resultSet!=null){
                resultSet.close();
            }
            if(statement!=null){
                statement.close();
            }
            if(connection!=null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Statement statement,Connection connection){
        close(null,statement,connection);
    }

    public static DataSource getDataSource(){
        return dataSource;
    }

}
