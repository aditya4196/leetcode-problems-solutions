class Solution {
    public String simplifyPath(String path) {
        
        String[] tokens = path.split("/");
        Stack<String> stack = new Stack();
        
        for(String token : tokens){
            if(token.equals("..")){
               if(!stack.isEmpty())stack.pop();
            }
            else if(!token.isEmpty() && !token.equals(".")){
                stack.push(token);
            }
        }
        
        StringBuilder canonicalpath = new StringBuilder();
        
        
        for(String token : stack){
            if(token.charAt(0) != '/'){
                canonicalpath.append('/');
            }
            canonicalpath.append(token);
        }
        
        return (canonicalpath.isEmpty())?"/":canonicalpath.toString();
        
        
    }
}

/*


/home//foo/

home
/foo


*/