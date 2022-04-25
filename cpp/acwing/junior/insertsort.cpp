//
// Created by rich heart on 4/25/22.
//
#include <algorithm>
#include <cstring>
#include <iostream>

int q[10];

void swap(int i, int j);

void insertSort(int m) {
    for (int i = 1; i < m; ++i) {
        int j = i - 1;
        while (j >= 0 && q[i] < q[j]) {
            swap(i,j);
            j--;
        }
    }
}

void swap(int i, int j) {
    int temp = q[i];
    q[i] = q[j];
    q[j] = temp;
}

using namespace std;

int main() {
    int m = 0;
    cin >> m;
    for (int i = 0; i < m; ++i) {
        cin >> q[i];
    }
    insertSort(m);
    for (int j = 0; j < m; ++j) {
        cout << q[j] << " ";

    }


}
