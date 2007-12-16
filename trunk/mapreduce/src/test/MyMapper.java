package test;
import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;


public class MyMapper extends MapReduceBase implements Mapper {

	private final static IntWritable one = new IntWritable(1);
	private Text word = new Text();

	public void map(WritableComparable key, Writable values,
			OutputCollector output, Reporter reporter) throws IOException {
		String line = values.toString();
		StringTokenizer tokenizer = new StringTokenizer(line);
		while (tokenizer.hasMoreTokens()) {
			word.set(tokenizer.nextToken());
			output.collect(word, one);
		}

	}
}
