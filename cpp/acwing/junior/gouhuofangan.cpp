//
// Created by rich heart on 08/08/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
int weight[3] = {2,3,5};
vector<int> path;
vector<vector<int>> res;
void dfs(int price, int num) {
    if(!price) {
        res.push_back(path);
        return;
    }
    for (int i = 0; i < 3; ++i) {
        if(price && num) path.push_back(weight[i]);
        dfs(price - weight[i],--num);
        path.pop_back();

    }
}
int m,n;
int main() {
    cin >> m >> n;
    dfs(m,n);
    //处理res结果
    return 0;
}