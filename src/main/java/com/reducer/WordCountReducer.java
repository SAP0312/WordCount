package com.reducer;

import com.utils.Counters;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


import java.io.IOException;


// Reducer for Word Count
public class WordCountReducer extends Reducer<Text, IntWritable,Text,IntWritable> { //  Reducer for wordCount

    public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException,InterruptedException {

        int count=0;

        for(IntWritable value:values){
        count++;
        }
        context.write(key,new IntWritable(count));
        Character firstChar = key.toString().charAt(0);

        if(Character.isDigit(firstChar)){
            context.getCounter("UserDefined Counter", Counters.Words.DIGIT.name()).increment(1);
        }
        else
            context.getCounter("User Defined Counters",Counters.Words.ALPHABET.name()).increment(1);
    }
}
