class Solution {
    public String decodeString(String s) {
        
        Stack<Integer>      cnt = new Stack<Integer>();
        Stack<String>       str = new Stack<String>();
        StringBuilder       ret = new StringBuilder();
        int                 idx = -1;
        int                 tmp = 0;
        
        while( ++idx < s.length() )
        {
            char    c = s.charAt( idx );
            
            if( Character.isDigit( c ) )
            {
                tmp = tmp * 10 + (c - '0');
            }
            else if( c == '[' )
            {
                cnt.push( tmp );
                tmp = 0;

                str.push( ret.toString() );
                ret.setLength( 0 );
            }
            else if( c == ']' )
            {
                StringBuilder   sb  = new StringBuilder( str.pop() );
                int             rep = cnt.pop();
                
                for( int i = 0; i < rep; i++ )
                {
                    sb.append( ret );
                }
                ret = sb;
            }
            else
            {
                ret.append( c );
            }
        }
        
        return ret.toString();
        
        
        
    }
}