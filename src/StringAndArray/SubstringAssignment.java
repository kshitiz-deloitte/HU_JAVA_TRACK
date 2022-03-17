package StringAndArray;

import java.util.*;
import java.lang.*;

class SubstringAssignment{
    
    static boolean isShuffle(String s1, String s2,
                             String s3)
    {

        int M = s1.length(), N = s2.length();
        boolean bool[][] = new boolean[M + 1][N + 1];
        if ((M + N) != s3.length())
            return false;

        for(int i = 0; i <= M; i++)
        {
            for(int j = 0; j <= N; j++)
            {

                // Two empty strings have an
                // empty strings as interleaving
                if (i == 0 && j == 0)
                    bool[i][j] = true;

                else if (i == 0)
                {
                    if (s2.charAt(j - 1) ==
                            s3.charAt(j - 1))
                        bool[i][j] = bool[i][j - 1];
                }

                else if (j == 0)
                {
                    if (s1.charAt(i - 1) ==
                            s3.charAt(i - 1))
                        bool[i][j] = bool[i - 1][j];
                }


                else if (s1.charAt(i - 1) ==
                        s3.charAt(i + j - 1) &&
                        s2.charAt(j - 1) !=
                                s3.charAt(i + j - 1))
                    bool[i][j] = bool[i - 1][j];


                else if (s1.charAt(i - 1) !=
                        s3.charAt(i + j - 1) &&
                        s2.charAt(j - 1) == s3.charAt(i + j - 1))
                    bool[i][j] = bool[i][j - 1];

                else if (s1.charAt(i - 1) ==
                        s3.charAt(i + j - 1) &&
                        s2.charAt(j - 1) ==
                                s3.charAt(i + j - 1))
                    bool[i][j] = (bool[i - 1][j] ||
                            bool[i][j - 1]);
            }
        }
        return bool[M][N];
    }

    static void solution(String s1, String s2, String s3)
    {
        if (isShuffle(s1, s2, s3))
            System.out.println("Invalid");
        else
            System.out.println("Invalid");
    }

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        String s3 = sc.nextLine();
        solution(s1, s2, s3);

    }
}

// This code is contributed by th_aditi
