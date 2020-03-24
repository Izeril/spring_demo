import com.aistar.dao.ProductDao;
import com.aistar.pojo.Product;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;
import java.util.List;

public class TestJDBC {
    BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext_jdbc.xml");
    ProductDao productDao = (ProductDao) factory.getBean("productDaoImpl");
    @Test
    public void testJdbcTemplate(){

//        System.out.println((JdbcTemplate)factory.getBean("jdbcTemplate"));

        Product product = productDao.selectByPrimaryKey("8cbe3c515625415085fc095f008dc3c7");
        System.out.println(product);
    }

    @Test
    public void testSelectAll(){
        List<Product> productList = productDao.selectAll();
        for (Product products:productList
        ) {
            System.out.println(products);
        }
    }

    @Test
    public void  testInsert(){
        Product product  = new Product("213131323","长虹电视1",1231313131l,5999.9f,"珠海","五颜六色",55f,new Date());
        Boolean bb = productDao.insert(product);
        System.out.println(bb);

    }

    @Test
    public void  testDelete(){
        Boolean B = productDao.delete("27984231311323");
        System.out.println(B);
    }

    @Test
    public void testUpdate(){
        Product product  = new Product("213131323","长虹电视2",1231313131l,5999.9f,"珠海","五颜六色",55f,new Date());
        Boolean b = productDao.update(product);
        System.out.println(b);
    }
}
