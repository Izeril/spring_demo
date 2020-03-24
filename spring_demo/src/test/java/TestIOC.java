import com.aistar.dao.ProductDao;
import com.aistar.service.ProductService;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIOC {

    //获得Spring 容器中的dao对象
    @Test
    public void getDaoBean(){
        //1.实例化Spring 容器
        BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.获得容器中的bean对象
//        ProductDao dao = (ProductDao) factory.getBean("productDao");
        ProductDao dao1 = (ProductDao) factory.getBean("productDaoImpl");
        ProductDao dao2 = (ProductDao) factory.getBean("productDaoImpl");
//        System.out.println(dao);
        System.out.println(dao1);
        System.out.println(dao2);
//        System.out.println(dao== dao1);

        ((ClassPathXmlApplicationContext) factory).close();// 关闭spring容器，并释放资源




        //3. 获得容器中serivce对象
        ProductService service = (ProductService)factory.getBean("productServiceImpl");
        service.getAll();
    }
}
