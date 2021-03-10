package com.atqgh.springboot.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ProjectName: java_prac1
 * @Description:
 * @Author: qiguohui
 * @Date: 2021/3/8 15:26
 */
public class CalculationUtils {
    private final static String ERR_NOT_END_VALID = "表达的最后一个字符必须是'#'!";
    private final static String ERR_PARENTHESE_NOT_PAIR = "括号不配对!";
    private final static String ERR_CHAR_NOT_SUPPORT = "不支持的字符！";
    private final static String ERR_OPERATION_NOT_SUPPORTED = "不支持的操作！";
    private final static String ERR_OPERATOR_NOT_VALID = " 不支持double数据！";
    private final static String ERR_UNKNOWN = "未知错误！";
    private static boolean isDouble;// 输入的类型是否是double类型
    private static final Logger LOGGER = LoggerFactory.getLogger( CalculationUtils.class );

    // 传入字符串表达式如："1-(2*2)+6"
    public static String eval(String expression) {
        expression = expression.replaceAll(" ", "");// 去掉全部空格
        expression += "#";// #为结束标记
        ArrayList<String> list;
        try {
            list = toSuffixSequence(expression);
            return calculate(list);
        } catch (Exception e) {
            LOGGER.error("公式计算错误！");
            return null;
        }
    }
    // 计算类，在栈中取出
    private static String calculate(ArrayList<String> list) throws Exception {
        Stack<String> stack = new Stack<String>();// 栈
        for (String s : list) {// 遍历list
            if (isOperator(s)) {// 如果是运算符+-*/%
                String d1 = stack.pop();// 将栈中当前元素出栈
                String d2 = stack.pop();// 将栈中当前元素出栈
                String res = doCalc(d2, d1, s);
                stack.push(res);
            } else
                stack.push(s);
        }
        if (stack.size() == 1)
            return stack.pop();
        else
            throw new Exception(ERR_UNKNOWN);
    }
    private static String doCalc(String d1, String d2, String oper) throws Exception {
        if (oper != null && oper.length() > 1)
            throw new Exception(ERR_OPERATION_NOT_SUPPORTED + ":'" + oper + "'");
        isDouble = isDoubleNeeded(d1, d2, oper);
        switch (oper.charAt(0)) {
            case '+':
                if (isDouble)
                    return Double.toString(Double.parseDouble(d1) + Double.parseDouble(d2));
                else
                    return Integer.toString(Integer.parseInt(d1) + Integer.parseInt(d2));
            case '-':
                if (isDouble)
                    return Double.toString(Double.parseDouble(d1) - Double.parseDouble(d2));
                else
                    return Integer.toString(Integer.parseInt(d1) - Integer.parseInt(d2));
            case '*':
                if (isDouble)
                    return Double.toString(Double.parseDouble(d1) * Double.parseDouble(d2));
                else
                    return Integer.toString(Integer.parseInt(d1) * Integer.parseInt(d2));
            case '/':
                if (isDouble)
                    return Double.toString(Double.parseDouble(d1) / Double.parseDouble(d2));
                else
                    return Integer.toString(Integer.parseInt(d1) / Integer.parseInt(d2));
            case '%':
                if (isDouble)
                    throw new Exception("'%' " + ERR_OPERATOR_NOT_VALID);
                else
                    return Integer.toString(Integer.parseInt(d1) % Integer.parseInt(d2));
            default:
                throw new Exception(ERR_OPERATION_NOT_SUPPORTED + ":'" + oper + "'");
        }
    }
    private static boolean isDoubleNeeded(String d1, String d2, String oper) {
        if (d1.contains(".") || d2.contains("."))
            return true;
        if (oper != null && oper.equals("/")) {
            int left = Integer.parseInt(d1) % Integer.parseInt(d2);
            if (left != 0)
                return true;
        }
        return false;
    }
    private static boolean isOperator(String str) {
        if (str != null && (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/") || str.equals("%")))
            return true;
        return false;
    }
    // 产生准备计算的list放入栈
    private static ArrayList<String> toSuffixSequence(String expression) throws Exception {
        if (!expression.endsWith("#"))
            throw new Exception(ERR_NOT_END_VALID);
        ArrayList<String> list = new ArrayList<String>();
        Stack<String> stack = new Stack<String>();
        stack.push("#");// 作为标记，压入栈
        char last, ch;
        StringBuffer sb = null;
        for (int i = 0; i < expression.length(); i++) {
            ch = expression.charAt(i);
            switch (ch) {
                case '+':
                case '-':
                case '*':
                case '/':
                case '%':
                    last = stack.peek().charAt(0);// peek()查看栈顶对象而不移除它
                    if (last != '(' && priority(last) >= priority(ch))
                        list.add(stack.pop());
                    stack.push("" + ch);
                    break;
                case '(':
                    stack.push("(");
                    break;
                case ')':
                    while (!stack.isEmpty() && stack.peek().charAt(0) != '(')
                        list.add(stack.pop());
                    if (stack.isEmpty() || stack.size() == 1)
                        throw new Exception("')' " + ERR_PARENTHESE_NOT_PAIR);
                    stack.pop();
                    break;
                case '#':
                    while (stack.size() > 1 && stack.peek().charAt(0) != '(')
                        list.add(stack.pop());
                    if (stack.size() > 1)
                        throw new Exception("'(' " + ERR_PARENTHESE_NOT_PAIR);
                    break;
                default:
                    if (Character.isDigit(ch) || '.' == ch) {
                        sb = new StringBuffer();
                        sb.append(ch);
                        while (Character.isDigit(expression.charAt(i + 1)) || expression.charAt(i + 1) == '.')
                            sb.append(expression.charAt(++i));
                        list.add(sb.toString());
                        break;
                    } else
                        throw new Exception(ERR_CHAR_NOT_SUPPORT + ":'" + ch + "'");
            }
        }
        return list;
    }
    private static int priority(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2;
            case '#':
                return 0;
            default:
                return 0;
        }
    }
    /**
     * 替换类
     * @author YuJing
     */
    public static class Replace {
        String data;
        public Replace(String data) {
            this.data = data;
        }
        public void put(String key, Object value) {
            data = data.replaceAll(key, value.toString());
        }
        public String toString() {
            return data;
        }
    }
    /**
     * 替换方法
     * @author Dm
     */
    /*public static String getItemAmount(String str){
        Pattern p = Pattern.compile("\\[(.*?)\\]");
        //String str = "[YS001]+[YS002]-[YS003]";
        Matcher m = p.matcher(str);
        while (m.find()) {
            // System.out.println(m.group(1));
            switch (m.group(1)){
                case "YS001":
                    str=str.replace("["+m.group(1)+"]","1");
                case "YS002":
                    str=str.replace("["+m.group(1)+"]","2");
                case "YS003":
                    str=str.replace("["+m.group(1)+"]","5");
                default:
                    str=str.replace("["+m.group(1)+"]","0");
            }
           *//* if(m.group(1).equals("[YS001]")){
                str=str.replace("["+m.group(1)+"]","2");
            }*//*
            str=str.replace("["+m.group(1)+"]","2");
            // System.out.println(str);
        }
        System.out.println(str);
        return str;
    }*/
    public static boolean isVaild(String expression){
        // 替换空白
        String temp = expression.replaceAll("\\s","");
        //String regex = "(\\d+[-+*/()])*\\d+";
        String regex = "[0-9\\.+-/*()={}]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(temp);
        boolean result = matcher.matches();
        if(result){
            System.out.println(expression + " is a valid match expression.");
        }else{
            System.out.println(expression + " is not a valid match expression.");
        }
        return result;
    }
    public static void main(String[] args) {
        String r = "(3+6)*1+2+{2+9}*2";
        if(isVaild(r)){
            System.out.println("计算结果：" + CalculationUtils.eval(r.toString()));
        }else{
            System.out.println("公式验证错误");
        }

    }

}
