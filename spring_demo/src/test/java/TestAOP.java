import com.aistar.pojo.Product;
import com.aistar.service.ProductService;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class TestAOP {

    BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext_aop.xml");
    ProductService service = (ProductService) factory.getBean("productServiceImpl");
    @Test
    public void testInsert(){

        Product product  = new Product("27984addasdasd166666666","长虹电视4",1231359854531l,5999.9f,"珠海","五颜六色",55f,new Date());
       Boolean flag = service.add(product);
        System.out.println(flag);
    }

    @Test
    public void testUpdate(){
        Product p1 = service.getById("213131323");
        Product p2 = service.getById("27984addasdasd1323");

        service.updatePrice(p1,p2);
    }
}
