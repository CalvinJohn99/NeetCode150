import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

public class Main {

    static class SupermarketCheckout {
        // private Map<Long, Queue<long[]>> map;
        Map<Long, Queue<long[]>> map;

        public SupermarketCheckout() {
            map = new HashMap<>();
        }

        public void onCustomerEnter(long customerId, long lineNumber, long numItems) {
            Queue<long[]> q = new LinkedList<>();
            map.putIfAbsent(lineNumber, q);
            map.get(lineNumber).add(new long[]{customerId, numItems});
        }

        public void onBasketChange(long customerId, long newNumItems) {
            for (long lineNumber : map.keySet()) {
                Queue<long[]> q = map.get(lineNumber);
                for (long[] customerBasket : q) {
                    if (customerBasket[0] == customerId) {
                        customerBasket[1] = newNumItems;
                        return;
                    }
                }
            }
        }

        public void onLineService(long lineNumber, long numProcessedItems) {
            Queue<long[]> q = map.get(lineNumber);
            if (q == null || q.isEmpty()) {
                return;
            }
            while (numProcessedItems > 0) {
                long[] customerBasket = q.peek();
                long toProcessNext = 0;
                if (numProcessedItems > customerBasket[1]) {
                    toProcessNext = numProcessedItems - customerBasket[1];
                    customerBasket[1] = 0;
                } else {
                    customerBasket[1] -= numProcessedItems;
                }
                if (customerBasket[1] <= 0) {
                    q.poll();
                    onCustomerExit(customerBasket[0]);
                }
                numProcessedItems = toProcessNext;
            }
        }

        public void onLinesService() {
            for (long lineNumber : map.keySet()) {
                Queue<long[]> q = map.get(lineNumber);
                if (q == null || q.isEmpty()) {
                    continue;
                }
                long[] customerBasket = q.peek();
                customerBasket[1] -= 1; 
                if (customerBasket[1] <= 0) {
                    q.poll();
                    onCustomerExit(customerBasket[0]);
                }
            }
        }

        private void onCustomerExit(long customerId) {
            // Don't change this implementation.
            System.out.println(customerId);
        }
    };

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide commands");
            return;
        }
        
        // Initialize Scanner to read from the file
        try {
            File file = new File(args[0]);
            Scanner scanner = new Scanner(file);

            SupermarketCheckout supermarketCheckout = new SupermarketCheckout();

            int n = Integer.parseInt(scanner.nextLine().trim()); // Read number of commands
            for (int i = 0; i < n; i++) {
                String line = scanner.nextLine().trim();
                String[] commands = line.split(" ");

                switch (commands[0]) {
                    case "CustomerEnter":
                        supermarketCheckout.onCustomerEnter(
                            Long.parseLong(commands[1]),
                            Long.parseLong(commands[2]),
                            Long.parseLong(commands[3])
                        );
                        break;
                    case "BasketChange":
                        supermarketCheckout.onBasketChange(
                            Long.parseLong(commands[1]),
                            Long.parseLong(commands[2])
                        );
                        break;
                    case "LineService":
                        supermarketCheckout.onLineService(
                            Long.parseLong(commands[1]),
                            Long.parseLong(commands[2])
                        );
                        break;
                    case "LinesService":
                        supermarketCheckout.onLinesService();
                        break;
                    default:
                        System.out.println("Invalid command: " + commands[0]);
                        break;
                }
            }

            scanner.close();  // Close the scanner after finishing

        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found.");
        } catch (NumberFormatException e) {
            System.err.println("Error: Invalid number format in input.");
        }

        // SupermarketCheckout supermarketCheckout = new SupermarketCheckout();
        // int i = 0;
        // while (i < args.length) {
        //     String[] commands = args[i].split(" ");
        //     if (commands[0].equals("CustomerEnter")) {
        //         supermarketCheckout.onCustomerEnter(Long.parseLong(commands[1]), Long.parseLong(commands[2]), Long.parseLong(commands[3]));
        //     } else if (commands[0].equals("BasketChange")) {
        //         supermarketCheckout.onBasketChange(Long.parseLong(commands[1]), Long.parseLong(commands[2]));
        //     } else if (commands[0].equals("LineService")) {
        //         supermarketCheckout.onLineService(Long.parseLong(commands[1]), Long.parseLong(commands[2]));
        //     } else if (commands[0].equals("LinesService")) {
        //         supermarketCheckout.onLinesService();
        //     }
        //     i++;
        // }
    }
}