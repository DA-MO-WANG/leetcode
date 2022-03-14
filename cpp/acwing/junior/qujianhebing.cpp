//
// Created by rich heart on 3/14/22.
//
#include <iostream>
#include <algorithm>
#include <vector>
//维护一个当前区间：从最初的边界点开始
//逐步遍历所给的区间，
//有交集的话，求并集
//没交集的话，就得到一个答案--放到呈放答案的篮子里
using namespace std;
typedef pair<int, int> pii;
vector<pii> query;
vector<int> segs;
vector<pii> merge(vector<int> &segs) {
    int st = -2e9, ed = -2e9;
    vector<pii> res;
    sort(query.begin(),query.end());
    for(auto item : query) {
        if(ed < item.first) {
            //没有交集，替换掉
            res.push_back({st,ed});
            st = item.first, ed = item.second;

        }else {
            ed = max(ed,item.second);
        }
    }

    if(ed == -2e9) {
        res.push_back({st,ed});
    }
    return res;
}
int n;
int main() {
    cin >> n;
    for(int i = 0; i < n; i++) {
        int l, r;
        cin >> l >> r;
        query.push_back({l,r});
    }
    vector<pii> res = merge(segs);
    cout << res.size() << endl;






}
