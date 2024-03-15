class Solution {
    
    TrieNode root;
    String maxString;
    int maxLength;
    
    public Solution(){
        this.root = new TrieNode();
        maxString = "";
        maxLength = 0;
    }
    
    
    public String longestWord(String[] words) {
        for(String word : words){
            addWord(word);
        }
        for(int i=0; i<26; i++){
            traverse(root.children[i], 0);
        }
        return maxString;
    }
    
    public void traverse(TrieNode curr, int prevCount){
        if(curr == null || !curr.isWord) return;

        if(curr.count == (prevCount+1)){
            if(maxLength < curr.count){
                maxLength = curr.count;
                maxString = curr.word;
            }
        }
        for(int i=0; i<26; i++){
            traverse(curr.children[i], curr.count);
        }
    }
    

    public void addWord(String word){
        TrieNode curr = root;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null) curr.children[c-'a'] = new TrieNode();
            curr = curr.children[c-'a'];
        }
        curr.isWord = true;
        curr.word = word;
        curr.count = word.length();
    }
}       

class TrieNode{
    public TrieNode[] children;
    public boolean isWord;
    public int count;
    public String word;
    
    public TrieNode(){
        this.children = new TrieNode[26];
        this.isWord = false;
        this.count = 0;
        this.word = new String();
    }
}

/*

                        *
                        w(t)
                        o(t)
                        r(t)
                        l(t)
                        d(t)



*/