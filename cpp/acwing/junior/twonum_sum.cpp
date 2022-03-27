//
// Created by rich heart on 3/27/22.
//
#include <iostream>
#include <cstdio>
#include <algorithm>
#include <cmath>
#include <cstring>
using namespace std;
vector<int> a, b, c;
int res[2];
int main() {
    int n, m, x;
    cin >> n >> m >> x;

    while(n--) {
        int v = 0;
        cin >> v;
        a.push_back(v);
    }
    while(m--) {
        int v = 0;
        cin >> v;
        b.push_back(v);
    }
    int i = 0, j = b.size() - 1;
    while(j >= 0 && i < a.size()) {
        if(a[i] + b[j] > x) {
            j--;
        }else if(a[i] + b[j] == x) {
            res[0] = i, res[1] = j;
            break;
        }else {
            i++;
        }

    }

    cout << res[0] << " " << res[1] << endl;
}



