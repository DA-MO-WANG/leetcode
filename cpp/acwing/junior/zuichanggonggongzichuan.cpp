//
// Created by rich heart on 04/07/2022.
//

#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;
const int N = 200;
string str[N];
int n;
int main()
{
    //思路：枚举
    //第一重循环：枚举后缀的长度：从大到小，直到满足后缀都相等==>
        //==>假设最好情况下的后缀都相等，然后验证一下，不符就往下撸
    //第二重循环：枚举输入的字符串，每一个字符串都要和第一个字符串相等,在后缀范围内：每个人字符串-字符串的每个后缀字符
    //第三：倒着验证len个字符，只要有不想等的就不满足
    while(cin >> n, n) {
        //输入数和字符串正好交错开

        //找到输入字符串的最大长度
        int len = 1000;

        for (int i = 0; i < n; i ++ ) {
            cin >> str[i];
            if(len > str[i].size()) {
                len = str[i].size();
            }
        }
        //符合条件的后缀长度的可能
        //bool success = true;
        while(len >= 0) {
            bool success = true;//由flag来决定
            for(int i = 0; i < n; i++) {
                bool flag = true;//难点1：每个标志的作用：只要有一个字符串不满足这个长度，这个长度就不用往下验证了，就可以推出
                //这个len不合格
                for(int j = 1; j <= len; j++) {
                    if(str[0][str[0].size() - j] != str[i][str[i].size() - j]) {
                        flag = false;
                        break;
                    }
                }
                if(!flag) {
                    success = false;
                    break;
                }


            }
            if(success) {
                break;
            }else {
                len--;
            }
        }
        cout << str[0].substr(str[0].size() - len) << endl;
    }



}