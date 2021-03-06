package array;

public class leetcode7 {
    //审题
    //把数字翻转，然后输出
    //限制条件：翻转后不能超出有符号32位的界限
    //环境中不能出现64位数

    //业务理解
    //80%主体思路：从尾部到首部弹出每一位，然后依次押入结果--不用额外的栈
    //弹出--用digit = x%10--余数原理 ； 押入--用rev = rev * 10 + digit---多项式展开原理

    //20%：难点在如何在不借助64位的情况下，识别什么时候出现32位
    //直接用rev< int.maxvalue ，不能保证rev*10 + digit --所以不行
    //用rev * 10 + digit < maxvalue ---也不行，因为还是可能会出现溢出--得借助数学乘除法和计算机乘除法的转换
    //数学[ x ➗ 10]先除法，再取整 --- 计算机： x/10---借助这个特性把不等式化简到 rev

}
