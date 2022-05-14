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
            while(j < str.size() && isdigit(str[j])) x = x * 10 + str[j++] - '0';
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

    }
}
