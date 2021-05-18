package com.company;

import java.util.*;

public class Crawler {
    private String URL;
    private static int maxDepth;
    public static int CountThreads;

    public static int WaitingThreads = 0;
    public static int CountURLs = 0;

    public static int getMaxDepth() { return maxDepth; }

    public Crawler(String URL, int maxDepth, int countThreads){
        this.URL = URL;
        Crawler.maxDepth = maxDepth;
        Crawler.CountThreads = countThreads;
    }

    public void run() {
        CrawlerTask task = new CrawlerTask(new URLDepthPair(URL,0));
        task.start();
    }

    private static void printResult(){
        System.out.println();
        System.out.println("Total link count: " + CountURLs);
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter URL");
        String url = scanner.nextLine();
        System.out.println("Enter max depth");
        int maxDepth = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter threads count");
        int countThreads = Integer.parseInt(scanner.nextLine());

        Crawler crawler = new Crawler(url, maxDepth, countThreads);
        crawler.run();

        Runtime.getRuntime().addShutdownHook(new Thread(()->printResult()));
    }
}
