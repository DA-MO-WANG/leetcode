//
// Created by rich heart on 3/27/22.
//
#include <iostream>
#include <cstdio>
#include <algorithm>
#include <cmath>
const int N = 1e9 + 10;
using namespace std;
int a[N],b[N],res[2];

int main() {
    int n, m, x;
    cin >> n >> m >> x;

    while(n--) {
         scanf('%s',a);
    }
    while(m--) {
        scanf('%s',b);
    }
    int i = 0, j = b.size() - 1;
    while(1) {
        if(a[i] + b[j] > x) {
            j--;
        }else if(a[i] + b[j] == x) {
            res[0] = i, res[1] = j;
        }else {
            i++;
        }

    }

    cout << res[0] << " " << res[1] << endl;
}



