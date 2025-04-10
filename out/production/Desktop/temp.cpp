class Solution {
    public:

        bool cntFr(vector<int>& nums, int n){
            int cnt = 0;
            for(auto &it : nums){
                if(it == n) cnt += 1;
            }
            return (cnt * 3) > nums.size();
        }

        vector<int> majorityElement(vector<int>& nums) {
            int mj1, mj2;
            int cnt1 = 0, cnt2 = 0;
            for(auto &it : nums){
                if(cnt1 == 0){
                    mj1 = it;
                    cnt1 = 1;
                }
                else if(it == mj1) cnt1 += 1;
                else if(cnt2 == 0){
                    mj2 = it;
                    cnt2 = 1;
                }
                else if(mj2 == it) cnt2 += 1;
                else if(it != mj1 && it != mj2){
                    cnt1 -= 1;
                    cnt2 -= 1;
                }
            }

            vector<int> ans;
            if(cntFr(nums, mj1)) ans.push_back(mj1);
            if(cntFr(nums, mj2)) ans.push_back(mj2);

            return ans;
        }
    };