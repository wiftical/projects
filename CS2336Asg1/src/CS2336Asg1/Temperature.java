package CS2336Asg1;

//temperature class
public class Temperature {
    //fahrenheitToC method with parameter F
    public double fahrenheitToC (double F)
    {
        //return value minus 32 divided by 1.8
        return (F-32)/1.8;
    };
    //celsiusToF method with parameter C
    public double celsiusToF (double C)
    {
        //return value times 1.8 plus 32
        return (C*1.8)+32;
    }
}