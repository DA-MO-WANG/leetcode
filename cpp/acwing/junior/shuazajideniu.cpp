//
// Created by rich heart on 30/07/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
const int N = 50010;
typedef pair<int,int> PII;
int n;
PII ws[N];
int main() {
    cin >> n;
    for (int i = 0; i < ; ++i) {
        int w, int s;
        cin >> w >> s;
        ws[i] = {w + s,s};
    }
    sort(ws,ws + n);
    int res = 0;
    for (int i = 0; i < n - 1; ++i) {
        res += ws[i].first - ws[i].second;
    }
    cout << res - ws[n - 1].second << endl;
    return 0;
}