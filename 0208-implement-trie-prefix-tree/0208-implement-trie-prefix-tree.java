class Trie {

    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(curr.getChildren(c) == null) curr.setChildren(c);
            curr = curr.getChildren(c);
        }
        curr.setIsWord(true);
    }
    
    public TrieNode getEndNode(String word){
        TrieNode curr = root;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(curr.getChildren(c) == null) return null;
            else curr = curr.getChildren(c);
        }
        return curr;
    }
    
    public boolean search(String word) {
        TrieNode endNode = getEndNode(word);
        return (endNode != null && endNode.getIsWord());
    }
    
    public boolean startsWith(String prefix) {
        TrieNode endNode = getEndNode(prefix);
        return endNode != null;
    }
}

class TrieNode{
    private TrieNode[] children;
    private boolean isWord;
    
    public TrieNode(){
        this.children = new TrieNode[26];
        this.isWord = false;
    }
    
    public TrieNode getChildren(char c){
        return this.children[c-'a'];
    }
    
    public void setChildren(char c){
        this.children[c-'a'] = new TrieNode();
    }
    
    public boolean getIsWord(){
        return isWord;
    }
    
    public void setIsWord(boolean value){
        isWord = value;
    }
    
    
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */