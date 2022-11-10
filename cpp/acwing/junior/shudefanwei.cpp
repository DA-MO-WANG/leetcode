//
// Created by rich heart on 10/11/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
const int N = 1e5 + 10;
int q[N], query, n;



int main() {
    //处理输入
    scanf("%d%d",&n,&query);
    for (int i = 0; i < n; ++i) {
        scanf("%d",q + i);
    }


    for (int j = 0; j < query; ++j) {
        int x;
        scanf("%d",&x);
        int l = 0, r = n - 1;
        //把lr区间内所有元素跑一遍

        //寻找<=x -last
        while(l < r) {
            int mid = (l + r) >> 1;
            if(q[mid] <= x) {
                l = mid;
            }else r = mid - 1;
        }
        if(q[l] != x) cout << "-1 -1";
        else {
            cout << l << " ";
            int l1 = 0, r1 = n - 1;
            while(l1 < r1) {
                int mid
            }
        }



    }
    return 0;
}