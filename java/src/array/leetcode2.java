package array;

public class leetcode2 {
    //1
        //给我1个数，我用倒着展示，另一个数也是如此，然后我要得到两个数和的倒着展示
        //依托于链表这种结构
    //2业务梳理
        //最粗糙的思路：初等数学法则+链表特性结合
        //初等数学算法是从个位到高位依次相加，到进制进1---加的顺序正好对应链表的遍历顺序--错觉：人视觉最先展示的高位，而实际执行最先入手的确实低位
        //（这也是人的一个特性：人的毛病，有一条类似，看不破就染上眼高手低，眼高手低是有物理基础的）
        //为了模拟数学法则，还需要设计一个变量：储存进位值-carry
        //对这个进位值的理解：虽然每个位都可能会产生进位值，但这不代表进位值需要三个（这也是我理解的卡壳），因为进位值是和每个位都关联的，所以只需要让carry跟随每位的情况变化就行

        //代码设计
            //从低位遍历高位---选用while语法
            //carry初始为0，这样不会影响其他原本的效果
            //结果如何表示----从生成1个新链表开始，用next连接
            //从源到结果的转换---sum % 10-存储每位结果; sum /10--更新carry值
            //边界情况1：有进位-- 引入carry来解决
            //边界情况2：长度不一致，这个通过三目运算转化为值为0，在加法系统中不受影响
            //边界情况3：长度变长，高位还有进位----维护最后的carry，如果还有值，就生成创建






}
