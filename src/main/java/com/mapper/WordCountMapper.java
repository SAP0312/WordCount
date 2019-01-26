package com.mapper;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

// Mapper class for Word Count Programme
public class WordCountMapper extends Mapper<LongWritable, Text,Text, IntWritable> {
    @Override
    public void map(LongWritable key,Text value,Context context) throws IOException, InterruptedException{
       String line = value.toString();
       for(String str:line.split("\\t")) // Splitting text into different words
       {
           // Replacing all non alphanumeric values from words and writing to the context
           context.write(new Text(str.replaceAll("[^A-Za-z0-9]", "")),new IntWritable(1));

       }
    }
}
