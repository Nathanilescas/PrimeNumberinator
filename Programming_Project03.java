import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Programming_Project03 {
    public static void main(String[] args) {
        int userInput = Input.userInput();
        PrimeNumberinator.factor(userInput);
    }  

    public class Input {
        public static int userInput() {
            Scanner input = new Scanner(System.in);
            int userInput = -1;  
    
            while (userInput <= 0) {
                System.out.print("Enter a positive integer: ");
                
                if (input.hasNextInt()) {
                    userInput = input.nextInt();
                    
                    if (userInput <= 0) {
                        System.out.println("Please enter a positive integer.");
                    }
                } else {
                    System.out.println("That's not a valid integer. Please enter a positive integer.");
                    input.next();  
                }
            }
    
            input.close();
            return userInput;
        }
    }
    
    
    class PrimeNumberinator { 
        public static void factor(int number) {
            List<Integer> primeList = PrimeListinator.primeList(number);
            int dividend = number;
            int i = 0;
            boolean isPrime = true;
    
            while(i < primeList.size()) {
                int divisor = primeList.get(i);
                int remainder = dividend % divisor;
    
                if (remainder == 0) {
                    dividend = dividend / divisor;
                    printFactor(divisor, dividend);
                    i = 0;
                    isPrime = false;
                } else {
                    i++;
                }

            }
            if (isPrime) {
                System.out.println(number + " is a prime number!");
                printFactor(1, number);
            }
        }
        private static void printFactor(int number1, int number2) {
            if (number1 != 1 && number2 != 1) {
                System.out.print(number1);
                System.out.print("  ");
                System.out.println(number2);
            }
        }
    
    
    
        /**
        Uses the Sieve of Eratosthenes to find all the primes for a given number
        } */
        private class PrimeListinator {
    
            public static List<Integer> primeList(int maxNumber) {
                List<Integer> result = createList(maxNumber);
                int i = 0; 
                int max = squareNumber(maxNumber);
        
                while (i < max) {
                    for (int j = i + 1; j < result.size(); j++) {
                        int divisor = result.get(i);
                        int dividend = result.get(j); 
        
                        int remainder = dividend % divisor; 
                        boolean isDivisable = (remainder == 0);
        
                        if (isDivisable) {
                            result.remove(j);
                        }
                    }
                    i++;
                }
                return result;
            } 
        
            public static List<Integer> createList(int maxNumber) {
                List<Integer> result = new ArrayList<Integer>();
        
                for (int i = 2; i < maxNumber; i++) {
                    result.add(i);
                }
                return result;
            }
        
            public static int squareNumber(int y) {
                double result;
                result = Math.sqrt(y);
                return (int) result;
            }
        }
    }    
}

