//
// Created by rich heart on 07/06/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
int n;
int gcd(int a, int b) {
    return b ? (b, a % b) : a;
}
int main() {
    cin >> n;
    while (n--) {
        int a, b;
        cin >> a >> b;
        int res = gcd(a,b);
        cout << res << endl;
    }
    return 0;
}