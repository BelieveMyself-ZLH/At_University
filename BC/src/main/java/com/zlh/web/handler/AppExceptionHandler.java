package com.zlh.web.handler;

import com.zlh.utils.JsonVo;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: ZhouLinHu
 * @Description: 全局捕获异常处理类
 * @Date: Created in 14:24 2019/5/8
 */
public class AppExceptionHandler {
    private final static Logger logger = org.slf4j.LoggerFactory.getLogger(AppExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JsonVo handle(HttpServletRequest request, HttpServletResponse response, Exception e) {

        logger.error("ERROR ======> {}", e);
        return JsonVo.instance(JsonVo.CODE_SUCCESS, e.getMessage());
    }
}
