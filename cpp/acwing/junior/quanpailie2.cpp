//
// Created by rich heart on 09/07/2022.
//
//难点
//1.这几个辅助变量的设计，是出于什么目的，才需要记录这些状态值
//2.需要那些特殊判断条件，为了不漏情况，分支处理--if怎么设计
class Solution {
public:
    //准备一个存放最终结果的结构
    vector<vector<int>> ans;
    //准备一个存放一种方案情况
    vector<int> path;
    vector<vector<int>> permutation(vector<int>& nums) {
        path.resize(nums.size());
        //为了让重复的数挨在一起，先排序处理
        sort(nums.begin(),nums.end());
        //设计几个关键变量，为了达成一定目的
        //u==>记录使用了几个数
        //start==>记录上一个相同的数存放的位置
        //state==>用来记录当前位置上的空缺信息
        dfs(nums,0,0,0);
        return ans;
    }
    void dfs(vector<int>& nums, int u, int start, int state) {
        if(u == nums.size()) {
            ans.push_back(path);
            return;
        }
        //特判，什么情况下，可以从前面的空缺开始找--不重不漏
        if(!u || nums[u] != nums[u - 1]) start = 0;
        for (int i = start; i < nums.size(); ++i) {
            //这里的判断，就是每次是从0开始检索是否有空位，还是从上一个相同的数放位置的后面检索
            //因为这里的i是start决定的
            if(!((state >> i) & 1)) {
                path[i] = nums[u];
                //原定是按相等情况，往上一个后面位置找空缺
                //但在for前面有特判，如果遇到不想等的情况，可以找上一个位置的前面的空缺
                //前面的空缺就是因为相同的只能往后面排，才可能产生的
                dfs(nums,u + 1, i + 1, state + (1 << i));
            }
        }
    }
};