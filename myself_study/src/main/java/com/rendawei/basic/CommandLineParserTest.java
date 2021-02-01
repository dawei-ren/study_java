package com.rendawei.basic;

import org.apache.commons.cli.*;


/*
* 依赖：
*
*       <dependency>
            <groupId>commons-cli</groupId>
            <artifactId>commons-cli</artifactId>
            <version>1.3.1</version>
        </dependency>
*
*
*
* */
public class CommandLineParserTest {
    public static void main(String[] args) {

        CommandLineParser parser = new DefaultParser();
        Options options = new Options();

        options.addOption(Option.builder().longOpt("name").required().desc("姓名").hasArg().build());
        options.addOption(Option.builder().longOpt("age").required().desc("年龄").hasArg().build());

        try {
            CommandLine line = parser.parse(options, args);
            String name = line.getOptionValue("name",null);
            String  age = line.getOptionValue("age", null);
            System.out.println(name + " " + age);
        } catch (ParseException e) {
            e.printStackTrace();
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("java", options);
        }
    }
}
