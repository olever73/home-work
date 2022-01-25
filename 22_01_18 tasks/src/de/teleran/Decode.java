package de.teleran;

public class Decode {
    public static void main(String[] args) {
        System.out.println(decode("4a2b4c1d"));
    }

    private static String decode(String encodedString) {
        String decodedString = null;
        //aaabbbcccccdd
        //3a3b5c2d

        int n = encodedString.length();
        StringBuilder sb= new StringBuilder();
        for (int i = 0; i < n; i++) {
            if(i+1 <n && i%2 ==0)
                sb.append(repeat(Integer.parseInt(String.valueOf(encodedString.charAt(i))),encodedString.charAt(i+1)));
        }

        return sb.toString();

    }

    private static String repeat(int length, char charAt) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < length; j++) {
            sb.append(charAt);
        }
        return sb.toString();
    }
    public class decoding {

        public static void main(String[] args) {
            String src = "4a2b4c1d";
            StringBuilder dest = new StringBuilder();

            for (int i = 0; i < src.length() - 1; i = i + 2) {
                char charAt = src.charAt(i);
                int cnt = src.charAt(i + 1) - '0';
                for (int j = 0; j < cnt; j++) {
                    dest.append(charAt);
                }
            }
            System.out.println(dest.toString());
        }
    }


}













