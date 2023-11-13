class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        
        vector<int> rv;
        stack<int> s;
        
        rv.resize(temperatures.size());
        
        for(int i=0; i<temperatures.size(); i++){
            while(s.size() && temperatures[i] > temperatures[s.top()]){
                rv[s.top()] = i - s.top();
                s.pop();
            }
            s.push(i);
        }
        
        return rv;
        
    }
};