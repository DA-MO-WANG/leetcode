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
void dfs(int price, int num) {
    if(!price) {
        cout << path;
        return;
    }
    for (int i = 0; i < 3; ++i) {
        if(price && num) path.pushweight[i];
        dfs(price - weight[i],--num);
        path

    }
}
int m,n;
int main() {
    cin >> m >> n;
    dfs(m,n);
    return 0;
}