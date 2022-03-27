//
// Created by rich heart on 3/27/22.
//
#include <iostream>
#include <cstdio>
#include <algorithm>
#include <cmath>
#include <cstring>
const int N = 1e9 + 10;
using namespace std;
char a[N],b[N];
int res[2];

int main() {
    int n, m, x;
    cin >> n >> m >> x;

    while(n--) {
        scanf("%c",a);
    }
    while(m--) {
        scanf("%c",b);
    }
    int i = 0, j = strlen(b) - 1;
    while(j >= 0 && i < strlen(a)) {
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



