package riz.silvano.listutilsdemo.model;

/**
 * Three values row model
 *
 * Created by mele on 08/09/2013.
 */
public class ThreeValues
{

    private String value1;
    private Integer value2;
    private Boolean value3;

    public ThreeValues(String value1, Integer value2, Boolean value3)
    {
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
    }

    public String getValue1()
    {
        return this.value1;
    }

    public Integer getValue2()
    {
        return this.value2;
    }

    public Boolean getValue3()
    {
        return this.value3;
    }
}
