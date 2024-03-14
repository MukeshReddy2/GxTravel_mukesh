// package com.galaxe.Loggers;
//
// import com.fasterxml.jackson.databind.ObjectMapper;
// import org.aspectj.lang.ProceedingJoinPoint;
// import org.aspectj.lang.annotation.Around;
// import org.aspectj.lang.annotation.Aspect;
// import org.aspectj.lang.annotation.Pointcut;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.stereotype.Component;
//
// @Aspect
// @Component
// public class LoggersAdvises {
//  // Initializing logger
//  Logger log = LoggerFactory.getLogger(LoggersAdvises.class.getName());
//
//  // Defining a pointcut for methods in controllers excluding OrderController
//  @Pointcut("execution(* com.galaxe.Controller.*.*(..))")
//  public void myPointcut() {}
//
//  // Advice to log method invocation details and response details
//  @Around("myPointcut()")
//  public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
//    // Creating an instance of ObjectMapper to convert objects to JSON format
//    ObjectMapper mapper = new ObjectMapper();
//
//    // Getting the method name
//    String methodName = pjp.getSignature().getName();
//
//    // Getting the class name (controller) as a string
//    String className = pjp.getTarget().getClass().toString();
//
//    // Getting the arguments passed to the method
//    Object[] array = pjp.getArgs();
//
//    // Logging method invocation details
//    log.info(
//        "method invoked "
//            + className
//            + " : "
//            + methodName
//            + "()"
//            + "arguments : "
//            + mapper.writeValueAsString(array));
//
//    // Proceeding with the original method execution
//    Object object = pjp.proceed();
//
//    // Logging method response details
//    log.info(
//        className + " : " + methodName + "()" + "Response : " +
// mapper.writeValueAsString(object));
//
//    // Returning the result of the original method execution
//    return object;
//  }
// }
