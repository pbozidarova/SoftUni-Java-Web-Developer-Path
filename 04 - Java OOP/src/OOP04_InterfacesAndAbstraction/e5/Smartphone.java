package OOP04_InterfacesAndAbstraction.e5;

import java.util.List;

public class Smartphone implements Callable, Browsable{
   private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls){
        this.numbers = numbers;
        this.urls = urls;
    }


    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        for (String url : urls) {
            Boolean isValid = true;
            for (int i = 0; i < url.length(); i++) {
                if(Character.isDigit(url.charAt(i))){
                    sb.append("Invalid URL!");
                    isValid = false;
                    break;
                }
            }
            if(isValid)   {
                sb.append("Browsing: "+ url +"!" + System.lineSeparator());
            }
        }
        return sb.toString();
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        for (String number : this.numbers) {
            Boolean isValid = true;
            for (int i = 0; i < number.length(); i++) {
                if(!Character.isDigit(number.charAt(i))){
                    sb.append("Invalid number!");
                    isValid = false;
                    break;
                }
            }
           if(isValid){
               sb.append("Calling... " + number + System.lineSeparator());
           }
        }
        return sb.toString();
    }
}
