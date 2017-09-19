package conn;

import base.TestBase;
import org.junit.Test;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by THINKPAD on 2017/9/17.
 */
public class TestConn extends TestBase{

    @Inject
    private DataSource dataSource;

    @Test
    public void testConn() {
        try {
            System.out.println(dataSource.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
