import com.aistar.dao.ProductDao;
import com.aistar.service.ProductService;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnnotation {
    @Test
    public void getDaoBean(){
        BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext_annotation.xml");
        ProductDao dao = (ProductDao) factory.getBean("productDaoImpl");
        dao.insert(null);

    }
    @Test
    public void getServiceBean(){
        BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext_annotation.xml");
        ProductService service = (ProductService)factory.getBean("productServiceImpl");
        service.getAll();
    }
}
