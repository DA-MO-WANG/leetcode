//
// Created by rich heart on 05/06/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;
int n;
vector<int> yueshu(int n) {
    //直接打印法
    vector<int> res;
    for (int i = 1; i <= n / i; ++i) {
        if(n % i == 0) {
            res.push_back(i);
            if(i != n / i) res.push_back(n/i);
        }
    }
    return res;
}
int main() {
    cin >> n;
    while(n--) {
        int a;
        cin >> a;
        vector<int> res = yueshu(a);

        sort(res.begin(),res.end());
        for (int i = 0; i < res.size(); ++i) {
            cout << res[i] <<" ";
        }
        cout << endl;



    }
    return 0;
}