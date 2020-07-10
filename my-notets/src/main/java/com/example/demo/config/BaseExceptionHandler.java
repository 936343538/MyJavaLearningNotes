package com.example.demo.config;

import com.example.demo.model.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;

/**
 * 公共异常处理类
 *
 * ---
 * 注解 @ControllerAdvice 是一个通知类,在发生异常的时候调用
 * 在该类中，可以定义多个方法，不同的方法处理不同的异常，例如专门处理空指针的方法、专门处理数组越界的方法...，
 * ---
 * @author hongzf
 * @date 2020/7/10 16:44
 */
@ControllerAdvice
@Slf4j
public class BaseExceptionHandler {

    /**
     * 注解 @ExceptionHandler 用来指明异常的处理类型，即如果这里指定为 NullpointerException，则数组越界异常就不会进到这个方法中来。
     * @param exception
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)//定义http返回码
    public ApiResponse error(Exception exception) {
        log.error("【Exception】:{}", exception.getMessage());
        System.err.println(Arrays.toString(exception.getStackTrace()));
        return ApiResponse.of(500, "不知道发生了什么", null);
    }


    /**
     * 自定义404异常
     * 需要在application中添加以下配置信息
     *
     * ```
     * spring:
     *   mvc:
     *     #发生异常直接抛出,框架不要处理
     *     throw-exception-if-no-handler-found: true
     *   resources:
     *     #不要为我们工程中的资源文件建立映射
     *     add-mappings: false
     * ```
     *
     * @param request 用来获取请求的信息
     * @param e 异常信息
     * @return
     */
    @ExceptionHandler(value = NoHandlerFoundException.class)
    @ResponseBody
    public ApiResponse defaultErrorHandler(HttpServletRequest request, NoHandlerFoundException e) {
        log.error("【NoHandlerFoundException】:请求URL:{} , 异常信息:{}", request.getRequestURI(), e.getMessage());
        return ApiResponse.of(404, "404", null);
    }

    @ExceptionHandler(value = IOException.class)
    @ResponseBody
    public ApiResponse ioException(IOException e) {
        log.error("【IOException】异常信息:{}", e.getMessage());
        return ApiResponse.of(500, e.getMessage(), null);
    }
}