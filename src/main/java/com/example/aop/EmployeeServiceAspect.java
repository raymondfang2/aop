package com.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Iterator;

/**
 * TODO:
 * 1. pointcut based on Annotation e.g. @SecurePersist //only method with this Aspect will be invoked
 * 2. Parameters: check the annotation for whole object encrypt/descrption
 *                check for field level annotation for field level injection
 *          Important: How about the input HashMap, return value HashMap ==> How to mark it?
 *          Do I add keyID as part of encrypted value?
 *          Do I support hash?
 *          HashMap is not supported in the 1st version!
 */
@Aspect
@Component
public class EmployeeServiceAspect
{
    //@Before(value = "execution(* com.example.aop.EmployeeService.*(..)) and args(empId, fname, sname)")
    //@Before(value = "execution(* com.example.aop.EmployeeService.*(..))")
   public void beforeAdvice(JoinPoint joinPoint, String empId, String fname, String sname) {
    //public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("Before method:" + joinPoint.getSignature());
        System.out.println("=====>"+ Arrays.stream(joinPoint.getArgs()).count());
        Iterator i = Arrays.stream(joinPoint.getArgs()).iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
        //System.out.println("Creating Employee with first name - " + fname + ", second name - " + sname + " and id - " + empId);
    }
}