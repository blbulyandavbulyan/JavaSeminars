package org.blbulyandavbulyan.jseminars.seminar3.homework.utils;
import java.util.function.BiFunction;
class MinMaxAverageForStreams implements MinMaxAverage{
    Integer min;
    Integer max;
    int count = 0;
    int sum = 0;

    public double getAverage(){
        return (double) sum/count;
    }

    public Integer getMin() {
        return min;
    }

    public Integer getMax() {
        return max;
    }

    void putInteger(Integer integer){
        if(min == null)min = integer;
        if(max == null)max = integer;
        if(integer != null){
            count++;
            sum+=integer;
            if(integer > max) max = integer;
            else if(integer < min) min = integer;
        }
    }
    MinMaxAverageForStreams combineToAnother(MinMaxAverageForStreams another){
        MinMaxAverageForStreams result = new MinMaxAverageForStreams();
        BiFunction<Integer, Integer, Integer> takeNotNull = (a, b)->a != null ? a : b;
        if(min != null && another.min != null)
            result.min = Math.min(this.min, another.min);
        else result.min = takeNotNull.apply(this.min, another.min);
        if(max != null && another.max != null)
            result.max = Math.max(this.max, another.max);
        else result.max = takeNotNull.apply(this.max, another.max);
        result.count = count + another.count;
        result.sum = sum + another.sum;
        return result;
    }
};