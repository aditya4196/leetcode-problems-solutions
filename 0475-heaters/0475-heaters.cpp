class Solution {
public:
    bool isPossible(int radius,vector<int>& houses,vector<int>& heaters){
        int n=houses.size(),m=heaters.size(),i=0,j=0;
        while(i<n && j<m){
            int low=heaters[j]-radius,high=heaters[j]+radius;
            while(i<n && houses[i]>=low && houses[i]<=high){
                i++;
            }
            j++;
        }
        if(i==n){
            return true;
        }
        return false;
    }
    int findRadius(vector<int>& houses, vector<int>& heaters) {
        sort(houses.begin(),houses.end());
        sort(heaters.begin(),heaters.end());
        int i=0,j=1e9+1,ans=-1;
        while(i<=j){
            int mid=(i+j)/2;
            if(isPossible(mid,houses,heaters)){
                ans=mid;
                j=mid-1;
            }else{
                i=mid+1;
            }
        }
        return ans;
    }
};