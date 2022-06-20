//
// Created by rich heart on 20/06/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
int n;
typedef long long ll;
int qmi(int a, int k, int p) {
    int res = 1;
    while(k) {
        if(k & 1) res = res * a % k;
        k >>= 1;
        a = a * a;
    }
    return res;
}
int main() {
    cin >> n;
    while(n--) {
        int a, k , p;
        scanf("%d%d%d",&a,&k,&p);
        printf("%d",qmi(a,k,p));
    }
    return 0;
}