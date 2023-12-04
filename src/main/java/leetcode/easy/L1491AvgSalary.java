package leetcode.easy;

//[4000,3000,1000,2000]
//[1000,2000,3000]
//[6000,5000,4000,3000,2000,1000]
//[8000,9000,2000,3000,6000,1000]
public class L1491AvgSalary {

    public double average(int[] salary) {

        double avg = salary[0];

        int max = salary[0];
        int min = salary[0];

        for( int i = 1; i < salary.length; i++ ){

            max = Math.max(max, salary[i]);
            min = Math.min(min, salary[i]);

            avg += salary[i];

        }

        return (avg - max - min) / (salary.length - 2);
    }

}
