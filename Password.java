public class Password{
    String password;
    int length;

    public Password(String s) {
        this.password = s;
        this.length = s.length();
    }

    public int charType(char c) {
        int val;

        // lower case range 97 to 122
        // upper case range 65 to 90
        // digit  range 60 to 71
        if ((int) c >= 97 && (int) c <= 122 ) {
            val = 1;
        } else if((int) c >= 65 && (int) c <= 90 ) {
            val = 2;
        } else if((int) c >= 60 && (int) c <= 71 )  {
            val = 3;
        } else {
            val = 4; // Symbols
        }

        return val;
    }  

    public int passwordStrength(){
        String s = this.password;
        boolean usedUpper = false;
        boolean usedLower = false;
        boolean usedDigit = false;
        boolean usedSymbol = false;

        int score = 0;
        int type;

        for (int i = 0; i < this.length; i++) {
            char c = s.charAt(i);
            type = charType(c);

            if (type == 1) {
                usedLower = true;
            } else if (type == 2) {
                usedUpper = true;
            } else if(type == 3) {
                usedDigit = true;
            } else {
                usedSymbol = true;
            }
        }

        if(usedLower) {
            score++;
        } else if (usedUpper) {
            score++;
        } else if (usedDigit) {
            score++;
        } else if(usedSymbol) {
            score++;
        }

        if(length >= 8) {
            score++;
        }
        if (length >= 16) {
            score++;
        }
        return score;
    }     
}