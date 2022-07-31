//
// Created by rich heart on 31/07/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>
//要求：控制多余空间，争取O1
using namespace std;
string replaceSpaces(string &str) {
    int len = 0;
    //先计算新字符串的新长度-->计算空格的数量
    while(str[i]) {
        if(str[i] == ' ') {
            len += 3;
        }else {
            len++;
        }
    }
    //重新分配新长度大小的空间
    //resize()方法是字符的长度，尾部会自动补\0
    str.resize(len);


    //从后往前遍历，填充，同时替换
    int i = str.size() - 1;
    int j = len - 1;
    for (int i = str.size() - 1; i >= 0; i--) {
        if(str[i] == ' ') {
            str[j--] = '0';
            str[j--] = '2';
            str[j--] = '%';
        }esle {
            str[j--] = str[i];
        };
    }
    return str;
}
int main() {

    return 0;
}