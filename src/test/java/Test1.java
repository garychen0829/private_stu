import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by gary on 2016/5/12.
 */
public class Test1 {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Test
    public void test(){

        String str = "hello! gary.chen";
        logger.info("logger info : {}", str);
        logger.info("logger debug: {}", str);
        System.out.println("github upload..");
        System.out.println(System.getProperty("line.separator"));
        System.out.println("="+System.getProperty("line.separator")+"=");
    }
}
