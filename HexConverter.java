public class HexConverter {
    public static int currentNumber;
    public static String[] HexList;
    public static void main(String[]args) {
        GetAllTypes(123);
    }
    public static int HexToDecimal(String number){
        int sum = 0;
        for(int i = 0; i < number.length(); i++){
            char HexChar = number.charAt(number.length()-1-i);
            try {
                currentNumber = Integer.parseInt(String.valueOf(HexChar));
            }catch(NumberFormatException nfe){
                switch (HexChar) {
                    case 'a' -> currentNumber = 10;
                    case 'b' -> currentNumber = 11;
                    case 'c' -> currentNumber = 12;
                    case 'd' -> currentNumber = 13;
                    case 'e' -> currentNumber = 14;
                    case 'f' -> currentNumber = 15;
                    default -> throw new IllegalArgumentException("invalid hex digit!");
                }
            }
            sum += (int) (currentNumber * Math.pow(16,i));
        }
        //System.out.println(sum);
        return(sum);
    }

    public static String DecimalToHex(int dec){
        HexList = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
        String Hex = "";
        for(int i = 5; i >= 0; i--){
            if((int) (dec / Math.pow(16, i)) > 0 || i == 0){
                int divisor = (int) Math.pow(16, i);
                int DigitResult = (dec / divisor);
                dec -= DigitResult * divisor;
                Hex = Hex + HexList[DigitResult];
            }else Hex += HexList[0];
        }
        //System.out.println(Hex.replaceAll("^0+", ""));
        return(Hex.replaceAll("^0+", ""));
    }

    public static String DecimalToBinary(int dec){
        int sum = dec;
        String Bin = "";
        for(int i = 30; i >= 0; i--){
            if((int)(sum/Math.pow(2, i)) > 0){
                sum = sum - (int) Math.pow(2, i);
                Bin += "1";
            }else {
                Bin += "0";
            }
        }
        System.out.println(Bin.replaceAll("^0+", ""));
        int i = 0;
        return null;

    }

    public static void GetAllTypes(int dec){
        System.out.println("Decimal: "+dec);
        System.out.println("Hexadecimal: " + DecimalToHex(dec));
        System.out.println("Binary: "+DecimalToBinary(dec));
    }
}
//change intellij
//change from diffrent branch
//another change
//another one from bluej
