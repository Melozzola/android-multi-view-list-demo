package riz.silvano.listutilsdemo.model;

/**
 * Two values row model
 *
 * Created by mele on 08/09/2013.
 */
public class TwoValues
{

    private String value1;
    private Integer value2;

    public TwoValues(String value1, Integer value2)
    {
        this.value1 = value1;
        this.value2 = value2;
    }

    public String getValue1()
    {
        return this.value1;
    }

    public Integer getValue2()
    {
        return this.value2;
    }

}
