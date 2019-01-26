package com.driver;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class WordCountDriver extends Configured implements Tool {

    public static void main(String[] args) throws  Exception {
        int res = ToolRunner.run(new Configuration(),new WordCountDriver(),args);
        System.exit(res);
    }
    public int run(String[] args) throws Exception{
        Configuration configuration = new Configuration();
        Job job = Job.getInstance(configuration,"Word Count");
        job.setJarByClass(WordCountDriver.class);
        job.setMapperClass(WMapper.class);
        job.setReducerClass(WReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

    }
}