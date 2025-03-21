import java.util.ArrayList;
import java.util.HashMap;

public class wordPattern
{
    public static boolean wordPattern(String p, char d, String s)
    {
        if (s.charAt(0) == d || s.charAt(s.length() - 1) == d)
        {
            return false;
        }

        String word = "";
        ArrayList<String> words = new ArrayList<>();
        for (int i = 0; i < s.length();i++)
        {
            if (s.charAt(i) == d)
            {
                words.add(word);
                word = "";
            }else if (s.charAt(i) < 123 && s.charAt(i) > 96)
            {
                word+= s.charAt(i);
            }else
            {
                return false;
            }
        }
        words.add(word);

        if (p.length() != words.size())
        {
            return false;
        }

        HashMap<Character, String> PTW = new HashMap<>();
        HashMap<String, Character> WTP = new HashMap<>();

        for (int i = 0; i < words.size();i++)
        {
            char pChar = p.charAt(i);
            String Word = words.get(i);

            String checkWord = PTW.get(pChar);
            Character checkPIndex = WTP.get(Word);

            if (checkWord != null && !checkWord.equals(Word))
            {
                return false;
            }
            if (checkPIndex != null && checkPIndex != pChar)
            {
                return false;
            }

            PTW.put(pChar, Word);
            WTP.put(Word, pChar);
        }



        return true;
    }

    public static void main(String[] args)
    {
        System.out.println(wordPattern("abba",'?',"dog?cat?cat?dog"));
        System.out.println(wordPattern("abba",'|',"apple|banana|grape|apple"));
        System.out.println(wordPattern("aaaa",',',"dog,cat,cat,dog"));
        System.out.println(wordPattern("aaaa",' ',"ice cream taco day"));
        System.out.println(wordPattern("adxp",' ', "ice cream taco day"));
    }
}
