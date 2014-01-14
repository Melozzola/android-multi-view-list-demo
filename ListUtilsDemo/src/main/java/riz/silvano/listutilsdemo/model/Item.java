package riz.silvano.listutilsdemo.model;

import java.util.Date;

/**
 * Created by mele on 11/10/2013.
 */
public class Item
{

    private String description;
    private Integer quantity;
    private Date date;

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Integer getQuantity()
    {
        return quantity;
    }

    public void setQuantity(Integer quantity)
    {
        this.quantity = quantity;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }
}
