//
// Created by rich heart on 3/27/22.
//
#include <iostream>
#include <cstring>
#include <cmath>

using namespace std;
const int N = 1e5 + 10;
int a[N],b[N];
int n, m;
int main() {
    cin >> n >> m;
    for(int i = 0; i < n; i++) {
        scanf("%d",a+i);
    }
    for(int j = 0; j < m; j++) {
        scanf("%d",b+j);
    }
    int j = 0;
    for(int i = 0; i < m && j < n;i++) {
        if(b[i] == a[j]) {
            j++;
        }
    }
    if(j == n) {
        cout << "Yes" << endl;
    }else {
        cout << "No" << endl;
    }

}
