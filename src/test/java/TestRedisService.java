import com.neo.SpringBootShiroApplication;
import com.neo.entity.SecKill;
import com.neo.service.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by zouxiang on 2017/9/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SpringBootShiroApplication.class)
public class TestRedisService {
    @Autowired
    private RedisService redisService;

    @Test
    public void testRedisService(){
        SecKill secKill = new SecKill();
        secKill.setRemainNum(2);
        secKill.setGoodsName("1");
        secKill.setId(5);
        redisService.putSecKill(secKill);
        redisService.getSecKill(secKill.getId());
    }
}
