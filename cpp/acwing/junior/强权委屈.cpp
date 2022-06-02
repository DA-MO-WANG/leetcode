//
// Created by rich heart on 6/2/22.
//
#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 100010 * 2;
int e[N], ne[N], idx;//邻接表存储图
int h[N];
int color[N];//保存各个点的颜色，0 未染色，1 是红色，2 是黑色
int n, m;//点和边

void add(int a, int b)//邻接表插入点和边
{
    e[idx] = b, ne[idx]= h[a], h[a] = idx++;
}

bool dfs(int u, int c)//深度优先遍历
{
    color[u] = c;//u的点成 c 染色

    //遍历和 u 相邻的点
    for(int i = h[u]; i!= -1; i = ne[i])
    {
        int b = e[i];
        if(!color[b])//相邻的点没有颜色,则递归处理这个相邻点
        {
            if(!dfs(b, 3 - c)) return false;//（3 - 1 = 2， 如果 u 的颜色是2，则和 u 相邻的染成 1）
            //（3 - 2 = 1， 如果 u 的颜色是1，则和 u 相邻的染成 2）
        }
        else if(color[b] && color[b] != 3 - c)//如果已经染色，判断颜色是否为 3 - c
        {
            return false;//如果不是，说明冲突，返回
        }
    }
    return true;
}

int main()
{
    memset(h, -1, sizeof h);//初始化邻接表
    cin >> n >> m;
    for(int i = 1; i <= m; i++)//读入边
    {
        int a, b;
        cin >> a >> b;
        add(a, b), add(b, a);
    }
    for(int i = 1; i <= n; i++)//遍历点
    {
        if(!color[i])//如果没染色
        {
            if(!dfs(i, 1))//染色该点，并递归处理和它相邻的点
            {
                cout << "No" << endl;//出现矛盾，输出NO
                return 0;
            }

        }
    }
    cout << "Yes" << endl;//全部染色完成，没有矛盾，输出YES
    return 0;
}


作者：Hasity
        链接：https://www.acwing.com/solution/content/105874/
来源：AcWing
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
