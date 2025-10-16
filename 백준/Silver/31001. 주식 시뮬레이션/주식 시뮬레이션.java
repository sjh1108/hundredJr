import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    // A class to hold all information about a single company
    static class Company {
        int group;
        String name;
        long price;

        public Company(int group, String name, long price) {
            this.group = group;
            this.name = name;
            this.price = price;
        }
    }

    public static void main(String[] args) throws IOException {
        // Use fast I/O for performance
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // Number of companies
        long M = Long.parseLong(st.nextToken());  // Initial cash
        int Q = Integer.parseInt(st.nextToken());   // Number of commands

        // --- Data Structures ---
        // 1. Map for quick lookup of company data by its name (String)
        Map<String, Company> companyMap = new HashMap<>();
        // 2. Map to quickly find all company names (String) in a given group (Integer)
        Map<Integer, List<String>> groupMap = new HashMap<>();
        // 3. Map to store the number of shares (Integer) you own for each company (String)
        Map<String, Integer> portfolio = new HashMap<>();

        // Read initial company data and populate the maps
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            String h = st.nextToken();
            long p = Long.parseLong(st.nextToken());

            Company company = new Company(g, h, p);
            companyMap.put(h, company);
            
            // Add the company name to the corresponding group list.
            // computeIfAbsent ensures the list is created if it's the first company in that group.
            groupMap.computeIfAbsent(g, k -> new ArrayList<>()).add(h);
        }

        long currentCash = M;
        StringBuilder sb = new StringBuilder(); // Efficiently build the output string

        // Process all Q commands
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());

            switch (command) {
                case 1: { // Buy shares
                    String companyName = st.nextToken();
                    int sharesToBuy = Integer.parseInt(st.nextToken());
                    
                    long currentPrice = companyMap.get(companyName).price;
                    long totalCost = currentPrice * sharesToBuy;
                    
                    // Only buy if you have enough cash
                    if (currentCash >= totalCost) {
                        currentCash -= totalCost;
                        portfolio.put(companyName, portfolio.getOrDefault(companyName, 0) + sharesToBuy);
                    }
                    break;
                }
                case 2: { // Sell shares
                    String companyName = st.nextToken();
                    int sharesToSellRequest = Integer.parseInt(st.nextToken());
                    
                    int ownedShares = portfolio.getOrDefault(companyName, 0);

                    if (ownedShares > 0) {
                        // Sell either the requested amount or all owned shares if the request is larger
                        int actualSharesToSell = Math.min(sharesToSellRequest, ownedShares);
                        
                        long currentPrice = companyMap.get(companyName).price;
                        long proceeds = currentPrice * actualSharesToSell;
                        currentCash += proceeds;
                        
                        // Update portfolio
                        portfolio.put(companyName, ownedShares - actualSharesToSell);
                    }
                    break;
                }
                case 3: { // Change the price of a specific company by a fixed amount
                    String companyName = st.nextToken();
                    int priceChange = Integer.parseInt(st.nextToken());
                    
                    companyMap.get(companyName).price += priceChange;
                    break;
                }
                case 4: { // Change the price for all companies in a group by a fixed amount
                    int groupNum = Integer.parseInt(st.nextToken());
                    int priceChange = Integer.parseInt(st.nextToken());
                    
                    if (groupMap.containsKey(groupNum)) {
                        for (String companyName : groupMap.get(groupNum)) {
                            companyMap.get(companyName).price += priceChange;
                        }
                    }
                    break;
                }
                case 5: { // Change the price for all companies in a group by a percentage
                    int groupNum = Integer.parseInt(st.nextToken());
                    int percentChange = Integer.parseInt(st.nextToken());

                    if (groupMap.containsKey(groupNum)) {
                        for (String companyName : groupMap.get(groupNum)) {
                            Company company = companyMap.get(companyName);
                            long currentPrice = company.price;
                            // Calculate new price. Using double for precision during calculation.
                            long newPrice = (long)(currentPrice * (100.0 + percentChange) / 100.0);
                            // Truncate the one's digit as per the problem description
                            company.price = (newPrice / 10) * 10;
                        }
                    }
                    break;
                }
                case 6: { // Report current cash
                    sb.append(currentCash).append("\n");
                    break;
                }
                case 7: { // Report total assets (cash + value of all stocks)
                    long totalStockValue = 0;
                    for (Map.Entry<String, Integer> entry : portfolio.entrySet()) {
                        String companyName = entry.getKey();
                        int ownedShares = entry.getValue();
                        
                        if (ownedShares > 0) {
                            long currentPrice = companyMap.get(companyName).price;
                            totalStockValue += currentPrice * ownedShares;
                        }
                    }
                    long totalAssets = currentCash + totalStockValue;
                    sb.append(totalAssets).append("\n");
                    break;
                }
            }
        }
        
        // Print all collected results at once at the end
        System.out.print(sb.toString());
    }
}