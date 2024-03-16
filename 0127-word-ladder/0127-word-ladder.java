class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        HashSet<String> wordSet = new HashSet<String>(wordList);
        HashMap<String, LinkedList<String>> adjlist = new HashMap();
        
        
        StringBuilder wordBuilder = new StringBuilder(beginWord);
        for(int i=0; i<beginWord.length(); i++){
                for(char c = 'a'; c <= 'z'; c++){
                    StringBuilder temp = new StringBuilder(wordBuilder);
                    temp.setCharAt(i,c);
                    if(temp.toString().equals(beginWord)) continue;
                    if(wordSet.contains(temp.toString())){

                        adjlist.computeIfAbsent(beginWord, k -> new LinkedList<String>()).add(temp.toString());
                    }
                }     
        }
        
        for(String word : wordList){
            wordBuilder = new StringBuilder(word);
            
            for(int i=0; i<word.length(); i++){
                
                for(char c = 'a'; c <= 'z'; c++){
                    StringBuilder temp = new StringBuilder(wordBuilder);
                    temp.setCharAt(i,c);
                    if(temp.toString().equals(word)) continue;
                    if(wordSet.contains(temp.toString())){
                        adjlist.computeIfAbsent(word, k -> new LinkedList<String>()).add(temp.toString());
                    }
                }
                
            }
           
        }
        
        // for(String key : adjlist.keySet()){
        //     System.out.println(key);
        //     System.out.println(Arrays.asList(adjlist.get(key)));
        //     System.out.println();
        // }
        
        return bfs(adjlist, beginWord, endWord);        
        
    }
    
    public int bfs(HashMap<String, LinkedList<String>> adjlist, String beginWord, String endWord){
        int count = 0;
        
        Deque<String> queue = new ArrayDeque();
        queue.offer(beginWord);
        HashSet<String> visited = new HashSet();
        
        while(queue.size() > 0){
            int size = queue.size();
            count++;
            System.out.println(count);
            for(int i=1; i<=size; i++){
                String curr = queue.poll();
                visited.add(curr);
                System.out.println(curr);
                if(curr.equals(endWord)) return count;
                
                if(!adjlist.containsKey(curr)) continue;
                
                for(String nextword : adjlist.get(curr)){
                    if(!visited.contains(nextword)){
                        queue.offer(nextword);
                    }    
                }
            }
        }
        
        return 0;
        
        
    }
}

/*

["hot","dot","dog","lot","log","cog"]

bword = hit
eword = cog
  
                                  *
                        h     d      l      c
                       o      o      o      o
                      t     t   g  t   g    g
                      

     
*/