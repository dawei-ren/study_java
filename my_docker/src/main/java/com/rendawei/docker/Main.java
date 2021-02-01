package com.rendawei.docker;

import org.apache.commons.cli.*;

public class Main {
  public static void main(String[] args) {
    CommandLineParser parser = new DefaultParser();
    Options options = new Options();

    options.addOption(Option.builder().longOpt("name").required().desc("name").hasArg().build());
    options.addOption(Option.builder().longOpt("age").required().desc("age").hasArg().build());

    try {
      CommandLine line = parser.parse(options, args);
      String name = line.getOptionValue("name",null);
      String  age = line.getOptionValue("age", null);
      System.out.println("Hello " + name + " " + age);
    } catch (ParseException e) {
      e.printStackTrace();
      HelpFormatter formatter = new HelpFormatter();
      formatter.printHelp("java", options);
    }
  }
}
