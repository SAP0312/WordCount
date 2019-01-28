package com.reducer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


import java.io.IOException;


// Reducer for Word Count
public class WordCountReducer extends Reducer<Text, IntWritable,Text,IntWritable> { //  Reducer for wordCount

    public void reduce(Text text, Iterable<IntWritable> values, Context context) throws IOException,InterruptedException {

        int count=0;

        for(IntWritable value:values){
        count++;
        }
        context.write(text,new IntWritable(count));

    }
}
