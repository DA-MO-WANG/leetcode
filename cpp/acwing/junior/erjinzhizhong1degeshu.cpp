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

        while (x) x -= lowbit();
    }


    return 0;
}