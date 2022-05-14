//
// Created by rich heart on 5/14/22.
//
#include <algorithm>
#include <cstring>
#include <stack>
#include <iostream>
#include <unordered_map>

using namespace std;

int main() {
    
    //先声明下运算符的优先级
    unordered_map<char,int> pr{{'+',1},{'-',1},{'*',2},{'/',2}};
    string str;
    cin >> str;

    for (int i = 0; str[i]; ++i) {
        auto c = str[i];
        
    }
}
