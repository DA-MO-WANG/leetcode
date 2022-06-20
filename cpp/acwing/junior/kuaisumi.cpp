//
// Created by rich heart on 20/06/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
int n;
typedef long long ll;
int qmi(int a, int b, int k) {
    int res = 1;
    while(k) {
        if(k & 1) res = res * a % k
    }
}
int main() {
    cin >> n;
    while(n--) {
        int a, b , k;
        scanf("%d%d%d",&a,&b,&k);
        printf("%d",qmi(a,b,k));
    }
    return 0;
}