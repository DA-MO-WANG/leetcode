//
// Created by rich heart on 5/14/22.
//
#include <algorithm>
#include <cstring>
#include <stack>
#include <iostream>
#include <unordered_map>

using namespace std;
stack<int> num;
stack<char> op;
//操作最后一个运算符
//最后一个数是倒数第二个数，翻过来写
void eval() {
    auto b = num.top(); num.pop();
    auto a = num.top(); num.pop();
    auto c = op.top(); op.pop();
    int x;
    if( c == '+') x = a + b;
    else if (c == '-') x = a - b;
    else if (c == '*') x = a * b;
    else x = a / b;
    num.push(x);

}
int main() {
    
    //先声明下运算符的优先级
    unordered_map<char,int> pr{{'+',1},{'-',1},{'*',2},{'/',2}};
    string str;
    cin >> str;

    for (int i = 0; str[i]; ++i) {
        auto c = str[i];
        //当前字符是数字
        if (isdigit(c)) {
            int x = 0, j = i;
            //考虑连续数字，多位数，多位数字符串转化成int类型数
            while(j < str.size() && isdigit(str[j]))
                x = x * 10 + str[j++] - '0';
            i = j - 1;
            num.push(x);

        }
        else if (c == '(') op.push(c);
        else if (c == ')') {
            //把栈里的数都拿出来操作一下
            //eval 用末尾的操作符，操作末尾的两个数
            while(op.top() != '(') eval();
            //弹出'（'
            op.pop();
        }
        //普通运算符的情况
        else {
            //如果运算符栈是空的，且运算符栈顶的优先级> 当前运算符的优先级
            while(op.size() && pr[op.top()] >= pr[c]) eval();//操作下栈顶元素
            op.push(c);
        }

    }
    //把没有操作过的运算符从右往左操作一遍
    while(op.size()) eval();
    cout << num.top() <<endl;
    return 0;
}
