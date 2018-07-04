package com.deecheng.helloworld; /* Added by Eclipse.py */


class Fig02_12
{
    public static int gcd( int m, int n )
    {
        if( m < n )
            return gcd( n, m );
        if( n == 0 )
            return m;
        return gcd( n, m % n );
    }
    
    public static double probRelPrime( int n )
    {
        int rel = 0, tot = 0;
        
        for( int i = 1; i <= n; i++ )
            for( int j = i + 1; j <= n; j++ )
            {
                tot++;
                
                if( gcd( i, j ) == 1 )
                    rel++;
            }
        
        return (double) rel / tot;
    }
    
    public static void main( String [ ] args )
    {
        for( int n = 500; n <= 64000; n *= 2 )
        {
            
            long start = System.currentTimeMillis( );
            double prob = probRelPrime( n );
            long end = System.currentTimeMillis( );
            
            if( n == 500 )
                continue;
            
            long elapsed = ( end - start );
            
            System.out.print( String.format( "%4d", n ) );

            System.out.print( String.format( "\t%d", elapsed ) );
            
            System.out.print( String.format( "\t%.9f", elapsed / (double) n / n ) );
            System.out.print( String.format( "\t%.12f", elapsed / (double) n / n / n ) );
            System.out.print( String.format( "\t%.9f", elapsed / (double) n / n / ( Math.log10( n ) / Math.log10( 2 ) ) ) );
          
            System.out.println( );
            
           // if( n >= 10000 )
           //     n += 4000;
        }
    }
    
}


/* Output:
1000	99	0.000099000	0.000000099000	0.000009934
2000	302	0.000075500	0.000000037750	0.000006885
4000	926	0.000057875	0.000000014469	0.000004837
8000	3181	0.000049703	0.000000006213	0.000003833
16000	12605	0.000049238	0.000000003077	0.000003526
32000	53836	0.000052574	0.000000001643	0.000003513
64000	235541	0.000057505	0.000000000899	0.000003602
*///:~