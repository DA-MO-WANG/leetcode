//
// Created by rich heart on 09/07/2022.
//

class Solution {
public:
    //准备一个存放最终结果的结构
    vector<vector<int>> ans;
    //准备一个存放一种方案情况
    vector<int> path;
    vector<vector<int>> permutation(vector<int>& nums) {
        //设计几个关键变量，为了达成一定目的
        //u==>记录使用了几个数
        //start==>记录上一个相同的数存放的位置
        //state==>用来记录当前位置上的空缺信息
        dfs(nums,0,0,0);
    }
    void dfs(int )
};