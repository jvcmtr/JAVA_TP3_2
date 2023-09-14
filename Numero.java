public class Numero {
    private int value;
    private String[] traducao = new  String[]{
        "zero", "um",
        "dois", "tres",
        "quatro", "cinco",
        "seis", "sete",
        "oito", "nove"
    } ;

    public Numero(String s){
        value = Integer.parseInt(s);
    }
    public Numero(int init){
        value = init;
    }

    public int getValue(){
        return value;
    }

    public String getDigitosPorExtenso(){
        String result = "";

        for (int i = 0; i < getMagnitude(value) ; i++) {
            int digit = getDigitByMagnitude(i);
            result = traducao[digit] + ", " + result;
        }
        return result.replaceAll(" ,$", "");
    }

    public String OptimizedGetDigitosPorExtenso(){
        String result = "";
        for (int mag = 1; value-mag > 1 ; mag*=10) {
            int digit = (value/mag) % 10;
            result = traducao[digit] + ", " + result;
        }
        return result.replaceAll(" ,$", "");
    }



    
    private int getDigitByMagnitude(int magnitude){
        return (value/getPowTen(magnitude)) % 10;
    }

    private int getMagnitude(int valor){
        int i = valor;
        int mag = 10;
        int counter = 0;
        while(i >= 0){
            i = valor - mag;
            mag *= 10;
            counter ++;
        }
        return counter;
    }

    private int getPowTen(int pow){
        int result = 1;
        for (int i = 0; i < pow; i++) {
            result *= 10;
        }
        return result;
    }
}
