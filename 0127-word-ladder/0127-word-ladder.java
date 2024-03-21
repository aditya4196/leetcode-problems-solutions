class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Map<String, List<String>> adjlist = new HashMap();
        Set<String> wordSet = new HashSet<String>(wordList);

        for(String word : wordList){
            for(int i=0; i<word.length(); i++){
                for(char c = 'a'; c<='z'; c++){
                    String newWord = word.substring(0,i) + String.valueOf(c) + word.substring(i+1);
                    if(wordSet.contains(newWord)){
                        adjlist.computeIfAbsent(word, k -> new ArrayList<String>()).add(newWord);
                    }
                }
            }
        }

        //handle begin word
        for(int i=0; i<beginWord.length(); i++){
            for(char c = 'a'; c<='z'; c++){
                String newWord = beginWord.substring(0,i) + String.valueOf(c) + beginWord.substring(i+1);
                if(wordSet.contains(newWord)){
                    adjlist.computeIfAbsent(beginWord, k-> new ArrayList<String>()).add(newWord);
                }
            }
        }

        //bfs over adjlist
        Deque<String> queue = new LinkedList();
        int dist = 1;
        queue.offer(beginWord);
        Set<String> visited = new HashSet<String>();

        while(queue.size() > 0){
            int size = queue.size();

            for(int i=1; i<=size; i++){
                String curr = queue.poll();
                if(curr.equals(endWord)) return dist;
                visited.add(curr);

                for(String nextWord : adjlist.get(curr)){
                    if(!visited.contains(nextWord)){
                        queue.offer(nextWord);
                    }
                }
            }
            dist++;
        }

        return 0;


        
    }
}