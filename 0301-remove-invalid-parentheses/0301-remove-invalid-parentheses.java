class Solution {

  private Set<String> validExpressions = new HashSet<String>();

  private void recurse(
      String s,
      int index,
      int leftCount,
      int rightCount,
      StringBuilder expression) {

    if (index == s.length()) {

      if (leftCount == rightCount) {
          this.validExpressions.add(expression.toString());
        }
      }
      
      else {

      char currentCharacter = s.charAt(index);
      int length = expression.length();

      if (currentCharacter != '(' && currentCharacter != ')') {
        expression.append(currentCharacter);
        this.recurse(s, index + 1, leftCount, rightCount, expression);
        expression.deleteCharAt(length);
      } else {

        this.recurse(s, index + 1, leftCount, rightCount, expression);
        expression.append(currentCharacter);

        if (currentCharacter == '(') {
          this.recurse(s, index + 1, leftCount + 1, rightCount, expression);
        } else if (rightCount < leftCount) {

          this.recurse(s, index + 1, leftCount, rightCount + 1, expression);
        }

        // Undoing the append operation for other recursions.
        expression.deleteCharAt(length);
      }
    }
  }

  public List<String> removeInvalidParentheses(String s) {
      this.recurse(s, 0, 0, 0, new StringBuilder());
      
      int minLength = Integer.MIN_VALUE;
      
      for(String str : this.validExpressions){
          minLength = Math.max(minLength, str.length());
      }
      
      List<String> output = new ArrayList<String>();
      for(String str : this.validExpressions){
          if(minLength == str.length()){
              output.add(str);
          }
      }
      
      
      return output;
  }
}