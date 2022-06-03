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
       int x = k / 3, y = k % 3;
        for (int i = 0; i < 4; ++i) {
            int kx = x + dx[i], ky = y + dy[i];
            if(kx >= 0 && kx < 3 && ky >= 0 && ky < 3) {
                swap(t[k],t[kx * 3 + ky]);
                if(!dis.count(t)) {
                    dis[t] = dis[t] + 1;
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