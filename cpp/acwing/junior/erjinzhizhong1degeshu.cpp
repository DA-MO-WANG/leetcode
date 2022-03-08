//
// Created by rich heart on 3/8/22.
//
#include <iostream>
#include <cstdio>
#include <algorithm>

using namespace std;
//知识点：位运算
//

int main() {
    int n;
    cin >> n;

    while(n--) {
        int x;
        cin >> x;
        int res = 0;
        while (x) x -= (x & -x), res++;
        cout << res << " ";

    }


    return 0;
}
