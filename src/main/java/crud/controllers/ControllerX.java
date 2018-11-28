package crud.controllers;

import act.Act;
import act.controller.Controller;
import org.osgl.http.H;
import org.osgl.mvc.annotation.After;
import org.osgl.mvc.annotation.Before;
import org.osgl.mvc.annotation.Catch;
import org.osgl.mvc.annotation.Finally;

import java.io.PrintWriter;
import java.io.StringWriter;

import static act.Act.LOGGER;

/**
 * @author dreamingo
 */
public class ControllerX extends Controller.Util {

    /** 执行开始时间 */
    public Long startTime = 0L;

    /** 执行是否成功 */
    public Boolean success = true;

    /** HTTP GET方法 */
    public static final String HTTP_METHOD_GET = "GET";

    /**
     * 初始化，执行所有操作前
     */
    @Before
    public void init() {
        startTime = System.currentTimeMillis();
        System.out.println("init:;:::::::::::::::");
    }

    @Catch(value=Throwable.class, priority = 1)
    public void catchThrowable(Throwable throwable) {
        success = false;
        System.out.println("catchThrowable:;:::::::::::::");
        LOGGER.error("Action execute failed at [%s].", throwable.getStackTrace());
        LOGGER.error("Error is: %s.", getExceptionStr(throwable));
    }

    protected static String getExceptionStr(Throwable throwable) {
        StringWriter sw = new StringWriter();
        throwable.printStackTrace(new PrintWriter(sw, true));
        return sw.toString();
    }

    @After
    public void doAfter() {
        success = true;
        System.out.println("doAfter:;:::::::::::::");
    }

    @Finally
    public void doFinally() {
        System.out.println("doFinally:;:::::::::::::" + success);
        Long executeTime = System.currentTimeMillis() - startTime;
        LOGGER.info("executeTime::::::::" + executeTime);
    }
}
