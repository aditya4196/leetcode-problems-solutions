class Solution {
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        DSU dsu = new DSU(accounts.size());
        Map<String, Integer> emailMap = new HashMap();
        
        
        for(int i=0; i<accounts.size(); i++){
           List<String> account = accounts.get(i);
            
            for(int j=1; j<account.size(); j++){
                String email = account.get(j);
                
                if(!emailMap.containsKey(email)){
                    emailMap.put(email, i);
                }
                else{
                    dsu.unionBySize(i, emailMap.get(email));    
                }
                
            }
        }
        
        
        Map<Integer, List<String>> components = new HashMap();
        
        for(String email : emailMap.keySet()){
            int group = emailMap.get(email);
            int grouprep = dsu.findRep(group);
            components.computeIfAbsent(grouprep, k -> new ArrayList<String>()).add(email);
        }
        
        List<List<String>> result = new ArrayList();
        
        for(int group : components.keySet()){
            List<String> emails = components.get(group);
            Collections.sort(emails);
            
            emails.add(0, accounts.get(group).get(0));
            result.add(emails);
        }
        
        return result;
                
    }
}

class DSU{
    int[] size;
    int[] rep;
    
    public DSU(int n){
        size = new int[n];
        rep = new int[n];
        
        for(int i=0; i<n; i++){
            size[i] = 1;
            rep[i] = i;
        }
    }
    
    public int findRep(int x){
        if(x == rep[x]) return x;
        else return findRep(rep[x]);
    }
    
    public void unionBySize(int x, int y){
        
        int repx = findRep(x);
        int repy = findRep(y);
        
        if(repx == repy) return;
        
        if(size[repx] >= size[repy]){
            size[repx] += size[repy];
            rep[repy] = repx;
        }
        else{
            size[repy] += size[repx];
            rep[repx] = repy;
        }
    }
}