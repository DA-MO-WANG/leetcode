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
PII p[N];
int main() {
    cin >> n;
    for (int i = 0; i < ; ++i) {
        int w, int s;
        cin >> w >> s;
        p[i] = {w + s,s};
    }
    sort(ws,ws + n);
    //第一个值的风险值为0 - s1
    int res = -2e9, sum = 0;
    for (int i = 0; i < n; ++i) {
        int s = p[i].second;
        int w = p[i].first - s;
        //最后记录风险值的最大值
        res = max(res,sum - s);
        //只要在相加之前，sum就记录的是上一个的和
        sum += w;
    }
    cout << res << endl;
    return 0;
}