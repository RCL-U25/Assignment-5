import java.util.HashMap;
import java.util.ArrayList;
public class RadixSortStrings {
    public static int getMaxLength(String[] array)
    {
        int maxChars = array[0].length();
        for (int i = 1; i < array.length;i++)
            if (array[i].length() > maxChars)
                maxChars = array[i].length();

        return maxChars;
    }

    public static void SortByIndex(String[] array, int pos)
    {
            HashMap <Character, ArrayList<String>> buckets = new HashMap<>();

            for (char c = 'A'; c <= 'Z'; c++)
                buckets.put(c, new ArrayList<String>());
            for (char c = 'a'; c <= 'z'; c++)
                buckets.put(c, new ArrayList<>());
            buckets.put(' ',new ArrayList<>());

            for (int j = 0; j < array.length; j++)
            {
                if (pos < array[j].length())
                {
                    char c = array[j].charAt(pos);
                    buckets.get(c).add(array[j]);
                }
                else
                {
                    buckets.get(' ').add(array[j]);
                }
            }
            int arrayIndex = 0;
            for (int i = 0; i < buckets.get(' ').size();i++)
            {
                array[arrayIndex] = buckets.get(' ').get(i);
                arrayIndex++;
            }

            for (char c = 'A'; c <= 'Z'; c++)
            {
                for (int i = 0; i < buckets.get(c).size(); i++)
                {
                    array[arrayIndex] = buckets.get(c).get(i);
                    arrayIndex++;
                }
            }
            for (char c = 'a'; c <= 'z'; c++)
            {
                for (int i = 0; i < buckets.get(c).size(); i++)
                {
                    array[arrayIndex] = buckets.get(c).get(i);
                    arrayIndex++;
                }
            }
        }
        public static void RadixSort(String[] array)
        {
            int maxLength = getMaxLength(array);
            for (int i = maxLength - 1; i >= 0; i--)
            {
                SortByIndex(array, i);
            }
        }

        public static void main(String[] args)
        {
            String[] array = {"Google", "gojo", "amazingly", "jogo", "luna", "pup", "Solas", "solo", "pupperino", "amaterasu",
                "amazon", "puppy", "Hydra", "Amazonia", "Vueltiao"};
            System.out.println("Unsorted Strings: ");

            for (int i = 0; i < array.length; i++)
            {
                System.out.print(array[i] + " ");
            }

            RadixSort(array);

            System.out.println();
            System.out.println("Strings after sort: ");
            for (int i = 0; i < array.length; i++)
            {
                System.out.print(array[i] + " ");
            }

        }
    }



