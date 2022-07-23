//
// Created by rich heart on 23/07/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
const int N =35;
int l, r, k, b;
int f[N][N];
//预处理一些组合数
void init() {
    for (int i = 1; i <= r; ++i) {
        for (int j = 0; j <= i; ++j) {
            if(!j) f[i][j] = 1;
            else f[i][j] = f[i - 1][j - 1] + f[i - 1][j];
        }
    }
}
//树状思路的过程
//返回的是0-n中满足条件的数量
int dp(int n) {
    if(!n) return 0;

    //拿出n的每一位
    vector<int> nums;
    while(n) nums.push_back(n % b), n /= b;

    //两个辅助的变量
    int res = 0;//记录结果
    int last = 0;//记录上面层次所占用的1的个数
    //处理每一位
    for (int i = nums.size() - 1; i >= 0 ; i--) {
        int x = nums[i];
        if(x) {
            //这一位可以填0，不填1
            res += f[i][k - last];
            if(x > 1) {
                //x大于1才可以，使这一位可以填1（才可以选这种可能）
                if(k - last - 1 >= 0) res += f[i][k - last - 1];
                
            }else {
                //x本身=1
                last++;

            }
        }
        if(!i && k == last) res++;

    }
}
int main() {
    cin >> l >> r;
    cin >> k >> b;
    init();

    int res = dp(r) - dp(l - 1);
    cout << res << endl;
    return 0;
}