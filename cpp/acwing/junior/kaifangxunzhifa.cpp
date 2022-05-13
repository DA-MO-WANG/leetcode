//
// Created by rich heart on 5/13/22.
//
#include <algorithm>
#include <cstring>
#include <iostream>

using namespace std;
//开槽，开到2-3倍，防止find时死循环
const int N = 2e5 + 3;
int h[N], null = 0x3f3f3f;
int hashx(int x) {
    return ((x % N) + N) % N;
}
int find(int x) {
    int k = hashx(x);
    while(h[k] != null && h[k] != x) {
        k++;
        if(k == N) {
            k = 0;
        }
    }
    return k;
}
int main() {
    int n;
    cin >> n;
    while(n--) {
        string s;
        cin >> s;
        if(s == "I") {
            int x;
            cin >> x;
            int k = find(x);
            h[k] = x;
        }else if(s == "Q") {
            int x;
            cin >> x;
            cout << (h[find(x)] == null ? "No" : "Yes");
        }
    }


}
