class Solution {
    
    TrieNode root;
    
    public List<String> findWords(char[][] board, String[] words) {
        
        root = new TrieNode();
        List<String> result = new ArrayList<String>();        
        for(var word : words) insertWord(root, word);  

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                dfs(board, i, j, root, result);
            }
        }    
        return result;
    }
     
    public void dfs(char[][] board, int i, int j, TrieNode root, List<String> result){
        if(i<0 || j<0 || i>=board.length || j>=board[0].length) return;
        
        char c = board[i][j];
        if(c == '*' || root.children[c-'a'] == null) return;
        
        if(root.children[c-'a'].word != null){
            result.add(root.children[c-'a'].word);
            root.children[c-'a'].word = null;
        }
        
        board[i][j] = '*';
        dfs(board, i-1, j, root.children[c-'a'],result);
        dfs(board, i+1, j, root.children[c-'a'],result);
        dfs(board, i, j-1, root.children[c-'a'],result);
        dfs(board, i, j+1, root.children[c-'a'],result);
        board[i][j] = c;
        
    } 
    
    public void insertWord(TrieNode curr, String word){
        for(var c : word.toCharArray()){
            if(curr.children[c-'a'] == null) curr.children[c-'a'] = new TrieNode();
            curr = curr.children[c-'a'];
        }
        curr.isWord = true;
        curr.word = word;
    }
}

class TrieNode{
    TrieNode[] children;
    boolean isWord;
    String word;

    public TrieNode(){
        this.children = new TrieNode[26];
        this.isWord = false;
        this.word = null;
    }
}