import com.neo.SpringBootShiroApplication;
import com.neo.entity.SecKill;
import com.neo.service.SecKillService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by zouxiang on 2017/10/31.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SpringBootShiroApplication.class)
public class TestSecKillService {

    @Autowired
    private SecKillService secKillService;
    @Test
    public void testUserService(){
        SecKill secKill = secKillService.findById(123456);
        System.out.println("第一次查询: "+secKill.getRemainNum());
        secKill.setId(123456);
        secKillService.resumeSecKill(secKill);
        SecKill secKill2 = secKillService.findById(123456);
        System.out.println("第二次查询: "+secKill2.getRemainNum());
        SecKill secKill3 = secKillService.findById(123456);
        System.out.println("第三次查询: "+secKill3.getRemainNum());
        SecKill secKill4 = secKillService.findById(123456);
        System.out.println("第四次查询: "+secKill4.getRemainNum());
        SecKill secKill5 = secKillService.findById(123456);
        System.out.println("第五次查询: "+secKill5.getRemainNum());
        SecKill secKill6 = secKillService.findById(123456);
        System.out.println("第六次查询: "+secKill6.getRemainNum());
    }

}
