// package com.jobs

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Domain {

    public static void main(String[] args) {
        Map<String, Integer> domainsAmountMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String email = scanner.nextLine();
            if(email.isBlank()) {
                break;
            }
            int index = email.indexOf('@');
            if (index != -1) {
                String domain = email.substring(index + 1);
                domainsAmountMap.put(domain, domainsAmountMap.getOrDefault(domain, 0) + 1);
            }
        }

        domainsAmountMap.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry<String, Integer>::getValue).reversed()
                        .thenComparing(Map.Entry::getKey))
                .limit(10)
                .forEach(entry -> System.out.println(entry.getKey() + ' ' + entry.getValue()));
    }
}
