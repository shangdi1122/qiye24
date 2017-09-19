package qiye.aop;

import org.aspectj.lang.JoinPoint;

import java.util.Arrays;
import java.util.logging.Logger;

/**
 * Created by THINKPAD on 2017/9/17.
 */
public class ControllerLog {

    private final Logger logger = Logger.getLogger("ControllerLog");

    public void before(JoinPoint joinPoint) {
        logger.info("调用" + joinPoint.getTarget() + "对象的" + joinPoint.getSignature().getName() + "方法，该方法的参数为：" + Arrays.toString(joinPoint.getArgs()));
    }

    public void after(JoinPoint joinPoint, Object result) {
        logger.info("调用" + joinPoint.getTarget() + "对象的" + joinPoint.getSignature().getName() + "方法，该方法的返回值为：" + result);

    }
}
