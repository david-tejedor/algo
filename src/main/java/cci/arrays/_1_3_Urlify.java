package cci.arrays;

public class _1_3_Urlify {

    public static void main(String[] args) {
        char[] url = {'M', 'r', ' ', 'J', 'o', 'h', 'n', ' ', 'S', 'm', 'i', 't', 'h', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        System.out.println(urlify(url, 13));
    }

    static char[] urlify(char[] url, int trueLength) {
        int freeSpaces = 0;
        for (int i = 0; i < trueLength - 1; i++) {
            if (url[i] == ' ') {
                freeSpaces += 2;
            }
        }

        for (int i = trueLength - 1; i >= 0 && freeSpaces > 0; i--) {
            if (url[i] != ' ') {
                url[i + freeSpaces] = url[i];
            } else {
                url[i + freeSpaces] = '0';
                url[i + freeSpaces - 1] = '2';
                url[i + freeSpaces - 2] = '%';
                freeSpaces -= 2;
            }
        }

        return url;
    }

}
