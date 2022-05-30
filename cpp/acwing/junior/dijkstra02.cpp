//
// Created by rich heart on 5/30/22.
//

#include <algorithm>
#include <cstring>
#include <iostream>

using namespace std;
const int N = 510, M = 10010,INF = 0x3f3f3f3f;
//单源
//正权
//有向图
//稠密图——》邻接矩阵，来表示边
int n,m;
int g[N][N];
int dis[N];
bool str[N];
int dijkstra() {
    memset(dis,0x3f,sizeof dis);
    dis[1] = 0;
    //循环n次，每次确定一个最短距离的节点
    for (int i = 1; i <= n; ++i) {
        int t = -1;//类似选择排序的思路，先假设一个最短距离
        //选出到起点最短距离的点
        //这里涉及y总的代码技巧
        for (int j = 1; j <= n; ++j) {
            //虽然循环n次，但具体执行什么判断，选择那些点，可以在if上做
            //只在未确定中做，所以排除已确定，而是否确定用布尔数组表示

            //j = 1 ==》也就是在第一轮循环时，做的就是让起点去更新其他点的值；也就是让点1来确定下来（内部循环的if条件只生效了1次）
            //下一次外层循环，在第二个确定的点时，
                // j=1,的if是不走的，目的就是跳过已经确定的点
                // t跳过初始-1,是在排除完已确定之后，第一步做的：t = 未确定的第一个点
                // 正式的比较，是在排除完已确定之后，第二步做的，t更新完第一个点之后做的
            if(!str[j] && (t == -1 || dis[t] > dis[j])) t = j;
        }

        str[t] = true;
        if(t == n) break;//一种优化，提前拿到目标，就可以提前退出

        //用新确定的点去更新其他未确定的点
        //外边遍历n次，但真正执行更新操作是看条件的：排除掉已经确定的
        for (int k = 1; k <= n ; ++k) {
            if(!str[k]) dis[k] = min(dis[k],dis[t] + g[t][k]);
        }
    }

    if(dis[n] == INF) return -1;
    else return dis[n];
}
int main() {
    scanf("%d%d",&n,&m);
    memset(g,0x3f,sizeof g);
    while (m--) {
        int x, y , z;
        scanf("%d%d%d",&x,&y,&z);

        //重边
        //自环——》在正权图中不用管
        g[x][y] = min(g[x][y],z);
    }
    int res = dijkstra();
    if(res == -1) printf("-1");
    else printf("%d",dis[n]);









}
