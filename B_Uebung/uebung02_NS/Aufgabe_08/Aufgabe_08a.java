package B_Uebung.uebung02_NS.Aufgabe_08;

public class Aufgabe_08a {

    public static void main(String[] args){
        StringBuilder recombinedArguments = new StringBuilder();
        
        for(int i = 0; i < args.length; i++){
            recombinedArguments.append(args[i]);
        }

        while(recombinedArguments.indexOf("del") != -1){
            int index = recombinedArguments.indexOf("del");

            recombinedArguments.delete(index, index + 4);
        }

        System.out.println(recombinedArguments);
    }
    
}
