class WordDictionary {

    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr = root;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null) curr.children[c-'a'] = new TrieNode();
            curr = curr.children[c-'a'];
        }
        curr.isWord = true;    
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        return dfs(word, curr, 0);
    }
    
    public boolean dfs(String word, TrieNode curr, int idx){
        if(curr == null) return false;
        if(idx == word.length() && curr.isWord) return true;
        if(idx == word.length()) return false;
        
        boolean isFound = false;
        char c = word.charAt(idx);
        if(c != '.') isFound = dfs(word, curr.children[c-'a'], idx+1);
        else{
            for(int i=0; i<26; i++){
                isFound = isFound | dfs(word, curr.children[i], idx+1);
            }
        }
        
        return isFound;
        
    }
}

class TrieNode{
    public TrieNode[] children;
    public boolean isWord;
    
    public TrieNode(){
        this.children = new TrieNode[26];
        this.isWord = false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */