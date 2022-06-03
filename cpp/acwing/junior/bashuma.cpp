#include <algorithm>
#include <iostream>
#include <cstring>
#include <queue>
#include <unordered_map>

using namespace std;

int bfs(string start) {

    string end = "12345678x";
    queue<string> q;
    unordered_map<string,int> dis;

    q.push(start);
    dis[start] = 0;

    int dx[4] = {-1,1,0,0}, dy[4] = {0,0,-1,1};
    while(q.size()) {
       auto t = q.front();
       q.pop();
       if(t == end) return dis[t];
       int k = t.find("x");
       int distance = dis[t];
       int x = k / 3, y = k % 3;
        for (int i = 0; i < 4; ++i) {
            int kx = x + dx[i], ky = y + dy[i];
            if(kx >= 0 && kx < 3 && ky >= 0 && ky < 3) {//越界判断不能忘，有些变换并不是合法的
                swap(t[k],t[kx * 3 + ky]);
                if(!dis.count(t)) {
                    dis[t] = distance + 1;//在上一个状态的距离下再更新
                    q.push(t);
                }
                swap(t[k],t[kx * 3 + ky]);
            }

        }
    }
    return -1;




}
int main() {
    //处理输入
    string start;
    for (int i = 0; i < 9; ++i) {
        char c;
        cin >> c;
        start += c;
    }

    //
    cout << bfs(start);




}