package club.banyuan.project.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

public class DruidUtil {
    public  static Connection getCon() throws Exception {
        Properties  properties=new Properties();
        properties.load(new FileInputStream("druid.properties"));
        return DruidDataSourceFactory.createDataSource(properties).getConnection();
    }


}
