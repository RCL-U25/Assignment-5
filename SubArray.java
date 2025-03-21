public class SubArray
{
    public static int[] SubArray (int[] A, int K)
    {
        int sum = 0;
        int left = 0;
        int[] SubArray = {-1,-1};

        for (int right = 0; right < A.length;right++)
        {
            sum += A[right];
            while (sum > K && left <= right)
            {
                sum -= A[left];
                left++;
            }
            if (sum == K)
            {
                SubArray[0] = left;
                SubArray[1] = right;
                return SubArray;
            }
        }
        return SubArray;
    }

    public static void main(String[] args)
    {
        int[] A = {1, 2, 3, 7, 5};

        int[] sub =SubArray(A,12);
        for (int i = 0; i < sub.length;i++)
        {
            System.out.print(sub[i]);
        }

        System.out.println();

        sub = SubArray(A,5);
        for (int i = 0; i < sub.length;i++)
        {
            System.out.print(sub[i]);
        }

        System.out.println();
        sub = SubArray(A,7);
        for (int i = 0; i < sub.length;i++)
        {
            System.out.print(sub[i]);
        }
        System.out.println();
        sub = SubArray(A,11);
        for (int i = 0; i < sub.length;i++)
        {
            System.out.print(sub[i]);
        }


    }
}
