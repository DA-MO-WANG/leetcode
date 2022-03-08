//
// Created by rich heart on 3/8/22.
//
#include <iostream>
#include <cstdio>
#include <algorithm>

using namespace std;


int main() {
    int n;
    cin >> n;

    while(n--) {
        int x;
        cin >> x;
        int res = 0;
        while (x) x -= lowbit(x), res++;
    }


    return 0;
}
